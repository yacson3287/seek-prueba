package com.seek.pruebatecnica.application.services.impl;

import com.seek.pruebatecnica.annotations.ApplicationService;
import com.seek.pruebatecnica.application.services.AgeCalculations;
import com.seek.pruebatecnica.domain.entities.Client;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class AgeCalculationsImpl implements AgeCalculations {


    @Override
    public Integer averageAge(List<Client> clients) {
        var ages = getAges(clients);
        return average(ages);
    }

    @Override
    public Double standardDeviation(List<Client> clients) {
        var ages = getAges(clients);
        var average = average(ages);

        double sumOfSquareDifferences = ages.stream()
                .map(age -> Math.pow((age - average), 2))
                .reduce(0.0, Double::sum);

        return Math.sqrt(sumOfSquareDifferences / ages.size());
    }

    private Integer average(List<Integer> ages) {
        int sumAges = ages.stream().mapToInt(Integer::intValue).sum();
        return sumAges / ages.size();
    }

    private List<Integer> getAges(List<Client> clients) {
        return clients.stream()
                .map(Client::getAge)
                .toList();

    }


}
