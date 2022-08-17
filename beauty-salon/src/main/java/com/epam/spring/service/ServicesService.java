package com.epam.spring.service;

import com.epam.spring.dto.ServiceDto;

import java.util.List;

public interface ServicesService {
  ServiceDto createService(ServiceDto serviceDto);

  ServiceDto getService(Integer id);

  List<ServiceDto> listServices(String filterBy, Integer id);
}
