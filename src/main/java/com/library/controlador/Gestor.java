package com.library.controlador;

import com.library.modelo.AdminDAO;
import com.library.modelo.LectorDAO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Controlador REST responsable de la gestión de usuarios en la biblioteca.</p>
 * <ul>
 * <li><b>Login</b>: autentica usuarios como administrador o lector.</li>
 * <li><b>Register</b>: registra nuevos administradores o lectores.</li>
 * <li><b>List Lectores</b>: devuelve la lista de lectores registrados.</li>
 * </ul>
 *
 * <p>
 * Uso general:</p>
 * <pre>
 *   POST /api/login    -> Autenticación de usuarios
 *   POST /api/register -> Registro de nuevos usuarios
 *   GET  /api/p        -> Listado de lectores
 * </pre>
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
public class Gestor {

    /**
     * Data Access Object para operaciones de administrador
     */
    @Autowired

    /**
     * Autentica un usuario en el sistema según su rol.
     *
     * @param credentials Map con parámetros:
     * <ul>
     * <li>{@code username} (String): identificador de usuario.</li>
     * <li>{@code password} (String): contraseña en texto claro.</li>
     * <li>{@code role} (String): "admin" o "user".</li>
     * </ul>
     * @return Map<String, Object> con la clave {@code success} establecida a
     * {@code true} si la autenticación es exitosa, o {@code false} en caso
     * contrario.
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> credentials) throws ClassNotFoundException {
        String username = (String) credentials.get("username");
        String password = (String) credentials.get("password");
        String role = (String) credentials.get("role");
        Map<String, Object> response = new HashMap<>();
        if ("admin".equals(role)) {
            AdminDAO admin = new AdminDAO();
            if (admin.entrarAdmin(username, password)) {
                response.put("success", true);
            }
        } else if ("user".equals(role)) {
            LectorDAO lector = new LectorDAO();
            if (lector.entrarLector(username, password)) {
                response.put("success", true);
                response.put("user", (Object) lector.entrarLectorVO(username, password));
            }
        } else {
            response.put("success", false);
        }
        return response;
    }

    /**
     * Registra un nuevo usuario como administrador o lector.
     *
     * @param credentials Map con parámetros:
     * <ul>
     * <li>{@code name} (String): nombre de usuario deseado.</li>
     * <li>{@code password} (String): contraseña deseada.</li>
     * <li>{@code email} (String): correo electrónico del usuario.</li>
     * <li>{@code role} (String): "admin" o "user".</li>
     * </ul>
     * @return Map<String, Object> con las claves:
     * <ul>
     * <li>{@code success}: {@code true} si el registro fue exitoso.</li>
     * <li>{@code message}: descripción del resultado en caso de error o
     * confirmación.</li>
     * </ul>
     */
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, Object> credentials) throws ClassNotFoundException {
        Map<String, Object> response = new HashMap<>();
        String username = (String) credentials.get("name");
        String password = (String) credentials.get("password");
        String email = (String) credentials.get("email");
        String role = (String) credentials.get("role");
        if ("admin".equals(role)) {
            AdminDAO admin = new AdminDAO();
            if (admin.nameAdmin(username)) {
                response.put("success", false);
                response.put("message", "El nombre ya está registrado.");
                return response;
            }
            if (admin.ingresarAdmin("'" + username + "'," + "'" + password + "'," + "'" + email + "'")) {
                response.put("success", true);
            }
        } else if ("user".equals(role)) {
            LectorDAO lector = new LectorDAO();
            if (lector.nameLector(username)) {
                response.put("success", false);
                response.put("message", "El nombre ya está registrado.");
                return response;
            }
            if (lector.ingresarLector("'" + username + "'," + "'" + password + "'," + "'" + email + "'")) {
                response.put("success", true);
            }
        }
        response.put("success", true);
        response.put("message", "Usuario registrado exitosamente.");
        return response;
    }

    @GetMapping("/")
    public String salud() {
        return "API Biblioteca activa 🚀";
    }
    

}
