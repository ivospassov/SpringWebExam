package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.entities.MyDocDTO;
import com.example.mydoc.services.CityService;
import com.example.mydoc.services.HospitalService;
import com.example.mydoc.services.MyDocService;
import com.example.mydoc.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyDocServiceImpl implements MyDocService {

    private final CityService cityService;
    private final SpecialtyService specialtyService;
    private final HospitalService hospitalService;

    public MyDocServiceImpl(CityService cityService, SpecialtyService specialtyService, HospitalService hospitalService) {
        this.cityService = cityService;
        this.specialtyService = specialtyService;
        this.hospitalService = hospitalService;
    }
}
