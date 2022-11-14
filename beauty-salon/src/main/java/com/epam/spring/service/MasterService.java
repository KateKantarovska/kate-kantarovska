package com.epam.spring.service;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.model.Review;

import java.util.List;

public interface MasterService {
  MasterDto createMaster(MasterDto masterDto);

  MasterDto getMaster(Integer id);

  MasterDto updateMaster(MasterDto masterDto);

  List<MasterDto> listMasters(String sortBy, Integer pageNo);

  MasterDto updateMasterRating(Integer masterId, List<Review> masterReviewList);
}
