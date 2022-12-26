package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.City;
import com.dev.backend.repository.CityRepository;

@Service
public class CityServices {
    
    @Autowired
    private CityRepository cityRepository;

    public List<City> returnAllCities() {
        return cityRepository.findAll();
    }

    public City insert(City city) {
        city.setDateCreated(new Date());
        City newCity = cityRepository.saveAndFlush(city);
        return newCity;
    }

    public City change(City city) {
        city.setDateUpDate(new Date());
        return cityRepository.saveAndFlush(city);
    }

    public void delete(Long id) {
        City city = cityRepository.findById(id).get();
        cityRepository.delete(city);
    }
}
