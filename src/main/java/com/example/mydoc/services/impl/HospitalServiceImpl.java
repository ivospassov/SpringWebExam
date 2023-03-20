package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.City;
import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.enums.CitiesName;
import com.example.mydoc.models.enums.HospitalsName;
import com.example.mydoc.repositories.HospitalRepository;
import com.example.mydoc.services.CityService;
import com.example.mydoc.services.HospitalService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final CityService cityService;

    public HospitalServiceImpl(HospitalRepository hospitalRepository, CityService cityService) {
        this.hospitalRepository = hospitalRepository;
        this.cityService = cityService;
    }

    @Override
    public boolean isHospitalListEmpty() {
        return this.hospitalRepository.count() <= 0;
    }

    @Override
    public void seedHospitals() {

        if (isHospitalListEmpty()) {
            List<Hospital> hospitals = Arrays
                    .stream(HospitalsName.values())
                    .map(hospital -> {
                        Random random = new Random();
                        Integer randomId = random.ints(1, 5)
                                                .findFirst().getAsInt();
                        return new Hospital(hospital.name(), cityService.findByCityId(Long.parseLong(String.valueOf(randomId))));
                    }).toList();

            this.hospitalRepository.saveAll(hospitals);
        }
    }

    @Override
    public Hospital findById(Long id) {
        return this.hospitalRepository.findById(id).get();
    }
}
