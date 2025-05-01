package com.library.modelo;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos reservados.
 * Licenciado para uso académico privado. Distribución no autorizada prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I  
 * Profesora: María Fernanda Díaz Hernández  
 * Grupo: 020-81
 *
 * Clase UsuarioVO  
 * Representa un usuario en el sistema, incluyendo su ID, nombre y correo electrónico.
 *
 * Autores:
 *   Juan David Mayorga López – ID 20232020116  
 *   Ángel Iván López Rodríguez – ID 20232020113  
 *   Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class UsuarioVO {

    /** ID único del usuario */
    private int id;

    /** Nombre del usuario */
    private String name;

    /** Correo electrónico del usuario */
    private String email;

    /**
     * Constructor de la clase UsuarioVO.
     *
     * @param id ID único del usuario
     * @param name Nombre del usuario
     * @param email Correo electrónico del usuario
     */
    public UsuarioVO(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param name Nombre del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email Correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}

