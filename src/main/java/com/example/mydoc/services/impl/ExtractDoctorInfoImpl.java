package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Specialty;
import com.example.mydoc.services.CityService;
import com.example.mydoc.services.ExtractDoctorInfo;
import com.example.mydoc.services.HospitalService;
import com.example.mydoc.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtractDoctorInfoImpl implements ExtractDoctorInfo {

    private final SpecialtyService specialtyService;
    private final CityService cityService;
    private final HospitalService hospitalService;

    public ExtractDoctorInfoImpl(SpecialtyService specialtyService, CityService cityService, HospitalService hospitalService) {
        this.specialtyService = specialtyService;
        this.cityService = cityService;
        this.hospitalService = hospitalService;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Specialty> specialties = this.specialtyService.findAll();

        //TODO: Generate doc info about all specialties (3-5 doctors per specialty)
        //TODO: Make sure the CITY and HOSPITALS correspond with each other
        return new ArrayList<>(List.of(
                new Doctor("Michael", "Jordan", 29,
                        specialties.get(0), null, "mjordan@mydoc.com",
                        this.cityService.findByCityId(1L), this.hospitalService.findById(1L)),
                new Doctor("Johny", "Sins", 32,
                        specialties.get(0), null, "jsins@mydoc.com",
                        this.cityService.findByCityId(1L), this.hospitalService.findById(2L)),
                new Doctor("Bustin", "Jieber", 48,
                        specialties.get(0), null, "bjieber@mydoc.com",
                        this.cityService.findByCityId(1L), this.hospitalService.findById(1L))
        ));
    }
}
