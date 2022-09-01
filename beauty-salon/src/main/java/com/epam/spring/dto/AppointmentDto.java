package com.epam.spring.dto;

import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class AppointmentDto {
  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;
  @NotNull
  private ServiceDto service;
  @NotNull
  private MasterDto master;
  @FutureOrPresent
  private LocalDate date;
  @NotNull
  private LocalTime timeslot;
  @NotBlank
  private String status;
  private ClientDto client;
}
