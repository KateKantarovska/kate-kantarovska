package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Service {
  private Integer id;
  private Category category;
  private String name;
  private Integer price;
  private List<Master> mastersList;
}
