package com.epam.spring.controller;

import com.epam.spring.dto.AppointmentDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import com.epam.spring.service.AppointmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class AppointmentController {
  private final AppointmentService appointmentService;

  @ApiOperation("Create an appointment")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/appointment")
  public AppointmentDto createAppointment(
      @Validated(OnCreate.class) @RequestBody AppointmentDto appointmentDto) {
    return appointmentService.createAppointment(appointmentDto);
  }

  @ApiOperation("Update an appointment")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "appointment id")
  @ResponseStatus(HttpStatus.OK)
  @PatchMapping(value = "appointment/{id}")
  public AppointmentDto updateAppointment(
      @Validated(OnUpdate.class) @RequestBody AppointmentDto appointmentDto,
      @PathVariable Integer id) {
    return appointmentService.updateAppointment(appointmentDto, id);
  }

  @ApiOperation("Get list of appointments with specified status")
  @ApiImplicitParam(
      name = "status",
      paramType = "path",
      dataTypeClass = String.class,
      required = true,
      value = "appointment status")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/appointment/{status}")
  public List<AppointmentDto> listAppointmentsByStatus(@PathVariable String status) {
    return appointmentService.listAppointmentsByStatus(status);
  }

  @ApiOperation("Get list of free appointments for specified service")
  @ApiImplicitParam(
      name = "serviceId",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "service id")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/service/{serviceId}/available")
  public List<AppointmentDto> listFreeAppointmentsByService(@PathVariable Integer serviceId) {
    return appointmentService.listFreeAppointmentsByService(serviceId);
  }

  @ApiOperation("Get list of appointments with specified master")
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "masterId",
        paramType = "path",
        dataTypeClass = Integer.class,
        required = true,
        value = "master id"),
    @ApiImplicitParam(
        name = "status",
        paramType = "query",
        dataTypeClass = String.class,
        value = "appointments status")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/master/{masterId}/appointment")
  public List<AppointmentDto> listAppointmentsByMaster(
      @PathVariable Integer masterId, @RequestParam String status) {
    return appointmentService.listAppointmentsByMasterId(masterId, status);
  }

  @ApiOperation("Reschedule an appointment (make one free and the other booked)")
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "id",
        paramType = "path",
        dataTypeClass = Integer.class,
        required = true,
        value = "current appointment id"),
    @ApiImplicitParam(
        name = "newAppointmentId",
        paramType = "body",
        dataTypeClass = Integer.class,
        required = true,
        value = "new appointment id")
  })
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/reschedule")
  public AppointmentDto rescheduleAppointment(
      @RequestBody Integer newAppointmentId, @PathVariable Integer id) {
    return appointmentService.rescheduleAppointment(newAppointmentId, id);
  }

  @ApiOperation("Cancel an appointment (set status free)")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "appointment id")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/cancel")
  public AppointmentDto cancelAppointment(@PathVariable Integer id) {
    return appointmentService.cancelAppointment(id);
  }

  @ApiOperation("Finish an appointment (set status finished and deduct the client's payment)")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "appointment id")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/finish")
  public AppointmentDto finishAppointment(@PathVariable Integer id) {
    return appointmentService.finishAppointment(id);
  }

  @ApiOperation("Complete an appointment (set status completed)")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "appointment id")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/appointment/{id}/complete")
  public AppointmentDto completeAppointment(@PathVariable Integer id) {
    return appointmentService.completeAppointment(id);
  }
}
