package com.dailycodework.quizonline.controller;

import com.dailycodework.quizonline.model.User;
import com.dailycodework.quizonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://127.0.0.1:5173/")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;



//    @PostMapping
//    public ResponseEntity<User> Register(@RequestBody User user){
//        User createdUser = userService.createdUser(user);
//        return ResponseEntity.status(CREATED).body(createdUser);
//    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "Email already exists";
        }
        userService.saveUser(user);
        return "User registered successfully";
    }

//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        User existingUser = userService.findByEmail(user.getEmail());
//        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
//            return "Login successful";
//        } else {
//            return "Invalid credentials";
//        }
//    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User existingUser = userService.findByEmail(user.getEmail());
        User user1 = null;
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            user1 = user;
        } 
        return user1;
    }
}
