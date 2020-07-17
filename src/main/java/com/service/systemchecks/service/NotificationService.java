package com.service.systemchecks.service;

import java.util.Map;

import com.service.systemchecks.model.NotificationProxy;


public interface NotificationService {
	/**
	 * Send Notification on Email or Mobile based on Properties Set 
	 * @param proxy
	 * @return
	 */
	public boolean send(NotificationProxy proxy);
	
	/**
	 * Process Template and Return Processed String
	 * @param data
	 * @param templateName
	 * @return
	 */
	public String processTemplate(Map<String, Object> data,String templateName);
	
	/**
	 * Verify OTP
	 * @param otp
	 * @param mobile
	 * @return
	 */
	public String verifyOtp(String otp,String sessionKey);
	
}
