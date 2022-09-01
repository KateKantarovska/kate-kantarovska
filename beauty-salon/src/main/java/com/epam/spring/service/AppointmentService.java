package com.epam.spring.service;

import com.epam.spring.dto.AppointmentDto;
import java.util.List;

public interface AppointmentService {
  AppointmentDto createAppointment(AppointmentDto appointmentDto);

  AppointmentDto updateAppointment(AppointmentDto appointmentDto, Integer id);

  AppointmentDto getAppointmentById(Integer id);

  List<AppointmentDto> listAppointmentsByStatus(String status);

  List<AppointmentDto> listAppointmentsByMasterId(Integer masterId, String status);

  List<AppointmentDto> listFreeAppointmentsByService(Integer serviceId);

  AppointmentDto rescheduleAppointment(Integer newAppointmentId, Integer id);

  AppointmentDto cancelAppointment(Integer id);

  AppointmentDto finishAppointment(Integer id);

  AppointmentDto completeAppointment(Integer id);
}
