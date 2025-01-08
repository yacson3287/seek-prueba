package com.seek.pruebatecnica.domain.ports.out;

import com.seek.pruebatecnica.domain.entities.Client;

import java.util.List;

public interface ClientRepository {

    Client save(Client client);

    List<Client> findAll();

    Client findById(Long id);
}
