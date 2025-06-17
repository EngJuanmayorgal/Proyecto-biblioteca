package com.library.controlador;

import com.library.modelo.LectorDAO;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
 * Clase GestorLector encargada de las operaciones CRUD relacionadas con la
 * gestión de usuarios lectores dentro del sistema de biblioteca.</p>
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
public class GestorLector {

    /**
     * Registra un nuevo usuario lector en el sistema.
     * <p>
     * Se encarga de validar la información proporcionada y de persistir el
     * nuevo registro en la base de datos.
     * </p>
     */
    public void RegistrarUsuario() {

    }

    /**
     * Edita la información de un usuario lector existente.
     * <p>
     * Permite modificar datos como nombre, correo o contraseña.
     * </p>
     */
    public void EditarUsuario() {

    }

    /**
     * Consulta los datos de un usuario lector específico.
     * <p>
     * Retorna la información detallada del usuario identificado.
     * </p>
     */
    public void ConsultarUsuario() {

    }

    /**
     * Obtiene la lista de todos los usuarios lectores registrados.
     * <p>
     * Permite paginar o filtrar resultados según criterios.
     * </p>
     */
    public void ConsultarUsuarios() {

    }

    /**
     * Elimina un usuario lector del sistema.
     * <p>
     * Realiza validaciones de permisos y elimina el registro especificado.
     * </p>
     */
    public void EliminarUsuario() {

    }
/**
     * Muestra todos los lectores registrados en el sistema.
     *
     * @return ArrayList con todos los lectores registrados.
     */
    @GetMapping("/p")
    public ArrayList Login() {
        return new LectorDAO().MostrarLectores();
    }
}
