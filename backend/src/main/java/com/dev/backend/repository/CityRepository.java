package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
    
}
