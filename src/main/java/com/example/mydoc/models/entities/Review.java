package com.example.mydoc.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private User patient;

    @ManyToOne
    private Doctor doctor;

    public Review() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return patient;
    }

    public void setUser(User user) {
        this.patient = user;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
