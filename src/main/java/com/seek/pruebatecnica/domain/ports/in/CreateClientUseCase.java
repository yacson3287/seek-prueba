package com.seek.pruebatecnica.domain.ports.in;

import com.seek.pruebatecnica.domain.entities.Client;

public interface CreateClientUseCase {

    Client execute(Client client);
}
