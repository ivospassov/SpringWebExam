package com.example.mydoc.services;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.entities.Hospital;

public interface HospitalService {

    boolean isHospitalListEmpty();

    void seedHospitals();

    Hospital findById(Long id);
}
