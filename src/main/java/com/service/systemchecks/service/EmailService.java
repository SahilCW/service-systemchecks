package com.service.systemchecks.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.service.systemchecks.domain.notification.NotificationConfig;
import com.service.systemchecks.model.MailProxy;
import com.service.systemchecks.utils.CommonUtils;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender emailSender;

	@Async(CommonUtils.B4L_RE_ASYNC_EXECUTOR)
    public void sendMailWithTemplate(NotificationConfig config,MailProxy mailProxy) throws MessagingException, IOException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,StandardCharsets.UTF_8.name());
        helper.setText(mailProxy.getContent(), true);
        helper.setTo(mailProxy.getToList());
        helper.setSubject(mailProxy.getSubject());
        if(!CommonUtils.isObjectNull(mailProxy.getBccList())) {
        	helper.setBcc(mailProxy.getBccList());        	
        }
        if(!CommonUtils.isObjectNull(mailProxy.getCcList())) {
        	helper.setCc(mailProxy.getCcList());        	
        }
        if(!CommonUtils.isObjectNull(mailProxy.getAttachments())) {
        	for(String att : mailProxy.getAttachments()) {
        		helper.addAttachment(att, new ClassPathResource(att));
        	}
        }
        emailSender.send(message);
    }
    
	@Async(CommonUtils.B4L_RE_ASYNC_EXECUTOR)
    public void sendSimpleTextMail(NotificationConfig config,MailProxy mailProxy) throws MessagingException, IOException {
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailProxy.getToList());
        msg.setSubject(mailProxy.getSubject());
        msg.setText(mailProxy.getContent());
        msg.setBcc(mailProxy.getBccList());
        msg.setCc(mailProxy.getCcList());
        emailSender.send(msg);
    }
}
