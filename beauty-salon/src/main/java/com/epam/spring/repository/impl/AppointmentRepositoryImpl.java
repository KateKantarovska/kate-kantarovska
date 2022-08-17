package com.epam.spring.repository.impl;

import com.epam.spring.model.Appointment;
import com.epam.spring.repository.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentRepositoryImpl implements AppointmentRepository {
  private final List<Appointment> list = new ArrayList<>();

  @Override
  public Appointment createAppointment(Appointment appointment) {
    list.add(appointment);
    return appointment;
  }

  @Override
  public Appointment getAppointmentById(Integer id) {
    return list.stream()
        .filter(appointment -> appointment.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("appointment has not been found"));
  }

  @Override
  public List<Appointment> listAppointmentsByStatus(String status) {
    return list.stream().filter(appointment -> appointment.getStatus().equals(status)).toList();
  }

  @Override
  public List<Appointment> listAppointmentsByMasterId(Integer masterId) {
    return list.stream()
        .filter(appointment -> appointment.getMaster().getId().equals(masterId))
        .toList();
  }

  @Override
  public List<Appointment> listFreeAppointmentsByService(Integer serviceId) {
    return list.stream()
        .filter(
            appointment ->
                appointment.getStatus().equals("free")
                    && appointment.getService().getId().equals(serviceId))
        .toList();
  }

  @Override
  public Appointment updateAppointment(Appointment appointment) {
    boolean isDeleted =
        list.removeIf(appointment1 -> appointment1.getId().equals(appointment.getId()));
    if (isDeleted) {
      list.add(appointment);
    } else {
      throw new RuntimeException("appointment has not been found");
    }
    return appointment;
  }
}
