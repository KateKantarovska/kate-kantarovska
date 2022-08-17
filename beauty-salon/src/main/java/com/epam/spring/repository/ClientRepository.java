package com.epam.spring.repository;

import com.epam.spring.model.Client;

public interface ClientRepository {
  Client createClient(Client client);

  Client getClient(String email);

  Client getClient(Integer id);

  Client updateClient(Client client, Integer id);
}
