package com.ragavan.service.impl;

import com.ragavan.data.UserDAO;
import com.ragavan.models.User;
import com.ragavan.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserDAO userDAO;

  @Override
  public void save(User user) {
    userDAO.save(user);
  }

  @Override
  public void update(User user) {
    userDAO.update(user);
  }

  @Override
  public void delete(User user) {
    userDAO.delete(user);
  }

  @Override
  public List<User> list() {
    return userDAO.getAllUsers();
  }

  @Override
  public User listOne(String name) {
    return userDAO.getUserByUserName(name);
  }
}
