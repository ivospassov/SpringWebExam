package com.example.mydoc.services.impl;

import com.example.mydoc.repositories.DoctorRepository;
import com.example.mydoc.services.DoctorService;
import com.example.mydoc.services.ExtractDoctorInfo;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ExtractDoctorInfo doctorInfo;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ExtractDoctorInfo doctorInfo) {
        this.doctorRepository = doctorRepository;
        this.doctorInfo = doctorInfo;
    }

    @Override
    public boolean isDoctorListEmpty() {
        return this.doctorRepository.count() <= 0;
    }

    @Override
    public void seedDoctors() {
        if (isDoctorListEmpty()) {
            this.doctorRepository.saveAll(this.doctorInfo.getAllDoctors());
        }
    }
}
