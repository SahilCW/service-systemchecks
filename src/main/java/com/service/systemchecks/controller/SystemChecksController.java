package com.service.systemchecks.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.systemchecks.model.MailProxy;
import com.service.systemchecks.service.NotificationService;
import com.service.systemchecks.utils.ConfigType;
import com.service.systemchecks.utils.ContentType;

@RestController
public class SystemChecksController {
	
	@Autowired
	private NotificationService notificationService;

	private static final Logger logger = LoggerFactory.getLogger(SystemChecksController.class);
	
	@GetMapping(value="/ping" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String ping() {

		MailProxy mail = new MailProxy();
		mail.setSubject("Reset your password");
		mail.setToList(new String[] {"akash.jain@onlinepsbloans.com"});
		mail.setContentType(ContentType.TEMPLATE);
		mail.setConfigType(ConfigType.EMAIL);
		
		Map<String, Object> emailParameters = new HashMap<>();
		emailParameters.put("user_name", "swayam jain");
		emailParameters.put("email", "myemail@gmail.com");
		mail.setData(emailParameters);
		mail.setTemplateName("myemail.ftl");
		notificationService.send(mail);
		
		return "System Checks Running";
	}
	
}
