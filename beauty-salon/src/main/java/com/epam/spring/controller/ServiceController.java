package com.epam.spring.controller;

import com.epam.spring.dto.ServiceDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.service.ServicesService;
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
public class ServiceController {
  private final ServicesService servicesService;

  @ApiOperation("Create a service")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/service")
  ServiceDto createService(@Validated(OnCreate.class) @RequestBody ServiceDto serviceDto) {
    return servicesService.createService(serviceDto);
  }

  @ApiOperation("Get a service by id")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "service id")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/service/{id}")
  ServiceDto getServiceById(@PathVariable Integer id) {
    return servicesService.getService(id);
  }

  @ApiOperation("Get a list of services (filtered by master id or category id)")
  @ApiImplicitParams({
    @ApiImplicitParam(
        name = "filterBy",
        paramType = "query",
        dataTypeClass = String.class,
        value = "filtering parameter"),
    @ApiImplicitParam(name = "id", paramType = "query", value = "master id or category id")
  })
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/services")
  List<ServiceDto> getAllServices(@RequestParam String filterBy, @RequestParam Integer id) {
    return servicesService.listServices(filterBy, id);
  }
}
