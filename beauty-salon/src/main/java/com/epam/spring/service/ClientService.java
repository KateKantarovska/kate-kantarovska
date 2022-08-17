package com.epam.spring.service;

import com.epam.spring.dto.ClientDto;

public interface ClientService {
  ClientDto createClient(ClientDto clientDto);

  ClientDto getClient(Integer id);

  ClientDto updateClient(ClientDto clientDto, Integer id);
}
