package com.epam.spring.repository;

import com.epam.spring.model.Service;

import java.util.List;

public interface ServiceRepository {
  Service createService(Service service);

  Service getService(Integer id);

  List<Service> listServices();
}
