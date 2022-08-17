package com.epam.spring.controller;

import com.epam.spring.dto.ClientDto;
import com.epam.spring.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {
  private final ClientService clientService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/client")
  public ClientDto createClient(@RequestBody ClientDto clientDto) {
    return clientService.createClient(clientDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/client/{id}")
  public ClientDto getClient(@PathVariable Integer id) {
    return clientService.getClient(id);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/client/{id}")
  public ClientDto updateClient(@RequestBody ClientDto clientDto, @PathVariable Integer id) {
    return clientService.updateClient(clientDto, id);
  }
}
