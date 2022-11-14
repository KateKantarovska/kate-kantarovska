package com.epam.spring.service.impl;

import com.epam.spring.dto.ClientDto;
import com.epam.spring.exception.EntityNotFoundException;
import com.epam.spring.mapper.ClientMapper;
import com.epam.spring.model.Client;
import com.epam.spring.model.EntityName;
import com.epam.spring.repository.ClientRepository;
import com.epam.spring.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
  private final ClientRepository clientRepository;

  @Override
  public ClientDto createClient(ClientDto clientDto) {
    log.info("create client with email {}", clientDto.getEmail());
    Client client = ClientMapper.INSTANCE.mapClientDtoToClient(clientDto);
    client = clientRepository.save(client);
    return ClientMapper.INSTANCE.mapClientToClientDto(client);
  }

  @Override
  public ClientDto getClient(Integer id) {
    log.info("get client by id {}", id);
    Client client =
        clientRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(EntityName.CLIENT));
    return ClientMapper.INSTANCE.mapClientToClientDto(client);
  }

  @Override
  public ClientDto updateClient(ClientDto clientDto, Integer id) {
    log.info("update client with email {}", clientDto.getEmail());
    Client client = ClientMapper.INSTANCE.mapClientDtoToClient(clientDto);
    client = clientRepository.save(client);
    return ClientMapper.INSTANCE.mapClientToClientDto(client);
  }
}
