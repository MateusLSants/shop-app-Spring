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

import com.dev.backend.entity.Brand;
import com.dev.backend.service.BrandServices;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    
    @Autowired
    private BrandServices brandServices;

    @GetMapping("/")
    public List<Brand> returnAllBrands() {
        return brandServices.returnAllBrands();
    }

    @PostMapping("/")
    public Brand insert(@RequestBody Brand brand) {
        return brandServices.insert(brand);
    }

    @PutMapping("/")
    public Brand change(@RequestBody Brand brand) {
        return brandServices.change(brand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        brandServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
