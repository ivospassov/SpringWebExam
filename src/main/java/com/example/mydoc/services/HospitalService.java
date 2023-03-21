package com.example.mydoc.services;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.entities.Hospital;

import java.util.Optional;

public interface HospitalService {

    boolean isHospitalListEmpty();

    void seedHospitals();

    Hospital findById(Long id);

    Optional<Hospital> findByName(String name);
}
