package com.example.timestamp.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un registro de tiempo en el sistema
 * Se mapea a la tabla 'timestamps' en la base de datos
 */
@Entity
@Table(name = "timestamps")
public class Timestamp {
    /**
     * Identificador único del registro
     * Se genera automáticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha y hora de creación del registro
     * Se almacena como String en la columna 'created_at'
     */
    @Column(name = "created_at")
    private String createdAt;

    /**
     * Obtiene el ID del registro
     * @return el ID del timestamp
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene la fecha y hora de creación
     * @return String con la fecha y hora de creación
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Establece el ID del registro
     * @param id el ID a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Establece la fecha y hora de creación
     * @param createdAt String con la fecha y hora a establecer
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
