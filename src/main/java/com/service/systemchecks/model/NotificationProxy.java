package com.service.systemchecks.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

import com.service.systemchecks.utils.ConfigType;
import com.service.systemchecks.utils.ContentType;

public class NotificationProxy extends AuditorProxy implements Serializable {

	private static final long serialVersionUID = 948696097633997655L;
	
	private String content;
	
	private String token;
	
	private String mainContent;

	private String templateName;
	
	private String sessionKey;
	
	private ContentType contentType;
	
	private ConfigType configType;
	
	private Map<String,Object> data;
	
	private Integer authType;
	
	public NotificationProxy() {
		super();
		data = Collections.emptyMap();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMainContent() {
		return mainContent;
	}

	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public ConfigType getConfigType() {
		return configType;
	}

	public void setConfigType(ConfigType configType) {
		this.configType = configType;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Integer getAuthType() {
		return authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
	
}
