package com.epam.spring.service;

import com.epam.spring.dto.ReviewDto;

public interface ReviewService {
  ReviewDto createReview(ReviewDto reviewDto);
}
