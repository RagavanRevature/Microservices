package com.ragavan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragavan.common.BlogProperties;
import com.ragavan.utils.ConnectionUtil;

@RestController
@RequestMapping("/")
public class BlogController {
	@Autowired
	private BlogProperties blogProperties;

	@GetMapping(value = "check/server")
	public String testMethod() {
		return "The Blog application server is UP";
	}

	@GetMapping(value = "login")
	public void checkLogin() {
		ConnectionUtil util = new ConnectionUtil();
		util.print();
	}
}
