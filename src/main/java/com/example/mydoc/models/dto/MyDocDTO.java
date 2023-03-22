package com.example.mydoc.models.dto;

import com.example.mydoc.models.enums.CitiesName;
import com.example.mydoc.models.enums.SpecialtyType;

public class MyDocDTO {

    private CitiesName location;

    private SpecialtyType specialty;

    private String hospital;

    public MyDocDTO() {}

    public CitiesName getLocation() {
        return location;
    }

    public void setLocation(CitiesName location) {
        this.location = location;
    }

    public SpecialtyType getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyType specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
