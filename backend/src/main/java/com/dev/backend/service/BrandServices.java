package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Brand;
import com.dev.backend.repository.BrandRepository;

@Service
public class BrandServices {
    
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> returnAllBrands() {
        return brandRepository.findAll();
    }

    public Brand insert(Brand brand) {
        brand.setDateCreated(new Date());
        Brand newBrand = brandRepository.saveAndFlush(brand);
        return newBrand;
    }

    public Brand change(Brand brand) {
        brand.setDateUpdated(new Date());
        return brandRepository.saveAndFlush(brand);
    }

    public void delete(Long id) {
        Brand brand = brandRepository.findById(id).get();
        brandRepository.delete(brand);
    }
}
