package com.javaBrains.javaBrains.repository;

import com.javaBrains.javaBrains.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Integer id);

    int deleteById(Integer id);

    int insert(User user);

    int update(User user);
}
