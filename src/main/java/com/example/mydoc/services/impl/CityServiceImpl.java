package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.enums.CitiesName;
import com.example.mydoc.repositories.CityRepository;
import com.example.mydoc.services.CityService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public boolean isCityListEmpty() {
        return this.cityRepository.count() <= 0;
    }

    @Override
    public void seedCities() {
        if (isCityListEmpty()) {
            List<City> cities = Arrays.stream(CitiesName.values())
                    .map(city -> new City(city.name()))
                    .toList();

            this.cityRepository.saveAll(cities);
        }
    }

    @Override
    public City findByCityId(Long id) {
        return this.cityRepository.findById(id).get();
    }

    @Override
    public List<City> findAllCities() {
        return this.cityRepository.findAll();
    }
}
