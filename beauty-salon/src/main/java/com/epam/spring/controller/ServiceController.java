package com.epam.spring.controller;

import com.epam.spring.dto.ServiceDto;
import com.epam.spring.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController {
  private final ServicesService servicesService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/service")
  ServiceDto createService(@RequestBody ServiceDto serviceDto) {
    return servicesService.createService(serviceDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "service/{id}")
  ServiceDto getServiceById(@PathVariable Integer id) {
    return servicesService.getService(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/services")
  List<ServiceDto> getAllServices(@RequestParam String filterBy, @RequestParam Integer id) {
    return servicesService.listServices(filterBy, id);
  }
}
