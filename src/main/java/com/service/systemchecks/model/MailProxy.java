package com.service.systemchecks.model;

import java.io.Serializable;


public class MailProxy extends NotificationProxy implements Serializable {

	private static final long serialVersionUID = 948696097633997655L;
	
	private String [] ccList;
	
	private String [] bccList;
	
	private String [] toList;
	
	private String [] attachments;
	
	private String subject;

	public String[] getCcList() {
		return ccList;
	}

	public void setCcList(String[] ccList) {
		this.ccList = ccList;
	}

	public String[] getBccList() {
		return bccList;
	}

	public void setBccList(String[] bccList) {
		this.bccList = bccList;
	}

	public String[] getToList() {
		return toList;
	}

	public void setToList(String[] toList) {
		this.toList = toList;
	}

	public String[] getAttachments() {
		return attachments;
	}

	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

}
