package com.epam.spring.repository;

import com.epam.spring.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
  List<Review> findAllByMasterId(Integer masterId);
}
