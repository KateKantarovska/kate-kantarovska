package com.epam.spring.controller;

import com.epam.spring.dto.ReviewDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/review")
public class ReviewController {
  private final ReviewService reviewService;

  @ApiOperation("Create a review")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ReviewDto createReview(@Validated(OnCreate.class) @RequestBody ReviewDto reviewDto) {
    return reviewService.createReview(reviewDto);
  }
}
