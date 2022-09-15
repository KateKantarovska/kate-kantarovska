package com.epam.spring.repository.dao.impl;

import com.epam.spring.model.Appointment;
import com.epam.spring.repository.dao.AppointmentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AppointmentDaoImpl implements AppointmentDao {

  @PersistenceContext private final EntityManager entityManager;

  @Override
  public List<Appointment> findAllAppointmentsByStatusFreeAndServiceId(Integer serviceId) {
    return entityManager
        .createNamedQuery("findFreeAppointmentsByServiceId", Appointment.class)
        .setParameter(1, serviceId)
        .getResultList();
  }

  @Override
  public Appointment updateAppointmentStatus(Integer appointmentId, String status) {
    return (Appointment)
        entityManager
            .createNamedQuery("updateAppointmentStatus")
            .setParameter("appointmentStatus", status)
            .setParameter("appointmentId", appointmentId)
            .getSingleResult();
  }
}
