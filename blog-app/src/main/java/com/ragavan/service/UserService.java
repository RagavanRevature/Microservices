package com.ragavan.service;

import java.util.List;

import com.ragavan.models.User;

public interface UserService {

	void save(User user);

	void update(User user);

	void delete(User user);

	List<User> list();

	User listOne(String name);

}
