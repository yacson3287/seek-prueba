package com.seek.pruebatecnica.domain.ports.out;

import com.seek.pruebatecnica.domain.entities.User;

public interface UserRepository {
    User findByUsername(String username);

    String login(User user);
}
