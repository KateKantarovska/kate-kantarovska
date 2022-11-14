package com.epam.spring.service.impl;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.exception.EntityNotFoundException;
import com.epam.spring.mapper.MasterMapper;
import com.epam.spring.model.EntityName;
import com.epam.spring.model.Master;
import com.epam.spring.model.Review;
import com.epam.spring.repository.MasterRepository;
import com.epam.spring.service.MasterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    master = masterRepository.save(master);
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }

  @Override
  public MasterDto getMaster(Integer id) {
    log.info("get master with id {}", id);
    Master master =
        masterRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(EntityName.MASTER));
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }

  @Override
  public MasterDto updateMaster(MasterDto masterDto) {
    log.info("update master with id {}", masterDto.getId());
    Master master = MasterMapper.INSTANCE.mapMasterDtoToMaster(masterDto);
    masterRepository.save(master);
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }

  @Override
  public List<MasterDto> listMasters(String sortBy, Integer pageNo) {
    log.info("list all masters");
    List<Master> masters;
    if (sortBy == null) {
      masters = masterRepository.findAll();
    } else if (sortBy.equals("name")) {
      Pageable sortedByName =
          PageRequest.of(pageNo, 10, Sort.by("name").and(Sort.by("surname")).ascending());
      Page<Master> mastersPage = masterRepository.findAll(sortedByName);
      masters = mastersPage.getContent();
    } else if (sortBy.equals("rating")) {
      Pageable sortedByRating = PageRequest.of(pageNo, 10, Sort.by("rating").descending());
      Page<Master> mastersPage = masterRepository.findAll(sortedByRating);
      masters = mastersPage.getContent();
    } else {
      throw new IllegalArgumentException();
    }
    return MasterMapper.INSTANCE.mapMasterListToMasterDtoList(masters);
  }

  @Override
  public MasterDto updateMasterRating(Integer masterId, List<Review> masterReviewList) {
    float newMasterRating =
        (float)
            masterReviewList.stream()
                .map(Review::getRating)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    Master master = masterRepository.getById(masterId);
    master.setRating(newMasterRating);
    master = masterRepository.save(master);
    return MasterMapper.INSTANCE.mapMasterToMasterDto(master);
  }
}
