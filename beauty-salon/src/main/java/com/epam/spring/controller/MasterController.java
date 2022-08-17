package com.epam.spring.controller;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.service.MasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MasterController {
  private final MasterService masterService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/master")
  public MasterDto createMaster(@RequestBody MasterDto masterDto) {
    return masterService.createMaster(masterDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/master/{id}")
  public MasterDto getMaster(@PathVariable Integer id) {
    return masterService.getMaster(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/masters")
  public List<MasterDto> listAllMasters(@RequestParam(defaultValue = "name") String sortBy) {
    return masterService.listMasters(sortBy);
  }
}
