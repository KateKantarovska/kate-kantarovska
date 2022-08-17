package com.epam.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {
  private Integer id;
  private CategoryDto category;
  private String name;
  private Integer price;
  private List<MasterDto> mastersList;
}
