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

import com.dev.backend.entity.Cart;
import com.dev.backend.service.CartServices;

@RestController
@RequestMapping("api/cart")
public class CartController {
    
    @Autowired
    private CartServices cartServices;

    @GetMapping("/")
    public List<Cart> returnAllCarts() {
       return cartServices.returnAllCarts();
    }
    
    @PostMapping("/")
    public Cart insert(@RequestBody Cart cart) {
        return cartServices.insert(cart);
    }

    @PutMapping("/")
    public Cart change(@RequestBody Cart cart) {
        return cartServices.change(cart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
