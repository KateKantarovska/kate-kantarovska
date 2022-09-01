package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
  private Integer id;
  private Client client;
  private Master master;
  private String text;
  private Integer rating;
  private Boolean visible;
}
