package com.seek.pruebatecnica.infrastructure.db.jpa.repositories;

import com.seek.pruebatecnica.infrastructure.db.jpa.model.ClientJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJPARepository  extends JpaRepository<ClientJPA, Long> {
}
