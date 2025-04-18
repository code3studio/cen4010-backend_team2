package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            foundUser.setAccountStatus("active");
            foundUser.setLastLogin(LocalDateTime.now());
            userRepository.save(foundUser);
            return ResponseEntity.ok(Map.of("message", "Login successful"));
        }
        return ResponseEntity.status(401).body(Map.of("message", "Incorrect credentials"));
    }
}
