package com.ragavan.utils;

import javax.annotation.Resource;

import com.ragavan.common.BlogProperties;

public class ConnectionUtil {

	@Resource(name = "getBlogConfig")
	private BlogProperties blogProperties;

	public void print() {
		System.out.println(blogProperties.getJdbcPassword());
	}
}
