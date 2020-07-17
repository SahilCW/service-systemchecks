package com.service.systemchecks.utils;

public enum ConfigType {
	SMS(1, "SMS"),
	EMAIL(2, "Email"),
	OTP(3, "Otp");
	private Integer id;
	private String value;

	private ConfigType(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public ConfigType getByValue(String value) {
		for (ConfigType configType : ConfigType.values()) {
			if (configType.value.equalsIgnoreCase(value)) {
				return configType;
			}
		}
		return null;
	}
	
	public ConfigType getById(int id) {
		for (ConfigType configType : ConfigType.values()) {
			if (configType.getId().equals(id)) {
				return configType;
			}
		}
		return null;
	}
}
