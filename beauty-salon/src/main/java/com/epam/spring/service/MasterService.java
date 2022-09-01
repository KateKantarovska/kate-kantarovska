package com.epam.spring.service;

import com.epam.spring.dto.MasterDto;

import java.util.List;

public interface MasterService {
  MasterDto createMaster(MasterDto masterDto);

  MasterDto getMaster(Integer id);

  List<MasterDto> listMasters(String sortBy);
}
