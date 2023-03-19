package com.example.mydoc.services;

import com.example.mydoc.models.entities.City;

public interface CityService {

    boolean isCityListEmpty();

    void seedCities();

    City findByCityId(Long id);
}
