package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.User;
import com.dev.backend.service.UserServices;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public List<User> returnAllUsers() {
        return userServices.returnAllUsers();
    }

    @PostMapping("/")
    public User insert(@RequestBody User user) {
        return userServices.insert(user);
    }

    @PutMapping("/")
    public User change(@RequestBody User user) {
        return userServices.change(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userServices.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
