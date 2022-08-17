package com.epam.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class AppointmentDto {
  private Integer id;
  private ServiceDto service;
  private MasterDto master;
  private LocalDate date;
  private LocalTime timeslot;
  private String status;
  private ClientDto client;
}
