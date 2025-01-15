package com.seek.pruebatecnica.application.usescases;

import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindAllClientsUseCaseImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private FindAllClientsUseCaseImpl findAllClientsUseCase;

    private List<Client> clients;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clients = getClients();
    }

    @DisplayName("Should calculate the life expectancy for each client")
    @Test
    void execute() {
        when(clientRepository.findAll()).thenReturn(clients);
        var result = findAllClientsUseCase.execute();

        assertEquals(55,result.get(0).getLifeExpectancy());
        assertEquals(60,result.get(1).getLifeExpectancy());
    }

    private List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            var client = Client.builder()
                    .id((long) i)
                    .name("name_" + i)
                    .lastname("lastname_" + i)
                    .build();
            clients.add(client);
        }

        clients.get(0).setAge(35);
        clients.get(1).setAge(30);
        clients.get(2).setAge(35);
        clients.get(3).setAge(40);
        clients.get(4).setAge(45);

        return clients;
    }
}