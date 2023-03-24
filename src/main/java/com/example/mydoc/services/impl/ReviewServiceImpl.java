package com.example.mydoc.services.impl;

import com.example.mydoc.models.dto.ReviewDTO;
import com.example.mydoc.models.entities.Doctor;
import com.example.mydoc.models.entities.Review;
import com.example.mydoc.models.entities.User;
import com.example.mydoc.repositories.ReviewRepository;
import com.example.mydoc.services.DoctorService;
import com.example.mydoc.services.ReviewService;
import com.example.mydoc.services.UserService;
import com.example.mydoc.web.session.UserLoginSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final DoctorService doctorService;
    private final UserService userService;
    private final UserLoginSession loginSession;
    private final ModelMapper modelMapper;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(DoctorService doctorService, UserService userService, UserLoginSession loginSession, ModelMapper modelMapper, ReviewRepository reviewRepository) {
        this.doctorService = doctorService;
        this.userService = userService;
        this.loginSession = loginSession;
        this.modelMapper = modelMapper;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void leaveReview(Long doctorId, ReviewDTO reviewDTO) {
        Doctor doctor = this.doctorService.findDoctorById(doctorId).get();
        User currentUser = this.userService.retrieveById(loginSession.getId());

        Optional<Review> optionalReview = this.reviewRepository.findByDoctorAndPatient(doctor, currentUser);

        Review review;

        //If appointment exists, overwrite the current comment
        if (optionalReview.isPresent()) {
            review = optionalReview.get();
            review.setComment(reviewDTO.getComment());

        } else {
            review = this.modelMapper.map(reviewDTO, Review.class);
            review.setDoctor(doctor);
            review.setPatient(currentUser);

        }
        this.reviewRepository.save(review);
    }
}
