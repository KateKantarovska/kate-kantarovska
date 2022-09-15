package com.epam.spring.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "appointments")
@DynamicUpdate
@DynamicInsert
@NamedNativeQuery(name = "findFreeAppointmentsByServiceId",
        query = "select * from appointments where status = 'free' and service_id = ?",
        resultClass = Appointment.class)
@org.hibernate.annotations.NamedQuery(name = "updateAppointmentStatus",
        query = "update Appointment set status = :appointmentStatus where id = :appointmentId")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private Service service;

  @ManyToOne
  @JoinColumn(name = "master_id")
  private Master master;

  private LocalDate date;

  private LocalTime timeslot;

  @ColumnDefault(value = "'free'")
  private String status;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Appointment that)) return false;
    return Objects.equals(id, that.id) && Objects.equals(service, that.service) && Objects.equals(master, that.master) && Objects.equals(date, that.date) && Objects.equals(timeslot, that.timeslot) && Objects.equals(status, that.status) && Objects.equals(client, that.client);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, service, master, date, timeslot, status, client);
  }
}
