package com.epam.spring.service.impl;

import com.epam.spring.dto.*;
import com.epam.spring.mapper.ServiceMapper;
import com.epam.spring.repository.ServiceRepository;
import com.epam.spring.service.ServicesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {
  private final ServiceRepository serviceRepository;

  @Override
  public ServiceDto createService(ServiceDto serviceDto) {
    log.info("create service with name {}", serviceDto.getName());
    var service = ServiceMapper.INSTANCE.mapServiceDtoToService(serviceDto);
    service = serviceRepository.createService(service);
    return ServiceMapper.INSTANCE.mapServiceToServiceDto(service);
  }

  @Override
  public ServiceDto getService(Integer id) {
    log.info("get service with id {}", id);
    var service = serviceRepository.getService(id);
    return ServiceMapper.INSTANCE.mapServiceToServiceDto(service);
  }

  @Override
  public List<ServiceDto> listServices(String filterBy, Integer id) {
    log.info("get list of services");
    var serviceList = serviceRepository.listServices();
    if (filterBy != null) {
      serviceList = switch (filterBy) {
        case "master" ->
              serviceList.stream()
                  .filter(
                      service ->
                          service.getMastersList().stream()
                              .anyMatch(master -> master.getId().equals(id)))
                  .toList();
        case "category" ->
              serviceList.stream()
                  .filter(service -> service.getCategory().getId().equals(id))
                  .toList();
        default -> serviceList;
      };
    }
    return ServiceMapper.INSTANCE.mapServiceListToServiceDtoList(serviceList);
  }
}
