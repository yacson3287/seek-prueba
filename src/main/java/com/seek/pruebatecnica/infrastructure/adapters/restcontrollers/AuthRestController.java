package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers;

import com.seek.pruebatecnica.domain.ports.in.LoginUseCase;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.AuthResponse;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.LoginRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Login")
public class AuthRestController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return new AuthResponse(loginUseCase.execute(loginRequest.convertToEntity()));
    }

}
