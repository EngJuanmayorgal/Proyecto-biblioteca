package com.library.controlador;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. All rights reserved.
 * Licensed for private academic use only. Unauthorized distribution prohibited.
 *
 * Asignatura: Programación Avanzada Semestre: 2025–I Profesora: María Fernanda
 * Díaz Hernández Grupo: 020-81
 *
 * <p>
 * Clase GestorLibros responsable de las operaciones CRUD sobre los registros de
 * libros en el sistema de biblioteca.</p>
 *
 * Funcionalidades:
 * <ul>
 * <li>Añadir nuevos libros al catálogo.</li>
 * <li>Editar información de libros existentes.</li>
 * <li>Eliminar libros del catálogo.</li>
 * <li>Consultar disponibilidad de libros.</li>
 * </ul>
 *
 * Autores:
 * <ul>
 * <li>Juan David Mayorga López – ID 20232020116 – Desarrollador Backend</li>
 * <li>Ángel Iván López Rodríguez – ID 20232020113 – Analista de Requisitos</li>
 * <li>Edgar Andrés Ángel Pulido – ID 20232020133 – QA & Documentación</li>
 * </ul>
 *
 * @version 1.0
 * @since 2025-04-30
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GestorLibros {

    
    
    public ArrayList verLibros(){
    
    
    }   
    /**
     * Añade un nuevo libro al catálogo de la biblioteca.
     */
    public void AñadirLibro() {
    }

    /**
     * Edita la información de un libro existente.
     */
    public void EditarLibro() {
    }

    /**
     * Elimina un libro del catálogo de la biblioteca.
     */
    public void EliminarLibro() {
    }

    /**
     * Consulta la disponibilidad de un libro en el sistema.
     */
    public void ConsultarDisponibilidad() {
    }
}
