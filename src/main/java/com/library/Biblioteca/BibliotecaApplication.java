package com.library.Biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. All rights reserved.
 * Licensed for private academic use only. Unauthorized distribution prohibited.
 *
 * Asignatura: Programación Avanzada
 * Semestre: 2025–I
 * Profesora: María Fernanda Díaz Hernández
 * Grupo: 020-81
 *
 * <p>Clase de arranque de la aplicación Spring Boot para el sistema de gestión de biblioteca.</p>
 *
 * <p>Configura el escaneo de componentes y la habilitación de repositorios JPA.</p>
 *
 * Autores:
 * <ul>
 *   <li>Juan David Mayorga López – ID 20232020116 – Desarrollador Backend</li>
 *   <li>Ángel Iván López Rodríguez – ID 20232020113 – Analista de Requisitos</li>
 *   <li>Edgar Andrés Ángel Pulido – ID 20232020133 – QA & Documentación</li>
 * </ul>
 *
 * @version 1.0
 * @since 2025-04-30
 */
@SpringBootApplication
@ComponentScan("com.library.controlador")
@EnableJpaRepositories("com.library.repositorio")
public class BibliotecaApplication {

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

}
