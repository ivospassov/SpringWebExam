package com.example.mydoc.services;

import com.example.mydoc.models.entities.Specialty;

import java.util.List;

public interface SpecialtyService {

    boolean isSpecialtyListEmpty();

    void seedSpecialties();

    List<Specialty> findAll();
}
