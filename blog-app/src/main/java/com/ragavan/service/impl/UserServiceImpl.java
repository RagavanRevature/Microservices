package com.ragavan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragavan.data.UserDAO;
import com.ragavan.models.User;
import com.ragavan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public int save(User user) {
		return userDAO.save(user);
	}

	@Override
	public int update(User user) {
		return userDAO.update(user);
	}

	@Override
	public int delete(int id) {
		return userDAO.delete(id);
	}

	@Override
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	public User listOne(String name) {
		return userDAO.listOne(name);
	}
}
