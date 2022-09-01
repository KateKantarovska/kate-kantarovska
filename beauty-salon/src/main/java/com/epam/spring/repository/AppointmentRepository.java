package com.epam.spring.repository;

import com.epam.spring.model.Appointment;

import java.util.List;

public interface AppointmentRepository {
  Appointment createAppointment(Appointment appointment);

  Appointment getAppointmentById(Integer id);

  Appointment updateAppointment(Appointment appointment);

  List<Appointment> listAppointmentsByStatus(String status);

  List<Appointment> listAppointmentsByMasterId(Integer masterId);

  List<Appointment> listFreeAppointmentsByService(Integer serviceId);
}
