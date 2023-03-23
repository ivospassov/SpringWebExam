package com.example.mydoc.services;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.enums.SpecialtyType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DoctorService {

    boolean isDoctorListEmpty();

    void seedDoctors();

    List<Doctor> findAllDoctors();

    Optional<Doctor> findDoctorById(Long id);

    List<Doctor> findByCityNameAndSpecialtyName(String city, SpecialtyType specialtyType);
}
