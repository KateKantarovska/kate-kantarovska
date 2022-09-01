package com.epam.spring.dto;

import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class ReviewDto {
  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;
  @NotNull
  private ClientDto client;
  @NotNull
  private MasterDto master;
  @NotBlank
  private String text;
  @Min(value = 1)
  @Max(value = 5)
  private Integer rating;
  private Boolean visible;
}
