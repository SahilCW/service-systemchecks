package com.service.systemchecks.config;

public class SystemCheckProperties {


	private String driver;
	private String url;
	private String username;
	private String password;
	private String maxconnections;
	private String minconnections;
	private String maxpartitions;
	private String maxlifetimeinmillis;
	private String connectiontimeoutinmillis;
	
	// Hibernate Properties
	private String hibernateDialect;
	private String hibernateFormatSql;
	private String hibernateHbm2ddlAuto;
	private String hibernateEjbNamingStrategy;
	private String hibernateShowSql;
	private String hibernateEnableLazyLoadNoTrans;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMaxconnections() {
		return maxconnections;
	}
	public void setMaxconnections(String maxconnections) {
		this.maxconnections = maxconnections;
	}
	public String getMinconnections() {
		return minconnections;
	}
	public void setMinconnections(String minconnections) {
		this.minconnections = minconnections;
	}
	public String getMaxpartitions() {
		return maxpartitions;
	}
	public void setMaxpartitions(String maxpartitions) {
		this.maxpartitions = maxpartitions;
	}
	public String getMaxlifetimeinmillis() {
		return maxlifetimeinmillis;
	}
	public void setMaxlifetimeinmillis(String maxlifetimeinmillis) {
		this.maxlifetimeinmillis = maxlifetimeinmillis;
	}
	public String getConnectiontimeoutinmillis() {
		return connectiontimeoutinmillis;
	}
	public void setConnectiontimeoutinmillis(String connectiontimeoutinmillis) {
		this.connectiontimeoutinmillis = connectiontimeoutinmillis;
	}
	public String getHibernateDialect() {
		return hibernateDialect;
	}
	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}
	public String getHibernateFormatSql() {
		return hibernateFormatSql;
	}
	public void setHibernateFormatSql(String hibernateFormatSql) {
		this.hibernateFormatSql = hibernateFormatSql;
	}
	public String getHibernateHbm2ddlAuto() {
		return hibernateHbm2ddlAuto;
	}
	public void setHibernateHbm2ddlAuto(String hibernateHbm2ddlAuto) {
		this.hibernateHbm2ddlAuto = hibernateHbm2ddlAuto;
	}
	public String getHibernateEjbNamingStrategy() {
		return hibernateEjbNamingStrategy;
	}
	public void setHibernateEjbNamingStrategy(String hibernateEjbNamingStrategy) {
		this.hibernateEjbNamingStrategy = hibernateEjbNamingStrategy;
	}
	public String getHibernateShowSql() {
		return hibernateShowSql;
	}
	public void setHibernateShowSql(String hibernateShowSql) {
		this.hibernateShowSql = hibernateShowSql;
	}
	public String getHibernateEnableLazyLoadNoTrans() {
		return hibernateEnableLazyLoadNoTrans;
	}
	public void setHibernateEnableLazyLoadNoTrans(String hibernateEnableLazyLoadNoTrans) {
		this.hibernateEnableLazyLoadNoTrans = hibernateEnableLazyLoadNoTrans;
	}
	
}
