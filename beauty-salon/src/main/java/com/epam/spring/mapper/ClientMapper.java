package com.epam.spring.mapper;

import com.epam.spring.dto.ClientDto;
import com.epam.spring.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  ClientDto mapClientToClientDto(Client client);

  Client mapClientDtoToClient(ClientDto clientDto);
}
