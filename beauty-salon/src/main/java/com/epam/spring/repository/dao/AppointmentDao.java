package com.epam.spring.repository.dao;

import com.epam.spring.model.Appointment;

import java.util.List;

public interface AppointmentDao {
  List<Appointment> findAllAppointmentsByStatusFreeAndServiceId(Integer serviceId);

  Appointment updateAppointmentStatus(Integer appointmentId, String status);
}
