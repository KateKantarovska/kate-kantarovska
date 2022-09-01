package com.epam.spring.controller;

import com.epam.spring.dto.ClientDto;
import com.epam.spring.dto.group.OnCreate;
import com.epam.spring.dto.group.OnUpdate;
import com.epam.spring.service.ClientService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/client")
public class ClientController {
  private final ClientService clientService;

  @ApiOperation("Create a client")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ClientDto createClient(@Validated(OnCreate.class) @RequestBody ClientDto clientDto) {
    return clientService.createClient(clientDto);
  }

  @ApiOperation("Get a client by id")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "client id")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  public ClientDto getClient(@PathVariable Integer id) {
    return clientService.getClient(id);
  }

  @ApiOperation("Update a client")
  @ApiImplicitParam(
      name = "id",
      paramType = "path",
      dataTypeClass = Integer.class,
      required = true,
      value = "client id")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public ClientDto updateClient(
      @Validated(OnUpdate.class) @RequestBody ClientDto clientDto, @PathVariable Integer id) {
    return clientService.updateClient(clientDto, id);
  }
}
