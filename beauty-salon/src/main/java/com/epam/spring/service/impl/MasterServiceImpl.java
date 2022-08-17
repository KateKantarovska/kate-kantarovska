package com.epam.spring.service.impl;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.mapper.MasterMapper;
import com.epam.spring.model.Master;
import com.epam.spring.repository.MasterRepository;
import com.epam.spring.service.MasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {
  private final MasterRepository masterRepository;

  @Override
  public MasterDto createMaster(MasterDto masterDto) {
    log.info("create master with email {}", masterDto.getEmail());
    Master master = MasterMapper.INSTANCE.mapMasterDtoToMaster(masterDto);
    master = masterRepository.createMaster(master);
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }

  @Override
  public MasterDto getMaster(Integer id) {
    log.info("get master with id {}", id);
    Master master = masterRepository.getMaster(id);
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }

  @Override
  public List<MasterDto> listMasters(String sortBy) {
    log.info("list all masters");
    List<Master> masterList = masterRepository.listMasters();
    if (sortBy.equals("name")) {
      masterList.sort(Comparator.comparing(Master::getName).thenComparing(Master::getSurname));
    } else if (sortBy.equals("rating")) {
      masterList.sort(Comparator.comparing(Master::getRating).reversed());
    }
    return MasterMapper.INSTANCE.mapMasterListToMasterDtoList(masterList);
  }
}
