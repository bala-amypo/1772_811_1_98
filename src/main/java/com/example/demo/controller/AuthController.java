package com.example.SpringPro.controller;

import org.springframework.web.bind.annotation.*;

import com.example.SpringPro.entity.User;
import com.example.SpringPro.service.UserService;

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
