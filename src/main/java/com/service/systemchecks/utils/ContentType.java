package com.service.systemchecks.utils;

public enum ContentType {
	TEMPLATE(1, "Template"),
	TEXT(2, "Text");
	private Integer id;
	private String value;

	private ContentType(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public ContentType getByValue(String value) {
		for (ContentType contentType : ContentType.values()) {
			if (contentType.value.equalsIgnoreCase(value)) {
				return contentType;
			}
		}
		return null;
	}
	
	public ContentType getById(Integer id) {
		for (ContentType contentType : ContentType.values()) {
			if (contentType.getId().equals(id)) {
				return contentType;
			}
		}
		return null;
	}
}