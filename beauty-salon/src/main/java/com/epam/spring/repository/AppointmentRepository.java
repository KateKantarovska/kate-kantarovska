package com.epam.spring.repository;

import com.epam.spring.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
  List<Appointment> findAllByStatus(String status);

  List<Appointment> findAllByMasterId(Integer masterId);
}
