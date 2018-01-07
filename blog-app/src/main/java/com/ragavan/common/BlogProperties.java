package com.ragavan.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {
	@Value("${JDBC_USERNAME}")
	private String jdbcUsername;

	@Value("${JDBC_PASSWORD}")
	private String jdbcPassword;

	@Value("${JDBC_URL}")
	private String jdbcURL;

	@Value("${JDBC_DRIVER}")
	private String jdbcDriver;

	public String getJdbcUsername() {
		return jdbcUsername;
	}

	@Bean
	public BlogProperties getBlogConfig() {
		final BlogProperties blogProperties = new BlogProperties();
		blogProperties.jdbcPassword = this.getJdbcPassword();
		blogProperties.jdbcUsername = this.getJdbcUsername();
		blogProperties.jdbcURL = this.getJdbcURL();
		blogProperties.jdbcDriver = this.getJdbcDriver();
		return blogProperties;
	}

	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

	public String getJdbcURL() {
		return jdbcURL;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
}
