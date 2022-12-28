package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.dto.UserClientRequestDTO;
import com.dev.backend.entity.User;
import com.dev.backend.service.UserClientServices;

@RestController
@RequestMapping("/api/client")
public class UserClientContrioller {
    
    @Autowired
    private UserClientServices userClientServices;

    @PostMapping("/")
    public User insert(@RequestBody UserClientRequestDTO userClientRequestDTO) {
        User user = new UserClientRequestDTO().converter(userClientRequestDTO);
        return userClientServices.insert(userClientRequestDTO);
    }
}
