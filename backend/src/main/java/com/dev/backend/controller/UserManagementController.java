package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.User;
import com.dev.backend.service.UserManagementServices;

@RestController
@RequestMapping("api/user-management")
public class UserManagementController {
    @Autowired
    private UserManagementServices userManagementServices;

    @PostMapping("/password-code")
    public String recoveryCode(@RequestBody User user) {
        return userManagementServices.requestCode(user.getEmail());
    }

    @PostMapping("/password-change")
    public String change(@RequestBody User user) {
        return userManagementServices.passwordChange(user);
    }
}
