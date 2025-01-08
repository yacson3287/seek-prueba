package com.seek.pruebatecnica.application.usescases;

import com.seek.pruebatecnica.annotations.UseCase;
import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.ports.in.CreateClientUseCase;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepository clientRepository;

    @Override
    public Client execute(Client client) {
        return clientRepository.save(client);
    }
}
