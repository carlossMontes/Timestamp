package com.example.timestamp.service;

import com.example.timestamp.model.Timestamp;
import com.example.timestamp.repository.TimestampRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que implementa la lógica de negocio para la gestión de timestamps
 * Actúa como intermediario entre el controlador y el repositorio
 */
@Service
public class TimestampService {

    /**
     * Repositorio que maneja la persistencia de timestamps
     * Se inyecta automáticamente por Spring
     */
    @Autowired
    private TimestampRepository repository;

    /**
     * Recupera todos los timestamps almacenados en la base de datos
     * @return Lista con todos los registros de timestamps encontrados
     */
    public List<Timestamp> getAllTimestamps() {
        return repository.findAll();
    }
}
