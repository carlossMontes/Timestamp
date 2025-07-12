package com.example.timestamp.controller;

import com.example.timestamp.model.Timestamp;
import com.example.timestamp.service.TimestampService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones relacionadas con timestamps
 * Expone endpoints para gestionar registros de tiempo
 */
@RestController
@RequestMapping("/timestamps")
public class TimestampController {

    /**
     * Servicio que contiene la lógica de negocio para timestamps
     */
    @Autowired
    private TimestampService service;

    /**
     * Obtiene todos los registros de timestamps almacenados
     * @return Lista de todos los timestamps disponibles
     */
    @GetMapping
    public List<Timestamp> getTimestamps() {
        return service.getAllTimestamps();
    }
}
