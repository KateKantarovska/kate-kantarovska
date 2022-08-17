package com.epam.spring.service.impl;

import com.epam.spring.dto.ReviewDto;
import com.epam.spring.mapper.ReviewMapper;
import com.epam.spring.model.Review;
import com.epam.spring.repository.ReviewRepository;
import com.epam.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;

  @Override
  public ReviewDto createReview(ReviewDto reviewDto) {
    log.info(
        "create review for master with id {} from client with id {}",
        reviewDto.getMaster().getId(),
        reviewDto.getClient().getId());
    Review review = ReviewMapper.INSTANCE.mapReviewDtoToReview(reviewDto);
    review = reviewRepository.createReview(review);
    return ReviewMapper.INSTANCE.mapReviewToReviewDto(review);
  }
}
