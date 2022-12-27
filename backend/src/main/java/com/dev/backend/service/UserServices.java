package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.User;
import com.dev.backend.repository.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> returnAllUsers() {
        return userRepository.findAll();
    }

    public User insert(User user) {
        user.setDateCreated(new Date());
        User newUser = userRepository.saveAndFlush(user);
        return newUser;
    }

    public User change(User user) {
        user.setDateUpdated(new Date());
        return userRepository.saveAndFlush(user);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
