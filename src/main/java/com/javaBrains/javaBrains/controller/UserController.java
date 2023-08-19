package com.javaBrains.javaBrains.controller;

import com.javaBrains.javaBrains.model.User;
import com.javaBrains.javaBrains.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
