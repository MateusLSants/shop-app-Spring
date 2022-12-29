package com.dev.backend.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.User;
import com.dev.backend.repository.UserRepository;

@Service
public class UserManagementServices {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServices emailServices;

    public String requestCode(String email) {
        User user = userRepository.findByEmail(email);
        user.setCodeRecoveryPassword(getCodeRecoveryPassword(user.getId()));
        user.setDateSendCode(new Date());
        userRepository.saveAndFlush(user);
        emailServices.sendEmailText(
                user.getEmail(),
                "Recovery Code",
                "Hello, your recovery code is the following: " + user.getCodeRecoveryPassword()
            );
        return "Send Code";
    }

    public String passwordChange(User user) {
        User inUser = userRepository.findByEmailAndCodeRecoveryPassword(user.getEmail(), user.getCodeRecoveryPassword());
        if (inUser != null) {
            Date difference = new Date(new Date().getTime() - inUser.getDateSendCode().getTime());
            //later add Spring Sercurity
            if(difference.getTime()/1000 < 900) { 
                inUser.setPassword(user.getPassword());
                inUser.setCodeRecoveryPassword(null);
                userRepository.saveAndFlush(inUser);
                return "Password is change";
            }else {
                return "Time expired, request a new code";
            }
        } else {
            return "User or Code not found";
        }    
    }

    private String getCodeRecoveryPassword(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }
}
