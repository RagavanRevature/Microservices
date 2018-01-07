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

	public String getJdbcUsername() {
		return jdbcUsername;
	}

	@Bean
	public BlogProperties getBlogConfig() {
		return this;
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
}
