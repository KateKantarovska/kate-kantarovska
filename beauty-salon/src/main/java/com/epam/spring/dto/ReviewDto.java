package com.epam.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
  private Integer id;
  private ClientDto client;
  private MasterDto master;
  private String text;
  private Integer rating;
  private Boolean visible;
}
