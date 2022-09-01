package com.epam.spring.repository.impl;

import com.epam.spring.exception.EntityNotFoundException;
import com.epam.spring.model.EntityName;
import com.epam.spring.model.Master;
import com.epam.spring.repository.MasterRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MasterRepositoryImpl implements MasterRepository {
  private final List<Master> list = new ArrayList<>();

  @Override
  public Master createMaster(Master master) {
    list.add(master);
    return master;
  }

  @Override
  public Master getMaster(String email) {
    return list.stream()
        .filter(master -> master.getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(EntityName.MASTER));
  }

  @Override
  public Master getMaster(Integer id) {
    return list.stream()
        .filter(master -> master.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(EntityName.MASTER));
  }

  @Override
  public List<Master> listMasters() {
    return new ArrayList<>(list);
  }
}
