package com.seek.pruebatecnica.infrastructure.adapters.repositories;

import com.seek.pruebatecnica.domain.entities.Client;
import com.seek.pruebatecnica.domain.exceptions.ExceptionDetail;
import com.seek.pruebatecnica.domain.exceptions.InternalServerErrorExceptionService;
import com.seek.pruebatecnica.domain.ports.out.ClientRepository;
import com.seek.pruebatecnica.infrastructure.db.jpa.model.ClientJPA;
import com.seek.pruebatecnica.infrastructure.db.jpa.repositories.ClientJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientJPARepository clientJPARepository;
    private static final String ERROR = "ups, an unexpected error occurred";

    @Transactional
    @Override
    public Client save(Client client) {
        try {

            var clientJPA = clientJPARepository.save(ClientJPA.convertFromDomain(client));
            return clientJPA.convertToDomain();

        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new InternalServerErrorExceptionService(ERROR);
        }

    }

    @Override
    public List<Client> findAll() {
        try {

            var clientsJPA = clientJPARepository.findAll();
            return clientsJPA.stream()
                    .map(ClientJPA::convertToDomain)
                    .toList();

        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new InternalServerErrorExceptionService(ERROR);
        }
    }

    @Override
    public Client findById(Long id) {
        return null;
    }


}
