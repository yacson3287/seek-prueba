package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
}
