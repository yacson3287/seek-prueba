package com.seek.pruebatecnica.application.services.impl;

import com.seek.pruebatecnica.domain.entities.Client;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeCalculationsImplTest {

    @InjectMocks
    private AgeCalculationsImpl ageCalculations;

    private List<Client> clients;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clients = getClients();
    }

    @DisplayName("Should return average age for a client list")
    @Test
    void averageAge() {
        var result = ageCalculations.averageAge(clients);
        assertEquals(37, result);
    }

    @DisplayName("Should return standard deviation the ages for a client list")
    @Test
    void standardDeviation() {
        var result = ageCalculations.standardDeviation(clients);
        assertEquals(5.0990195135927845, result);


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