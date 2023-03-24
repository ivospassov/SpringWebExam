package com.example.mydoc.repositories;

import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Review;
import com.example.mydoc.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByDoctorAndPatient(Doctor doctor, User patient);
}
