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

import com.dev.backend.entity.Product;
import com.dev.backend.service.ProductServices;

@RestController
@RequestMapping("api/product")
public class ProductController {
    
    @Autowired
    private ProductServices productServices;

    @GetMapping("/")
    public List<Product> returnAlProducts() {
        return productServices.returnAllProducts();
    }

    @PostMapping("/")
    public Product insert(@RequestBody Product product) {
        return productServices.insert(product);
    }

    @PutMapping("/")
    public Product change(@RequestBody Product product) {
        return productServices.change(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
