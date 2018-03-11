package com.ragavan.data;

import com.ragavan.models.User;
import java.util.List;

public interface UserDAO {

  void save(User user);

  void update(User user);

  void delete(User user);

  List<User> getAllUsers();

  User getUserByUserName(String name);
}
