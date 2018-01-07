package com.ragavan.data;

import java.util.List;

import com.ragavan.models.User;

public interface UserDAO {

	int save(User user);

	int update(User user);

	int delete(int id);

	List<User> list();

	User listOne(String name);

}
