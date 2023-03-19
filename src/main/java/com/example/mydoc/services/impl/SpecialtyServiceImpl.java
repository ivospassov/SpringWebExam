package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.Specialty;
import com.example.mydoc.models.enums.SpecialtyType;
import com.example.mydoc.repositories.SpecialtyRepository;
import com.example.mydoc.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public boolean isSpecialtyListEmpty() {
        return this.specialtyRepository.count() <= 0;
    }

    @Override
    public void seedSpecialties() {
        if (isSpecialtyListEmpty()) {
            List<Specialty> specialties = Arrays.stream(SpecialtyType.values())
                    .map(Specialty::new)
                    .toList();

            this.specialtyRepository.saveAll(specialties);
        }
    }

    @Override
    public List<Specialty> findAll() {
        return this.specialtyRepository.findAll();
    }
}
