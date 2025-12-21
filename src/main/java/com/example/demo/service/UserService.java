package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    String registerTheUser(User user);

    String loginUser(String email, String password);

    User findById(Long id);

    User findByEmail(String email);
}
    