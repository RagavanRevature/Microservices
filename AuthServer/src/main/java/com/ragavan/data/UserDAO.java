package com.ragavan.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragavan.model.User;

public interface UserDAO extends JpaRepository<User, Long>{

  Optional<User> findByUserName(String userName);

}
