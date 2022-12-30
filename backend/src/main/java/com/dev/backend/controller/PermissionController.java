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

import com.dev.backend.entity.Permission;
import com.dev.backend.service.PermissionServices;

@RestController
@RequestMapping("api/permission")
public class PermissionController {
    
    @Autowired
    private PermissionServices permissionServices;

    @GetMapping("/")
    public List<Permission> returnAllPermissions() {
        return permissionServices.returnAllPermission();
    }

    @PostMapping("/")
    public Permission insert(@RequestBody Permission permission) {
        return permissionServices.insert(permission);
    }

    @PutMapping("/")
    public Permission change(@RequestBody Permission permission) {
        return permissionServices.change(permission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permissionServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
