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
@Table(name = "notification_config")
public class NotificationConfig extends Auditor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 948696097633997655L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_config_seq_gen")
	@SequenceGenerator(name = "notification_config_seq_gen", sequenceName = "notification_config_seq", allocationSize = 1)
	private Long id;
	
	@Column(name = "acc_key")
	private String key;

	private Integer provider;
	
	private Integer route;
	
	private Integer sequence;
	
	private String sender;
	
	@Column(name = "base_url")
	private String baseUrl;
	
	private Integer type;
	
	@Column(name = "country_code")
	private String countryCode;
	

	public NotificationConfig(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getProvider() {
		return provider;
	}

	public void setProvider(Integer provider) {
		this.provider = provider;
	}

	public Integer getRoute() {
		return route;
	}

	public void setRoute(Integer route) {
		this.route = route;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "NotificationConfig [id=" + id + "]";
	}
	
}
