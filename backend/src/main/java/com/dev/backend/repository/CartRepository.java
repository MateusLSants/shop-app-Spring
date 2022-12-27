package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
