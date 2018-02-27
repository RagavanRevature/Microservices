package com.ragavan.data;

import java.util.List;

import com.ragavan.models.User;

public interface UserDAO {

	void save(User user);

	void update(User user);

	void delete(User user);

	List<User> getAllUsers();

	User getUserByUserName(String name);

}
