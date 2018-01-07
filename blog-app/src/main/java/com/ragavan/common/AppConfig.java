package com.ragavan.common;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ragavan.common.BlogProperties;

@Component
@ComponentScan(basePackages = "com.ragavan")
public class AppConfig {
	@Autowired
	BlogProperties blogProperties;

	@Bean
	public BasicDataSource dataSource() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(blogProperties.getJdbcDriver());
		ds.setUrl(blogProperties.getJdbcURL());
		ds.setUsername(blogProperties.getJdbcUsername());
		ds.setPassword(blogProperties.getJdbcPassword());
		return ds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		final JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
}