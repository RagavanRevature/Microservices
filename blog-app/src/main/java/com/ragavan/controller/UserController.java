package com.ragavan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragavan.models.User;
import com.ragavan.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "all")
	public List<User> checkLogin() {
		return userService.list();
	}

	@GetMapping(value = "{userName}")
	public User checkLogin(@PathVariable(name = "userName") String userName) {
		return userService.listOne(userName);
	}

	@PostMapping(value = "save")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
	}

	@PutMapping(value = "update")
	public void updateUser(@RequestBody User user) {
		userService.update(user);
	}

	@DeleteMapping(value = "delete")
	public void deleteUser(@RequestBody User user) {
		userService.delete(user);
	}

}
