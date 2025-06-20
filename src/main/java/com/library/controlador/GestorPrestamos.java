package com.library.controlador;

import com.library.modelo.PrestamoDAO;
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

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GestorPrestamos {

    @PostMapping("/prestamo")
    public Map<String, Object> pedirPrestamo(@RequestBody Map<String, Object> credentials) throws ClassNotFoundException {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> libro = (Map<String, Object>) credentials.get("libro");
        int idLibro = Integer.parseInt(libro.get("id_libro").toString());
        String fPrestamo = (String) libro.get("fecha_prestamo");
        String fDevolucion = (String) libro.get("fecha_devolucion");
        Map<String, Object> lector = (Map<String, Object>) libro.get("lector");
        int idLector = Integer.parseInt(lector.get("id_lector").toString());
        PrestamoDAO prestamo = new PrestamoDAO();
        if (prestamo.ingresarPrestamo(fPrestamo, fDevolucion, idLibro, idLector)) {
            response.put("ok", true);
        } else {
            response.put("ok", false);
        }
        return response;
    }

    @GetMapping("/prestamos/id_lector")
    public ArrayList verPrestamos(@RequestParam int id_lector) throws ClassNotFoundException {
        return new PrestamoDAO().MostrarPrestamosLector(id_lector);
    }
    @GetMapping("/prestamos")
    public ArrayList verPrestamos() throws ClassNotFoundException {
        return new PrestamoDAO().MostrarPrestamos();
    }

    @GetMapping("/devolver")
    public Map<String, String> debolverPrestamo(@RequestParam int id_prestamo, @RequestParam int idLibro) throws ClassNotFoundException {
        new PrestamoDAO().DevolverPrestamo(id_prestamo, idLibro);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Libro devuelto correctamente.");
        return response;
    }

}
