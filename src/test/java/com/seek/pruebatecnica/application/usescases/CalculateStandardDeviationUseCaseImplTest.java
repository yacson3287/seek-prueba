package com.seek.pruebatecnica.application.usescases;

import com.google.gson.Gson;
import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.exceptions.BadRequestExceptionService;
import com.seek.pruebatecnica.domain.exceptions.ExceptionDetail;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateStandardDeviationUseCaseImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CalculateStandardDeviationUseCaseImpl calculateStandardDeviationUseCase;
    private List<Client> clients;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @DisplayName("Should return a exception when client list is empty")
    @Test
    void execute() {

        Mockito.when(clientRepository.findAll()).thenReturn(new ArrayList<>());
        var result = assertThrows(BadRequestExceptionService.class, () -> {
            calculateStandardDeviationUseCase.execute();
        });

        var exceptionDetail = new Gson().fromJson(result.getMessage(), ExceptionDetail.class);

        assertEquals("The transaction cannot be completed because there are no customers.", exceptionDetail.getMessage());
    }

}