package com.epam.spring.repository.impl;

import com.epam.spring.exception.EntityNotFoundException;
import com.epam.spring.model.Client;
import com.epam.spring.model.EntityName;
import com.epam.spring.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
  private final List<Client> list = new ArrayList<>();

  @Override
  public Client createClient(Client client) {
    list.add(client);
    return client;
  }

  @Override
  public Client getClient(String email) {
    return list.stream()
        .filter(client -> client.getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(EntityName.CLIENT));
  }

  @Override
  public Client getClient(Integer id) {
    return list.stream()
        .filter(client -> client.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(EntityName.CLIENT));
  }

  @Override
  public Client updateClient(Client client, Integer id) {
    boolean isDeleted = list.removeIf(client1 -> client1.getId().equals(id));
    if (isDeleted) {
      list.add(client);
    } else {
      throw new EntityNotFoundException(EntityName.CLIENT);
    }
    return client;
  }
}
