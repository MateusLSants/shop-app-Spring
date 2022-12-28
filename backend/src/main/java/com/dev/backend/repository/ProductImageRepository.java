package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    
}
