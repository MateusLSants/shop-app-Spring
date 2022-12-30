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

import com.dev.backend.entity.City;
import com.dev.backend.service.CityServices;

@RestController
@RequestMapping("api/city")
public class CityController {
    
    @Autowired
    private CityServices cityServices;

    @GetMapping("/")
    public List<City> returnAlCities() {
        return cityServices.returnAllCities();
    }

    @PostMapping("/")
    public City insert(@RequestBody City city) {
        return cityServices.insert(city);
    }

    @PutMapping("/")
    public City change(@RequestBody City city) {
        return cityServices.change(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityServices.delete(id);
        return ResponseEntity.ok().build();
    }
}
