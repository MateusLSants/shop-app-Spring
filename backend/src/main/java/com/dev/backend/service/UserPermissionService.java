package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Permission;
import com.dev.backend.entity.User;
import com.dev.backend.entity.UserPermission;
import com.dev.backend.repository.PermissionRepository;
import com.dev.backend.repository.UserPermissionRepository;

@Service
public class UserPermissionService {
    
    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

     public void linkUserPermissionClient(User user) {
        List<Permission> listPermission = permissionRepository.findByName("client");
        if(listPermission.size() > 0) {
            UserPermission userPermission = new UserPermission();
            userPermission.setUser(user);
            userPermission.setPermission(listPermission.get(0));
            userPermission.setDateCreated(new Date());
            userPermissionRepository.saveAndFlush(userPermission);
        }
     }
}
