package com.epam.spring.service.impl;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.dto.ReviewDto;
import com.epam.spring.mapper.ReviewMapper;
import com.epam.spring.model.Review;
import com.epam.spring.repository.ReviewRepository;
import com.epam.spring.service.MasterService;
import com.epam.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;
  private final MasterService masterService;

  @Override
  public ReviewDto createReview(ReviewDto reviewDto) {
    log.info(
        "create review for master with id {} from client with id {}",
        reviewDto.getMaster().getId(),
        reviewDto.getClient().getId());
    Review review = ReviewMapper.INSTANCE.mapReviewDtoToReview(reviewDto);
    review = reviewRepository.save(review);
    List<Review> masterReviews = reviewRepository.findAllByMasterId(review.getMaster().getId());
    MasterDto masterDto =
        masterService.updateMasterRating(review.getMaster().getId(), masterReviews);
    reviewDto = ReviewMapper.INSTANCE.mapReviewToReviewDto(review);
    reviewDto.setMaster(masterDto);
    return reviewDto;
  }

  @Override
  public List<ReviewDto> listReviewsByMasterId(Integer masterId) {
    log.info("find all reviews for master with id {}", masterId);
    List<Review> masterReviews = reviewRepository.findAllByMasterId(masterId);
    return ReviewMapper.INSTANCE.mapReviewListToReviewDtoList(masterReviews);
  }
}
