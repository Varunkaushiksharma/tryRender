package com.example.mogodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mogodb.repo.UserRepo;
import com.example.mogodb.entity.User;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/add")
    public String add() {
        User u = new User();
        u.setName("Varun");
        userRepo.save(u);
        return "saved";
    }

    @GetMapping("/all")
    public List<User> all() {
        return userRepo.findAll();
    }
    
    @GetMapping("/")
    public String home() {
        return "Welcome to the Home Controller.";
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }



}
