package com.service.systemchecks.domain.notification;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.service.systemchecks.domain.common.Auditor;

@Entity
@Table(name = "notification_log")
public class NotificationLog extends Auditor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 948696097633997655L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_log_seq_gen")
	@SequenceGenerator(name = "notification_log_seq_gen", sequenceName = "notification_log_seq", allocationSize = 1)
	private Long id;
	
	private String mobile;
	
	private String email;
	
	private String status;
	
	private Integer type;
	
	private String data;
	
	private String token;
	
	@Column(name = "description",columnDefinition="varchar(1000) default ''")
	private String description;
	
	@Column(name = "url",columnDefinition="varchar(100) default ''")
	private String url;
	
	@Column(name = "extensible_data",columnDefinition="varchar(1000) default ''")
	private String extensibleData;
	
	@Column(name = "session_key")
	private String sessionKey;
	
	@Column(name = "template_name")
	private Integer templateName;
	
	@Column(name = "content_type")
	private Integer ContentType;
	
	@Column(name = "auth_type")
	private Integer authType;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getExtensibleData() {
		return extensibleData;
	}


	public void setExtensibleData(String extensibleData) {
		this.extensibleData = extensibleData;
	}


	public String getSessionKey() {
		return sessionKey;
	}


	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}


	public Integer getTemplateName() {
		return templateName;
	}


	public void setTemplateName(Integer templateName) {
		this.templateName = templateName;
	}


	public Integer getContentType() {
		return ContentType;
	}


	public void setContentType(Integer contentType) {
		ContentType = contentType;
	}


	public Integer getAuthType() {
		return authType;
	}


	public void setAuthType(Integer authType) {
		this.authType = authType;
	}


	@Override
	public String toString() {
		return "NotificationLog [id=" + id + "]";
	}
}
