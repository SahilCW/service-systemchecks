package com.service.systemchecks.utils;

public enum NotificationStatus {
	INVALID_SESSION , INCORRECT_OTP , SUCCESS, PENDING, EXPIRED_SESSION;
	
	public static NotificationStatus fromName(String value) {
		for (NotificationStatus NotificationStatus : NotificationStatus.values()) {
			if (NotificationStatus.name().equalsIgnoreCase(value)) {
				return NotificationStatus;
			}
		}
		return null;
	}
	
}
