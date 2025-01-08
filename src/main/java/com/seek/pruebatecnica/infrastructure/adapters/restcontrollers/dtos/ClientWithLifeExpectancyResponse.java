package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos;

import com.seek.pruebatecnica.domain.entities.Client;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientWithLifeExpectancyResponse {

    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private int age;
    private int lifeExpectancy;

    public static ClientWithLifeExpectancyResponse convertFromDomain(Client client) {
        return new ModelMapper().map(client, ClientWithLifeExpectancyResponse.class);
    }
}
