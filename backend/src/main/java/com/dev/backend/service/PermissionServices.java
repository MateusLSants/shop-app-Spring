package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.backend.entity.Permission;
import com.dev.backend.repository.PermissionRepository;

@Service
public class PermissionServices {
    
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> returnAllPermission() {
        return permissionRepository.findAll();
    }

    public Permission insert(Permission permission) {
        permission.setDateCreated(new Date());
        Permission newPermission = permissionRepository.saveAndFlush(permission);
        return newPermission;
    }    

    public Permission change(Permission permission) {
        permission.setDateUpdated(new Date());
        return permissionRepository.saveAndFlush(permission);
    }

    public void delete(@PathVariable Long id) {
        Permission permission = permissionRepository.findById(id).get();
        permissionRepository.delete(permission);
    }
}
