package com.epam.spring.repository.impl;

import com.epam.spring.exception.EntityNotFoundException;
import com.epam.spring.model.EntityName;
import com.epam.spring.model.Service;
import com.epam.spring.repository.ServiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
        .orElseThrow(() -> new EntityNotFoundException(EntityName.SERVICE));
  }

  @Override
  public List<Service> listServices() {
    return new ArrayList<>(list);
  }
}
