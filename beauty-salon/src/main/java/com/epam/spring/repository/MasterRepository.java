package com.epam.spring.repository;

import com.epam.spring.model.Master;

import java.util.List;

public interface MasterRepository {
  Master createMaster(Master master);

  Master getMaster(String email);

  Master getMaster(Integer id);

  List<Master> listMasters();
}
