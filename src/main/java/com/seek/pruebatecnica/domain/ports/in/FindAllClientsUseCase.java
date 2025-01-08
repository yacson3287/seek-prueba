package com.seek.pruebatecnica.domain.ports.in;

import com.seek.pruebatecnica.domain.entities.Client;

import java.util.List;

public interface FindAllClientsUseCase {
    List<Client> execute();

}
