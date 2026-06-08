package com.example.research.controller;

import com.example.research.Dto.LoginRequest;
import com.example.research.entity.User;
import com.example.research.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController

    public class AdminController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;



    @PreAuthorize("hasRole('Admin')")
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        user.setRole("USER");

        userRepository.save(user);

        return "User registered";
    }
    }

