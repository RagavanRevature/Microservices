package com.ragavan.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ragavan.data.UserDAO;
import com.ragavan.data.exception.DataAccessException;
import com.ragavan.models.User;
import com.ragavan.utils.data.DataModifierUtilImpl;
import com.ragavan.utils.data.DataRetrieverUtilImpl;
import com.ragavan.utils.data.QueryParameter;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	DataRetrieverUtilImpl dataRetriever;

	@Autowired
	DataModifierUtilImpl dataModifier;

	@Override
	public void save(User user) {
		try {
			dataModifier.insert(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user) {
		try {
			dataModifier.update(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		try {
			dataModifier.delete(user);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		final String query = "from User u";
		try {
			return dataRetriever.retrieveByHQL(query);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUserName(String name) {
		String query = "from User u where u.userName=:name";
		List<QueryParameter<?>> queryParameters = new ArrayList<>();
		queryParameters.add(new QueryParameter<>("name", name));
		try {
			return dataRetriever.retrieveObjectByHQL(query, queryParameters);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
