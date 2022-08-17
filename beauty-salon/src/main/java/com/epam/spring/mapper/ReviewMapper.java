package com.epam.spring.mapper;

import com.epam.spring.dto.ReviewDto;
import com.epam.spring.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {
  ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

  Review mapReviewDtoToReview(ReviewDto reviewDto);

  ReviewDto mapReviewToReviewDto(Review review);
}
