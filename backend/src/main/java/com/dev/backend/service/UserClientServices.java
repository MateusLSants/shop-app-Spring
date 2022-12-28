package com.dev.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.dto.UserClientRequestDTO;
import com.dev.backend.entity.User;
import com.dev.backend.repository.UserClientRepository;

@Service
public class UserClientServices {
    
    @Autowired
    private UserClientRepository userClientRepository;

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private EmailServices emailServices;

    public User insert(UserClientRequestDTO userClientRequestDTO) {
        User user = new UserClientRequestDTO().converter(userClientRequestDTO);
        user.setDateCreated(new Date());
        User newUser = userClientRepository.saveAndFlush(user);
        userPermissionService.linkUserPermissionClient(newUser);
        emailServices.sendEmailText(newUser.getEmail(), "Cadastro na Loja LSTI", "Registration was successful. Soon you will receive the password by email.");
        
        return newUser;
    }
}
