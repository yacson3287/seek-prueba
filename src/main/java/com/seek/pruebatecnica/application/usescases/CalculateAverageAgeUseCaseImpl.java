package com.seek.pruebatecnica.application.usescases;

import com.seek.pruebatecnica.annotations.UseCase;
import com.seek.pruebatecnica.application.services.AgeCalculations;
import com.seek.pruebatecnica.domain.exceptions.BadRequestExceptionService;
import com.seek.pruebatecnica.domain.exceptions.ExceptionDetail;
import com.seek.pruebatecnica.domain.ports.in.CalculateAverageAgeUseCase;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CalculateAverageAgeUseCaseImpl implements CalculateAverageAgeUseCase {

    private final ClientRepository clientRepository;
    private final AgeCalculations ageCalculations;

    @Override
    public Integer execute() {
        var clients = clientRepository.findAll();

        if(clients.isEmpty()){
            var exception = new ExceptionDetail("The transaction cannot be completed because there are no customers.");
            throw new BadRequestExceptionService(exception);
        }

        return ageCalculations.averageAge(clients);
    }


}
