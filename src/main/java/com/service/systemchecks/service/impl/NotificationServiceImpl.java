package com.service.systemchecks.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.service.systemchecks.domain.notification.NotificationConfig;
import com.service.systemchecks.domain.notification.NotificationLog;
import com.service.systemchecks.model.MailProxy;
import com.service.systemchecks.model.NotificationProxy;
import com.service.systemchecks.model.SMSProxy;
import com.service.systemchecks.repository.notification.NotificationConfigRepo;
import com.service.systemchecks.repository.notification.NotificationLogRepo;
import com.service.systemchecks.service.EmailService;
import com.service.systemchecks.service.NotificationService;
import com.service.systemchecks.service.SMSService;
import com.service.systemchecks.utils.CommonUtils;
import com.service.systemchecks.utils.ContentType;
import com.service.systemchecks.utils.NotificationStatus;
import com.service.systemchecks.utils.Provider;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service
public class NotificationServiceImpl implements NotificationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Autowired
	private NotificationConfigRepo notificationConfigRepo;
	
	@Autowired
	private SMSService sMSService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private Configuration configuration;
	
	@Autowired
    private NotificationLogRepo notificationLogRepo; 
	
	@Transactional
	@Override
	public boolean send(NotificationProxy proxy) {
		if(CommonUtils.isObjectListNull(proxy,proxy.getContentType(),proxy.getConfigType())) {
			throw new NullPointerException("Notification Object Or Content Type Or Config Type Must not be Null!");
		}
		NotificationConfig notificationConfig = notificationConfigRepo.findBySequenceAndTypeAndIsActive(1,proxy.getConfigType().getId(), true);
		if(CommonUtils.isObjectNull(notificationConfig)) {
			LOGGER.error("No Active SMS Configuration Found In the system.");
			return false;
		}
		if(Provider.MSG91.getId().equals(notificationConfig.getProvider())) {
			if(ContentType.TEMPLATE.getId().equals(proxy.getContentType().getId())) {
				proxy.setContent(processTemplate(proxy.getData(), proxy.getTemplateName()));
			}
			logNotification(proxy);
			return sMSService.sendMsg91(notificationConfig,(SMSProxy)proxy);
		}else if(Provider.CORE_EMAIL.getId().equals(notificationConfig.getProvider())) {
			try {
				if(ContentType.TEMPLATE.getId().equals(proxy.getContentType().getId())) {
					proxy.setContent(processTemplate(proxy.getData(), proxy.getTemplateName()));
				}
				logNotification(proxy);
				emailService.sendMailWithTemplate(notificationConfig,(MailProxy)proxy);
			} catch (MessagingException | IOException e) {
				LOGGER.error("Error while Sending Email = >{0}",new Object [] {e});
			}
			return true;
		}
		return false;
	}
	
	@Override
	 public String processTemplate(Map<String, Object> data,String templateName) {
		 try {
			return FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(templateName), data);
		} catch (IOException | TemplateException e) {
			LOGGER.error("Error while Processing Templated : ",e);
		}
		 return null;
	}
	
	@Async(CommonUtils.B4L_RE_ASYNC_EXECUTOR)
	private Boolean logNotification(NotificationProxy notificationProxy) {
		NotificationLog log = new NotificationLog();
		if(notificationProxy instanceof SMSProxy) {
			SMSProxy smsProxy = (SMSProxy) notificationProxy;
			log.setMobile(smsProxy.getMobile());
			log.setData(smsProxy.getMainContent());
		}else {
			MailProxy mailProxy = (MailProxy) notificationProxy;
			if(mailProxy.getToList().length > 1) {
				log.setEmail(Arrays.asList(mailProxy.getToList()).toString());				
			}else if(mailProxy.getToList().length == 1) {
				log.setEmail(mailProxy.getToList()[0]);
			}
			log.setData(mailProxy.getMainContent());
		}
		log.setStatus(NotificationStatus.PENDING.name());
		log.setContentType(notificationProxy.getContentType().getId());
		log.setIsActive(true);
		log.setType(notificationProxy.getConfigType().getId());
		log.setCreatedDate(new Date());
		log.setAuthType(notificationProxy.getAuthType());
		log.setToken(notificationProxy.getToken());
		log.setSessionKey(notificationProxy.getSessionKey());
		notificationLogRepo.save(log);
		return true;
	}

	@Transactional
	@Override
	public String verifyOtp(String otp, String sessionKey) {
		NotificationLog notificationLog = notificationLogRepo.findFirstBySessionKeyAndStatusOrderByIdDesc(sessionKey, NotificationStatus.PENDING.name());
		if(CommonUtils.isObjectNull(notificationLog)) {
			LOGGER.warn("Invalid Session Key = >{0} == OTP =>{1}",new Object[] {sessionKey,otp});
			return NotificationStatus.INVALID_SESSION.name();
		}
		if(!notificationLog.getData().equalsIgnoreCase(otp)){
			LOGGER.warn("Invalid or Expired Otp for Session Key = >{0} == OTP =>{1}",new Object[] {sessionKey,otp});
			return NotificationStatus.INCORRECT_OTP.name();
		}
		if(!CommonUtils.isObjectNull(notificationLog.getCreatedDate())) {
			LocalDateTime now = LocalDateTime.now();
		    LocalDateTime creationDate = notificationLog.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		    long diifMinutes = ChronoUnit.MINUTES.between(creationDate,now);
		    if(diifMinutes > 5) {
		    	LOGGER.warn("Otp == >{0} Is Expired for Session Key => {1}", new Object[] {otp,sessionKey});
		    	notificationLog.setStatus(NotificationStatus.EXPIRED_SESSION.name());
				notificationLog.setModifiedDate(new Date());
				notificationLogRepo.save(notificationLog);
				return NotificationStatus.EXPIRED_SESSION.name();
		    }
		}
		notificationLog.setStatus(NotificationStatus.SUCCESS.name());
		notificationLog.setModifiedDate(new Date());
		notificationLogRepo.save(notificationLog);
		return NotificationStatus.SUCCESS.name();
	}
}
