package com.epam.spring.repository;

import com.epam.spring.model.Review;

public interface ReviewRepository {
  Review createReview(Review review);
}
