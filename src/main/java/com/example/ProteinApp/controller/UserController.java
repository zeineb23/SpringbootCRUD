package com.example.ProteinApp.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.ProteinApp.entities.User;
import com.example.ProteinApp.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protein")
public class UserController {
    @Autowired
    private IuserService userv;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userv.findAllUsers();
        return users;
    }

    @PostMapping("/addusert")
    public User createUser(@Valid @RequestBody User user) {
        return userv.saveUser(user);
    }
}
