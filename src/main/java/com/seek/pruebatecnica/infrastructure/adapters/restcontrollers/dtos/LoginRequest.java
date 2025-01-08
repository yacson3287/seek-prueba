package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos;

import com.seek.pruebatecnica.domain.entities.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {
    private String username;
    private String password;


    public User convertToEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
