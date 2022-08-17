package com.epam.spring.controller;

import com.epam.spring.dto.ReviewDto;
import com.epam.spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewService reviewService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/review")
  public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
    return reviewService.createReview(reviewDto);
  }
}
