package com.service.systemchecks.utils;

public enum Provider {
	CORE_EMAIL(1, "CoreEmail"),
	MSG91(2, "MSG91");
	
	private Integer id;
	private String value;

	private Provider(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public Provider getByValue(String value) {
		for (Provider provider : Provider.values()) {
			if (provider.value.equalsIgnoreCase(value)) {
				return provider;
			}
		}
		return null;
	}
	
	public Provider getById(Integer id) {
		for (Provider provider : Provider.values()) {
			if (provider.getId().equals(id)) {
				return provider;
			}
		}
		return null;
	}
}
