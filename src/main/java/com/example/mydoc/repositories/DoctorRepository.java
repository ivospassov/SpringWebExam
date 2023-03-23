package com.example.mydoc.repositories;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.enums.SpecialtyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByCityNameAndSpecialtyName(String city, SpecialtyType specialty);
}
