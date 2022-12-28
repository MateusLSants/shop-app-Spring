package com.dev.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Product;
import com.dev.backend.entity.ProductImage;
import com.dev.backend.repository.ProductImageRepository;
import com.dev.backend.repository.ProductRepository;


@Service
public class ProductImageServices {
    
    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductImage> returnAllProductImagens() {
        return productImageRepository.findAll();
    }

    public ProductImage insert(Long productID, MultipartFile file) {
        Product product = productRepository.findById(productID).get();
        ProductImage productImage = new ProductImage();

        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imageName = String.valueOf(product.getId()) + file.getOriginalFilename();
                Path path = Paths
                        .get("/home/mateus/Documentos/Projetos/shop-app-Spring/backend/src/main/resources/images/" + imageName);
                Files.write(path, bytes);  
                productImage.setName(imageName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        productImage.setProduct(product);
        productImage.setDateCreated(new Date());
        ProductImage newProductImage = productImageRepository.saveAndFlush(productImage);
        return newProductImage;
    }

    public ProductImage change(ProductImage productImage) {
        productImage.setDateUpdated(new Date());
        return productImageRepository.saveAndFlush(productImage);
    }

    public void delete(Long id) {
        ProductImage productImage = productImageRepository.findById(id).get();
        productImageRepository.delete(productImage);
    }
}
