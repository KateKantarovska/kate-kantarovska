package com.epam.spring.controller;

import com.epam.spring.dto.MasterDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.service.MasterService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class MasterController {
  private final MasterService masterService;

  @ApiOperation("Create a master")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/master")
  @Validated(OnCreate.class)
  public MasterDto createMaster(@Validated(OnCreate.class) @RequestBody MasterDto masterDto) {
    return masterService.createMaster(masterDto);
  }

  @ApiOperation("Get a master by id")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "master id")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/master/{id}")
  public MasterDto getMaster(@PathVariable Integer id) {
    return masterService.getMaster(id);
  }

  @ApiOperation("Get a list of masters (sorted by name or rating)")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "sortBy", paramType = "query", value = "sorting parameter"),
    @ApiImplicitParam(name = "page", paramType = "query", value = "page number")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/masters")
  public List<MasterDto> listAllMasters(
      @RequestParam(defaultValue = "name") String sortBy,
      @RequestParam(defaultValue = "1") Integer page) {
    return masterService.listMasters(sortBy, page - 1);
  }
}
