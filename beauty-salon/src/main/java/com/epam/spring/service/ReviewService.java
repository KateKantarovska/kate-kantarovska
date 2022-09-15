package com.epam.spring.service;

import com.epam.spring.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
  ReviewDto createReview(ReviewDto reviewDto);

  List<ReviewDto> listReviewsByMasterId(Integer masterId);
}
