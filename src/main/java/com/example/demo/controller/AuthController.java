package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService ser;

    public AuthController(UserService ser) {
        this.ser = ser;
    }

    @PostMapping("/register")
    public String registerTheUser(@RequestBody User user) {
        return ser.registerTheUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return ser.loginUser(user.getEmail(), user.getPassword());
    }
}
