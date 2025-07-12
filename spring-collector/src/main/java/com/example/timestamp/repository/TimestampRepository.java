package com.example.timestamp.repository;

import com.example.timestamp.model.Timestamp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio que maneja las operaciones de persistencia para la entidad Timestamp
 * Extiende JpaRepository para heredar las operaciones CRUD básicas
 * 
 * @param <Timestamp> Entidad que se va a persistir
 * @param <Long> Tipo de dato del identificador de la entidad
 */
public interface TimestampRepository extends JpaRepository<Timestamp, Long> {
    // Las operaciones CRUD básicas son heredadas de JpaRepository:
    // save(), findAll(), findById(), deleteById(), etc.
}
