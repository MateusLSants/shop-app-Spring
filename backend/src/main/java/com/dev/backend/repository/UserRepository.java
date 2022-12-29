package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);

    User findByEmailAndCodeRecoveryPassword(String email, String codeRecoveryPassword);
}
