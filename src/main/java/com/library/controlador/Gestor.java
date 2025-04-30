package com.library.controlador;

import com.library.modelo.AdminDAO;
import com.library.modelo.LectorDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Gestor {

    @Autowired
//el pepe
//Hola, esto es una prueba 
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> credentials) {
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
            }
        } else {
            response.put("success", false);
        }

        return response;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, Object> credentials) {    
        String username = (String) credentials.get("name");
        String password = (String) credentials.get("password");
        String email = (String) credentials.get("email");
        String role = (String) credentials.get("role");
        Map<String, Object> response = new HashMap<>();
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

    @GetMapping("/p")
    public ArrayList Login() {
        return new LectorDAO().MostrarLectores();
    }

}
