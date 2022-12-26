package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entity.State;

public interface StatesRepository extends JpaRepository<State, Long>{
    
}
