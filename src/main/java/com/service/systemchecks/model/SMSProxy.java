package com.service.systemchecks.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSProxy extends NotificationProxy implements Serializable {

	private static final long serialVersionUID = 948696097633997655L;
	
	private String mobile;

	private String otp;
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "SMSProxy [mobile=" + mobile + ", otp=" + otp + "]";
	}
}
