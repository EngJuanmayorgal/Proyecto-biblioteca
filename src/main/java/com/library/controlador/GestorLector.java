package com.library.controlador;

import com.library.modelo.LectorDAO;
import com.library.modelo.PrestamoDAO;
import com.library.modelo.PrestamoVO;
import java.util.ArrayList;
import java.util.HashMap;
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

    @PostMapping("/prestamo")
    public Map<String, Object> pedirPrestamo(@RequestBody Map<String, Object> credentials) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> libro = (Map<String, Object>) credentials.get("libro");
        int uniDispo = Integer.parseInt(libro.get("uniDispo").toString());
        int idLibro = Integer.parseInt(libro.get("id_libro").toString());
        String fPrestamo = (String) libro.get("fecha_prestamo");
        String fDevolucion = (String) libro.get("fecha_devolucion");
        Map<String, Object> lector = (Map<String, Object>) libro.get("lector");
        int idLector = Integer.parseInt(lector.get("id_lector").toString());
        PrestamoDAO prestamo = new PrestamoDAO();
        if (prestamo.ingresarPrestamo(fPrestamo, fDevolucion, idLibro, idLector, uniDispo)) {
            response.put("ok", true);
        } else {
            response.put("ok", false);
        }
        return response;
    }

    @GetMapping("/prestamos/id_lector")
    public ArrayList verPrestamos(@RequestParam int id_lector) {
        return new PrestamoDAO().MostrarPrestamosLector(id_lector);

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
