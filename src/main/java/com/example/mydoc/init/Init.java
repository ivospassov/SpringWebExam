package com.example.mydoc.init;

import com.example.mydoc.services.CityService;
import com.example.mydoc.services.DoctorService;
import com.example.mydoc.services.HospitalService;
import com.example.mydoc.services.SpecialtyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {

    private final CityService cityService;
    private final DoctorService doctorService;
    private final HospitalService hospitalService;
    private final SpecialtyService specialtyService;

    public Init(CityService cityService, DoctorService doctorService, HospitalService hospitalService, SpecialtyService specialtyService) {
        this.cityService = cityService;
        this.doctorService = doctorService;
        this.hospitalService = hospitalService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.cityService.seedCities();
        this.hospitalService.seedHospitals();
        this.specialtyService.seedSpecialties();
        this.doctorService.seedDoctors();
    }
}
