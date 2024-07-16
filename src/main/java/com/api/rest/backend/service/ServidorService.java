package com.api.rest.backend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.backend.exec.ServidorCreationException;
import com.api.rest.backend.dto.ServidorDTO;
import com.api.rest.backend.models.Servidor;
import com.api.rest.backend.repository.ServidorRepository;

import jakarta.transaction.Transactional;

@Service
public class ServidorService {
    private static final Logger logger = LoggerFactory.getLogger(ServidorService.class);

    @Autowired
    private ServidorRepository servidorRepository;

    public List<Servidor> getAllServidores() {
        return servidorRepository.findAll();
    }

    public Optional<Servidor> getServidorById(Long id) {
        return servidorRepository.findById(id);
    }

    @Transactional
    public ServidorDTO createServidor(ServidorDTO servidorDTO) {
        try {
            logger.debug("Criando servidor a partir do DTO: {}", servidorDTO);
            Servidor criarServidor = new Servidor(servidorDTO);
            Servidor saveServidor = servidorRepository.save(criarServidor);
            return new ServidorDTO(saveServidor);
        } catch (Exception e) {
            logger.error("Erro ao criar servidor: {}", e.getMessage());
            throw new ServidorCreationException("Não foi possível criar o servidor. Verifique os dados fornecidos.");
        }
    }
}
