package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.UserPermission;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long>{
    
}
