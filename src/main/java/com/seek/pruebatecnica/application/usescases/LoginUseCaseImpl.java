package com.seek.pruebatecnica.application.usescases;

import com.seek.pruebatecnica.annotations.UseCase;
import com.seek.pruebatecnica.domain.entities.User;
import com.seek.pruebatecnica.domain.ports.in.LoginUseCase;
import com.seek.pruebatecnica.domain.ports.out.UserRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final UserRepository userRepository;

    @Override
    public String execute(User user) {
        return userRepository.login(user);
    }
}
