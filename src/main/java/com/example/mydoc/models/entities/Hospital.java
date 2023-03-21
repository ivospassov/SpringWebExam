package com.example.mydoc.models.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hospitals")
public class Hospital extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Basic
    private String image;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hospital", targetEntity = Doctor.class)
    private Set<Doctor> doctors;

    public Hospital(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Hospital() {}

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
