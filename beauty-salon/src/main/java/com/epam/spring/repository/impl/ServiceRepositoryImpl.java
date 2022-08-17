package com.epam.spring.repository.impl;

import com.epam.spring.model.Service;
import com.epam.spring.repository.ServiceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceRepositoryImpl implements ServiceRepository {
  private final List<Service> list = new ArrayList<>();

  @Override
  public Service createService(Service service) {
    list.add(service);
    return service;
  }

  @Override
  public Service getService(Integer id) {
    return list.stream()
        .filter(service -> service.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("service has not been found"));
  }

  @Override
  public List<Service> listServices() {
    return new ArrayList<>(list);
  }
}
