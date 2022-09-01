package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Category {
  private Integer id;
  private String name;
  private List<Service> services;
}
