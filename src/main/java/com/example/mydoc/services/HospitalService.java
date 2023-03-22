package com.example.mydoc.services;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.entities.Hospital;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HospitalService {

    boolean isHospitalListEmpty();

    void seedHospitals();

    Hospital findById(Long id);

    Optional<Hospital> findByName(String name);

    List<Hospital> findAllHospitals();

    List<Hospital> findByCity(String cityName);
}
