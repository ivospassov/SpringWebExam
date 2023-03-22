package com.example.mydoc.services;

import com.example.mydoc.models.entities.City;

import java.util.List;

public interface CityService {

    boolean isCityListEmpty();

    void seedCities();

    City findByCityId(Long id);

    List<City> findAllCities();
}
