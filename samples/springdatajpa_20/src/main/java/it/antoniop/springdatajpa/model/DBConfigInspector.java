package it.antoniop.springdatajpa.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfigInspector {
	
	Logger LOG = LoggerFactory.getLogger(DBConfigInspector.class);
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
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

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		LOG.info("DB connection for DEV - MySQL testdev");
		LOG.info(driverClassName);
		LOG.info(url);
		return "DB Connection to DEV - [testdev DB]";
	}


	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		LOG.info("DB connection for PROD - MySQL test");
		LOG.info(driverClassName);
		LOG.info(url);
		return "DB Connection to PROD - [test DB]";
	} 
}