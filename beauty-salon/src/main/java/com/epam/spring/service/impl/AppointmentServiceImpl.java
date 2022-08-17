package com.epam.spring.service.impl;

import com.epam.spring.dto.AppointmentDto;
import com.epam.spring.dto.ClientDto;
import com.epam.spring.mapper.AppointmentMapper;
import com.epam.spring.mapper.ClientMapper;
import com.epam.spring.model.Appointment;
import com.epam.spring.model.constants.AppointmentStatus;
import com.epam.spring.repository.AppointmentRepository;
import com.epam.spring.service.AppointmentService;
import com.epam.spring.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
  private final AppointmentRepository appointmentRepository;
  private final ClientService clientService;

  @Override
  public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
    log.info("create appointment {} {}", appointmentDto.getDate(), appointmentDto.getTimeslot());
    Appointment appointment =
        AppointmentMapper.INSTANCE.mapAppointmentDtoToAppointment(appointmentDto);
    appointment = appointmentRepository.createAppointment(appointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  @Override
  public AppointmentDto updateAppointment(AppointmentDto appointmentDto, Integer id) {
    log.info("update appointment with id {}", id);
    Appointment appointment =
        AppointmentMapper.INSTANCE.mapAppointmentDtoToAppointment(appointmentDto);
    appointment = appointmentRepository.updateAppointment(appointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  @Override
  public AppointmentDto getAppointmentById(Integer id) {
    log.info("get appointment by id {}", id);
    Appointment appointment = appointmentRepository.getAppointmentById(id);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  @Override
  public List<AppointmentDto> listAppointmentsByStatus(String status) {
    log.info("list appointments with status \"{}\"", status);
    List<Appointment> appointmentList = appointmentRepository.listAppointmentsByStatus(status);
    return AppointmentMapper.INSTANCE.mapAppointmentListToAppointmentDtoList(appointmentList);
  }

  @Override
  public List<AppointmentDto> listAppointmentsByMasterId(Integer masterId, String status) {
    log.info("list appointments with status {} for master with id {}", status, masterId);
    List<Appointment> appointmentList = appointmentRepository.listAppointmentsByMasterId(masterId);
    appointmentList =
        appointmentList.stream()
            .filter(appointment -> appointment.getStatus().equals(status))
            .toList();
    return AppointmentMapper.INSTANCE.mapAppointmentListToAppointmentDtoList(appointmentList);
  }

  @Override
  public List<AppointmentDto> listFreeAppointmentsByService(Integer serviceId) {
    log.info("list free appointments for service with id {}", serviceId);
    List<Appointment> appointmentList =
        appointmentRepository.listFreeAppointmentsByService(serviceId);
    return AppointmentMapper.INSTANCE.mapAppointmentListToAppointmentDtoList(appointmentList);
  }

  @Override
  public AppointmentDto rescheduleAppointment(Integer newAppointmentId, Integer id) {
    log.info("reschedule appointment with id {}", id);
    Appointment currentAppointment = appointmentRepository.getAppointmentById(id);
    cancelAppointment(id);
    Appointment newAppointment = appointmentRepository.getAppointmentById(newAppointmentId);
    newAppointment.setStatus(AppointmentStatus.BOOKED);
    newAppointment.setService(currentAppointment.getService());
    newAppointment.setClient(currentAppointment.getClient());
    newAppointment = appointmentRepository.updateAppointment(newAppointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(newAppointment);
  }

  @Override
  public AppointmentDto cancelAppointment(Integer id) {
    log.info("cancel appointment with id {}", id);
    Appointment appointment = appointmentRepository.getAppointmentById(id);
    appointment.setStatus(AppointmentStatus.FREE);
    appointment.setService(null);
    appointment.setClient(null);
    appointmentRepository.updateAppointment(appointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  @Override
  public AppointmentDto finishAppointment(Integer id) {
    log.info("finish appointment with id {}", id);
    Appointment appointment = appointmentRepository.getAppointmentById(id);
    appointment.setStatus(AppointmentStatus.FINISHED);
    appointmentRepository.updateAppointment(appointment);
    deductClientPaymentForService(appointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  @Override
  public AppointmentDto completeAppointment(Integer masterId, Integer appointmentId) {
    log.info("mark appointment with id {} as completed (master with id {})", appointmentId, masterId);
    Appointment appointment = appointmentRepository.getAppointmentById(appointmentId);
    appointment.setStatus(AppointmentStatus.COMPLETED);
    appointmentRepository.updateAppointment(appointment);
    return AppointmentMapper.INSTANCE.mapAppointmentToAppointmentDto(appointment);
  }

  private void deductClientPaymentForService(Appointment appointment) {
    ClientDto clientDto = ClientMapper.INSTANCE.mapClientToClientDto(appointment.getClient());
    clientDto.setBalance(clientDto.getBalance() - appointment.getService().getPrice());
    clientService.updateClient(clientDto, clientDto.getId());
  }
}
