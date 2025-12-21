package com.example.SpringPro.service.impl;

import org.springframework.stereotype.Service;

import com.example.SpringPro.entity.User;
import com.example.SpringPro.repository.UserRepository;
import com.example.SpringPro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public String registerTheUser(User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "Email already registered";
        }

        repo.save(user);
        return "Registered Successfully";
    }

    @Override
    public String loginUser(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(password)) {
            return "Invalid password";
        }

        return "Login Successful";
    }

    @Override
    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
