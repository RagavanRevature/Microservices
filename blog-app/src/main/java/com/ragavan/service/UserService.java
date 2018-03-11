package com.ragavan.service;

import com.ragavan.models.User;
import java.util.List;

public interface UserService {

  void save(User user);

  void update(User user);

  void delete(User user);

  List<User> list();

  User listOne(String name);
}
