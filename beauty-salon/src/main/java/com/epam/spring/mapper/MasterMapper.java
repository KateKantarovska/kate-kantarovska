package com.epam.spring.mapper;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.model.Master;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterMapper {
  MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);

  Master mapMasterDtoToMaster(MasterDto masterDto);

  MasterDto mapMasterToMasterDto(Master master);

  List<MasterDto> mapMasterListToMasterDtoList(List<Master> masterList);
}
