package com.epam.spring.mapper;

import com.epam.spring.dto.ServiceDto;
import com.epam.spring.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceMapper {
  ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

  Service mapServiceDtoToService(ServiceDto serviceDto);

  @Mapping(target = "category.services", ignore = true)
  ServiceDto mapServiceToServiceDto(Service service);

  List<ServiceDto> mapServiceListToServiceDtoList(List<Service> serviceList);
}
