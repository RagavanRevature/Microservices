package com.ragavan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragavan.data.impl.UserDAOImpl;
import com.ragavan.models.User;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserDAOImpl userDAO;

	@GetMapping(value = "all")
	public List<User> checkLogin() {
		return userDAO.list();
	}
}
