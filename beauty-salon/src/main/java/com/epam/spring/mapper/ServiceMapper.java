package com.epam.spring.mapper;

import com.epam.spring.dto.ServiceDto;
import com.epam.spring.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceMapper {
  ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

  Service mapServiceDtoToService(ServiceDto serviceDto);

  ServiceDto mapServiceToServiceDto(Service service);

  List<ServiceDto> mapServiceListToServiceDtoList(List<Service> serviceList);
}
