package com.seek.pruebatecnica.infrastructure.adapters.restcontrollers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.ports.in.CalculateAverageAgeUseCase;
import com.seek.pruebatecnica.domain.ports.in.CalculateStandardDeviationUseCase;
import com.seek.pruebatecnica.domain.ports.in.CreateClientUseCase;
import com.seek.pruebatecnica.domain.ports.in.FindAllClientsUseCase;
import com.seek.pruebatecnica.infrastructure.adapters.restcontrollers.dtos.CreateClientRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientRestControllerTest {

    @Mock
    private CreateClientUseCase createClientUseCase;
    @Mock
    private CalculateAverageAgeUseCase calculateAverageAgeUseCase;
    @Mock
    private CalculateStandardDeviationUseCase calculateStandardDeviationUseCase;
    @Mock
    private FindAllClientsUseCase findAllClientsUseCase;

    @InjectMocks
    private ClientRestController clientRestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientRestController).build();
    }

    @DisplayName("Should create a Client and return code 201")
    @Test
    void createClient() throws Exception {

        var request = CreateClientRequest.builder()
                .name("John")
                .lastname("Doe")
                .birthdate(LocalDate.of(1990, 5, 15))
                .age(33)
                .build();

        var client = Client.builder()
                .name("John")
                .lastname("Doe")
                .age(33)
                .build();

        when(createClientUseCase.execute(any(Client.class))).thenReturn(client);

        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertToJson(request)))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"name\":\"John\",\"age\":33}"));
        verify(createClientUseCase, times(1)).execute(any(Client.class));
    }

    @DisplayName("missing name, should return error 400 ")
    @Test
    void createClient_missingName_shouldReturn400() throws Exception {
        var request = "{" +
                "    \"lastname\": \"Muller\", " +
                "    \"birthdate\": \"1987-03-02\", " +
                "    \"age\": 37 " +
                "}";
        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }

    @DisplayName("missing lastname, should return error 400 ")
    @Test
    void createClient_missingLastName_shouldReturn400() throws Exception {
        var request = "{" +
                "    \"name\": \"Joaquin\", " +
                "    \"birthdate\": \"1987-03-02\", " +
                "    \"age\": 37 " +
                "}";
        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());

    }

    @DisplayName("Invalid Age, should return error 400 ")
    @Test
    void createClient_invalidAge_shouldReturn400() throws Exception {
        var request = "{" +
                "    \"name\": \"Joaquin\", " +
                "    \"lastname\": \"Muller\", " +
                "    \"birthdate\": \"1987-03-02\", " +
                "    \"age\": 0 " +
                "}";

        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }

    @DisplayName("Invalid birthdate, should return error 400 ")
    @Test
    void createClient_invalidBirthdate_shouldReturn400() throws Exception {
        var request = "{" +
                "    \"name\": \"Joaquin\", " +
                "    \"lastname\": \"Muller\", " +
                "    \"birthdate\": \"2023-13-50\", " +
                "    \"age\": 37 " +
                "}";
        mockMvc.perform(post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }

    private String convertToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(object);
    }


}

