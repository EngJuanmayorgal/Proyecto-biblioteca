package com.library.modelo;
/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos reservados.
 * Licenciado para uso académico privado. Distribución no autorizada prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I  
 * Profesora: María Fernanda Díaz Hernández  
 * Grupo: 020-81
 *
 * Clase LectorDAO
 * Encapsula la lógica de acceso a datos para la entidad "Lector".
 * Proporciona operaciones CRUD básicas sobre la tabla "lector" de la base de datos.
 *
 * Autores:
 *   Juan David Mayorga López – ID 20232020116  
 *   Ángel Iván López Rodríguez – ID 20232020113  
 *   Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class LectorVO {

    private int id_lector;
    private String name;
    private String email;

    public LectorVO(int id_lector, String name, String email) {
        this.id_lector = id_lector;
        this.name = name;
        this.email = email;
    }

    public int getId_lector() {
        return id_lector;
    }

    public void setId_lector(int id_lector) {
        this.id_lector = id_lector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
