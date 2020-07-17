package com.service.systemchecks.service;

import com.service.systemchecks.domain.notification.NotificationConfig;
import com.service.systemchecks.model.SMSProxy;

public interface SMSService {
	
	/*
	 * Send Msg 91 SMS to Given Mobile No.
	 */
	public boolean sendMsg91(NotificationConfig config,SMSProxy proxy);
	
}
