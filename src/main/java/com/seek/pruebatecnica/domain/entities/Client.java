package com.seek.pruebatecnica.domain.entities;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client {
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private int age;
    private LocalDate createAt;
    private int lifeExpectancy;
}
