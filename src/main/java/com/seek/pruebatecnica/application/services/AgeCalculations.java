package com.seek.pruebatecnica.application.services;

import com.seek.pruebatecnica.domain.entities.Client;

import java.util.List;

public interface AgeCalculations {

    Integer averageAge(List<Client> clients);

    Double standardDeviation(List<Client> clients);

}
