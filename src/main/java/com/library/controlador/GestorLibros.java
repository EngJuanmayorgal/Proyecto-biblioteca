package com.library.controlador;

import com.library.modelo.LibroDAO;
import com.library.modelo.LibroVO;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/libros/id_lector")
    public ArrayList verLibros(@RequestParam int id_lector) throws ClassNotFoundException {
        
        return new LibroDAO().MostrarLibros(id_lector);
    }

    @GetMapping("/hola")
    public String hola(){
        System.out.println("hollllaaa");
    return "holaaaae";
    }
    
    @GetMapping("/todos los libros")
    public ArrayList verLibros() throws ClassNotFoundException {
        return new LibroDAO().MostrarLibros();
    }

    /**
     * Añade un nuevo libro al catálogo de la biblioteca.
     */
    @PostMapping("/librosAgregar")
    public void AñadirLibro(@RequestBody Map<String, Object> credentials) throws ClassNotFoundException {
        String titulo = (String) credentials.get("titulo");
        String editorial = (String) credentials.get("editorial");
        String autor = (String) credentials.get("autor");
        String isbn = (String) credentials.get("isbn");
        int anio_publicacion = (int) credentials.get("anio_publicacion");
        String genero = (String) credentials.get("genero");
        int unidades = (int) credentials.get("unidades");
        String lectorDatos = "'" + titulo + "','" + autor + "','" + editorial + "','"
                + isbn + "','" + genero + "'," + anio_publicacion + "," + unidades;
        new LibroDAO().agregarLibro(lectorDatos);
    }

    /**
     * Edita la información de un libro existente.
     * @param credentials
     * @param id_libro
     */
    @PostMapping("/librosEditar")
    public void EditarLibro(@RequestBody Map<String, Object> credentials, int id_libro) throws ClassNotFoundException {
        String titulo = (String) credentials.get("titulo");
        String editorial = (String) credentials.get("editorial");
        String autor = (String) credentials.get("autor");
        String isbn = (String) credentials.get("isbn");
        int anio_publicacion = (int) credentials.get("anio_publicacion");
        String genero = (String) credentials.get("genero");
        int unidades = (int) credentials.get("unidades");
        LibroVO libro = new LibroVO(id_libro, titulo, editorial, autor, isbn, anio_publicacion, genero, unidades);
        new LibroDAO().editarLibro(libro);
    }

    /**
     * Elimina un libro del catálogo de la biblioteca.
     *
     * @param id_libro
     */
    @GetMapping("/librosEliminar")
    public void EliminarLibro(@RequestParam int id_libro) throws ClassNotFoundException {
        new LibroDAO().eliminarLibro(id_libro);
    }
}
