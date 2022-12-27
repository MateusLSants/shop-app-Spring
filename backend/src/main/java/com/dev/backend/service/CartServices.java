package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cart;
import com.dev.backend.repository.CartRepository;

@Service
public class CartServices {
    
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> returnAllCarts() {
        return cartRepository.findAll();
    }

    public Cart insert(Cart cart) {
        cart.setDateCreated(new Date());
        Cart newCart = cartRepository.saveAndFlush(cart);
        return newCart;
    }

    public Cart change(Cart cart) {
        cart.setDateUpdated(new Date());
        return cartRepository.saveAndFlush(cart);
    }

    public void delete(Long id) {
        Cart cart = cartRepository.findById(id).get();
        cartRepository.delete(cart);
    }
}
