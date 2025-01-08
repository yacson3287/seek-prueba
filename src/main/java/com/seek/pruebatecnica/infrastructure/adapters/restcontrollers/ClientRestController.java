package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers;

import com.seek.pruebatecnica.domain.ports.in.CalculateAverageAgeUseCase;
import com.seek.pruebatecnica.domain.ports.in.CalculateStandardDeviationUseCase;
import com.seek.pruebatecnica.domain.ports.in.CreateClientUseCase;
import com.seek.pruebatecnica.domain.ports.in.FindAllClientsUseCase;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.ClientResponse;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.ClientWithLifeExpectancyResponse;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.CreateClientRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Tag(name = "Client", description = "CRUD")
public class ClientRestController {

    private final CreateClientUseCase createClientUseCase;
    private final CalculateAverageAgeUseCase calculateAverageAgeUseCase;
    private final CalculateStandardDeviationUseCase calculateStandardDeviationUseCase;
    private final FindAllClientsUseCase findAllClientsUseCase;


    @Operation(summary = "Create new Client")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClientResponse create(@RequestBody @Valid CreateClientRequest request) {
        var client = createClientUseCase.execute(request.convertToDomain());
        return ClientResponse.convertFromDomain(client);
    }

    @Operation(summary = "Calculate age average")
    @GetMapping("/average-age")
    public Integer averageAge() {
        return calculateAverageAgeUseCase.execute();
    }

    @Operation(summary = "Calculate standard deviation")
    @GetMapping("/standard-deviation")
    public Double standardDeviation() {
        return calculateStandardDeviationUseCase.execute();
    }

    @Operation(summary = "List all Clients with expectancy of life")
    @GetMapping
    public List<ClientWithLifeExpectancyResponse> findAll(){
        var clients = findAllClientsUseCase.execute();
        return clients.stream()
                .map(ClientWithLifeExpectancyResponse::convertFromDomain)
                .toList();
    }


}
