package com.epam.spring.repository.impl;

import com.epam.spring.model.Review;
import com.epam.spring.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
  private final List<Review> list = new ArrayList<>();

  @Override
  public Review createReview(Review review) {
    list.add(review);
    return review;
  }
}
