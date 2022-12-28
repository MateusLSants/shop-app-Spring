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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.ProductImage;
import com.dev.backend.service.ProductImageServices;

@RestController
@RequestMapping("/api/image")
public class ProductImageController {
    
    @Autowired
    private ProductImageServices productImageServices;

    @GetMapping("/")
    public List<ProductImage> returnAll() {
        return productImageServices.returnAllProductImagens();
    }

    @PostMapping("/")
    public ProductImage insert(@RequestParam("file") MultipartFile file, @RequestParam("ProductID") Long ProductID) {
        return productImageServices.insert(ProductID, file);
    }

    @PutMapping("/")
    public ProductImage change(@RequestBody ProductImage productImage) {
        return productImageServices.change(productImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productImageServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
