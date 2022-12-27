package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Category;
import com.dev.backend.service.CategoryServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/category")
public class CategoryConttroller {
    
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/")
    public List<Category> returnAllCategories() {
        return categoryServices.returnAllCategories();
    }

    @PostMapping("/")
    public Category insert(@RequestBody Category category) {
        return categoryServices.insert(category);
    }

    @PutMapping("/")
    public Category change(@RequestBody Category category) {
        return categoryServices.change(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathParam("id") Long id) {
        categoryServices.delete(id);
        return ResponseEntity.ok().build();
    }

}
