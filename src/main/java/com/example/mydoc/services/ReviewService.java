package com.example.mydoc.services;

import com.example.mydoc.models.dto.ReviewDTO;

public interface ReviewService {

    void leaveReview(Long doctorId, ReviewDTO reviewDTO);
}
