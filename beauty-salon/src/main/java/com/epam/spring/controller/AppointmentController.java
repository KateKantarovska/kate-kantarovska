package com.epam.spring.controller;

import com.epam.spring.dto.AppointmentDto;
import com.epam.spring.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentController {
  private final AppointmentService appointmentService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/appointment")
  public AppointmentDto createAppointment(@RequestBody AppointmentDto appointmentDto) {
    return appointmentService.createAppointment(appointmentDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PatchMapping(value = "appointment/{id}")
  public AppointmentDto updateAppointment(
      @RequestBody AppointmentDto appointmentDto, @PathVariable Integer id) {
    return appointmentService.updateAppointment(appointmentDto, id);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/appointments/{status}")
  public List<AppointmentDto> listAppointmentsByStatus(@PathVariable String status) {
    return appointmentService.listAppointmentsByStatus(status);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/service/{serviceId}/available")
  public List<AppointmentDto> listFreeAppointmentsByService(@PathVariable Integer serviceId) {
    return appointmentService.listFreeAppointmentsByService(serviceId);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/master/{masterId}/appointments")
  public List<AppointmentDto> listAppointmentsByMaster(
      @PathVariable Integer masterId, @RequestParam String status) {
    return appointmentService.listAppointmentsByMasterId(masterId, status);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/reschedule")
  public AppointmentDto rescheduleAppointment(
      @RequestBody Integer newAppointmentId, @PathVariable Integer id) {
    return appointmentService.rescheduleAppointment(newAppointmentId, id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/cancel")
  public AppointmentDto cancelAppointment(@PathVariable Integer id) {
    return appointmentService.cancelAppointment(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/finish")
  public AppointmentDto finishAppointment(@PathVariable Integer id) {
    return appointmentService.finishAppointment(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/master/{masterId}/appointment/{appointmentId}/complete")
  public AppointmentDto completeAppointment(
      @PathVariable Integer masterId, @PathVariable Integer appointmentId) {
    return appointmentService.completeAppointment(masterId, appointmentId);
  }
}
