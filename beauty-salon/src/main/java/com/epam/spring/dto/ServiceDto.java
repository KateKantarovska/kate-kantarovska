package com.epam.spring.dto;

import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDto {
  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;
  @NotNull
  private CategoryDto category;
  @NotBlank
  private String name;
  @Positive
  private Integer price;
  private List<MasterDto> mastersList;
}
