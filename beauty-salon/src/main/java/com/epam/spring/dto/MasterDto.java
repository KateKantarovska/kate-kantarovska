package com.epam.spring.dto;

import com.epam.spring.model.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class MasterDto extends UserDto {
  private Double rating;
  private List<Category> categoryList;
}
