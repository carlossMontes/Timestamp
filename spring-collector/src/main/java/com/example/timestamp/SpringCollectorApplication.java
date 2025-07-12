package com.example.timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot
 * Punto de entrada para el servicio de recolección de timestamps
 */
@SpringBootApplication
public class SpringCollectorApplication {
    
    /**
     * Método main que arranca la aplicación Spring Boot
     * Configura el contenedor y levanta el contexto de la aplicación
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCollectorApplication.class, args);
    }
}