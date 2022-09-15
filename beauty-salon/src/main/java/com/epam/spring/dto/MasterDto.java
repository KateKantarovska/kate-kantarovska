package com.epam.spring.dto;

import com.epam.spring.model.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class MasterDto extends UserDto {
  @Min(value = 0)
  @Max(value = 5)
  private Float rating;

  private List<Category> categoryList;
}
