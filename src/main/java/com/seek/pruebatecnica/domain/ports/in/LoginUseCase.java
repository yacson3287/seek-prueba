package com.seek.pruebatecnica.domain.ports.in;

import com.seek.pruebatecnica.domain.entities.User;

public interface LoginUseCase {

    String execute(User user);
}
