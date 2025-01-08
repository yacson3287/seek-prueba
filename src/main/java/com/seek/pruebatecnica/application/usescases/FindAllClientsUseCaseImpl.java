package com.seek.pruebatecnica.application.usescases;

import com.seek.pruebatecnica.annotations.UseCase;
import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.ports.in.FindAllClientsUseCase;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllClientsUseCaseImpl implements FindAllClientsUseCase {

    private static final int EXPECTANCY = 90;

    private final ClientRepository clientRepository;

    @Override
    public List<Client> execute() {
        var clients = clientRepository.findAll();
        calculatedLifeExpectancy(clients);
        return clients;
    }

    private void calculatedLifeExpectancy(List<Client> clients) {
        clients.forEach(client ->
                client.setLifeExpectancy(EXPECTANCY - client.getAge())
        );
    }


}
