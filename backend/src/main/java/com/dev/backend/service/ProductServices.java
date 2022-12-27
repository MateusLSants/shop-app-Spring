package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Product;
import com.dev.backend.repository.ProductRepository;

@Service
public class ProductServices {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> returnAllProducts() {
        return productRepository.findAll();
    }

    public Product insert(Product product) {
        product.setDateCreated(new Date());
        Product newProduct = productRepository.saveAndFlush(product);
        return newProduct;
    }

    public Product change(Product product) {
        product.setDateUpdated(new Date());
        return productRepository.saveAndFlush(product);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
