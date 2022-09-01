package com.epam.spring.mapper;

import com.epam.spring.dto.AppointmentDto;
import com.epam.spring.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppointmentMapper {
  AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

  Appointment mapAppointmentDtoToAppointment(AppointmentDto appointmentDto);

  AppointmentDto mapAppointmentToAppointmentDto(Appointment appointment);

  List<AppointmentDto> mapAppointmentListToAppointmentDtoList(List<Appointment> appointmentList);
}
