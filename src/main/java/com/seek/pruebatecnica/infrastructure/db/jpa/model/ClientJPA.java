package com.seek.pruebatecnica.infrastructure.db.jpa.model;

import com.seek.pruebatecnica.domain.entities.Client;
import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "clients")
public class ClientJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private int age;
    private LocalDate createAt;

    public static ClientJPA convertFromDomain(Client client) {
        return new ModelMapper().map(client, ClientJPA.class);
    }

    public Client convertToDomain() {
        return new ModelMapper().map(this, Client.class);
    }

}
