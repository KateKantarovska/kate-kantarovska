package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class Appointment {
  private Integer id;
  private Service service;
  private Master master;
  private LocalDate date;
  private LocalTime timeslot;
  private String status;
  private Client client;
}
