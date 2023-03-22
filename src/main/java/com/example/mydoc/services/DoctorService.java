package com.example.mydoc.services;

import com.example.mydoc.models.entities.Doctor;

import java.util.List;

public interface DoctorService {

    boolean isDoctorListEmpty();

    void seedDoctors();

    List<Doctor> findAllDoctors();
}
