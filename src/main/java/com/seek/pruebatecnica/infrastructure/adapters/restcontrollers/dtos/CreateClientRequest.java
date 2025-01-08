package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos;

import com.seek.pruebatecnica.domain.entities.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;

    private LocalDate birthdate;
    @Min(value = 1)
    private int age;


    public Client convertToDomain() {
        return new ModelMapper().map(this, Client.class);
    }
}
