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
public class ClientResponse {
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private int age;

    public static ClientResponse convertFromDomain(Client client) {
        return new ModelMapper().map(client, ClientResponse.class);
    }
}
