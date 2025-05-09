package com.library.modelo;

import java.util.Date;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos reservados.
 * Licenciado para uso académico privado. Distribución no autorizada prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I  
 * Profesora: María Fernanda Díaz Hernández  
 * Grupo: 020-81
 *
 * Clase PrestamoVO  
 * Representa un préstamo de un libro realizado por un usuario, incluyendo las fechas de retiro y entrega.
 *
 * Autores:
 *   Juan David Mayorga López – ID 20232020116  
 *   Ángel Iván López Rodríguez – ID 20232020113  
 *   Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class PrestamoVO {

    /** ID del usuario que realiza el préstamo (estático) */
    private static int idUsuario;

    /** ID del libro prestado (estático) */
    private static int idLibro;

    /** Fecha de retiro del libro (estático) */
    private static Date fechaRetiro;

    /** Fecha de entrega del libro (estático) */
    private static Date fechaEntrega;

    /**
     * Constructor de la clase PrestamoVO.
     *
     * @param idUsuario ID del usuario
     * @param idLibro ID del libro
     * @param fechaRetiro Fecha de retiro del libro
     * @param fechaEntrega Fecha de entrega del libro
     */
    public PrestamoVO(int idUsuario, int idLibro, Date fechaRetiro, Date fechaEntrega) {
        PrestamoVO.idUsuario = idUsuario;
        PrestamoVO.idLibro = idLibro;
        PrestamoVO.fechaRetiro = fechaRetiro;
        PrestamoVO.fechaEntrega = fechaEntrega;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario
     */
    public static int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Obtiene el ID del libro.
     *
     * @return ID del libro
     */
    public static int getIdLibro() {
        return idLibro;
    }

    /**
     * Obtiene la fecha de retiro del libro.
     *
     * @return Fecha de retiro
     */
    public static Date getFechaRetiro() {
        return fechaRetiro;
    }

    /**
     * Obtiene la fecha de entrega del libro.
     *
     * @return Fecha de entrega
     */
    public static Date getFechaEntrega() {
        return fechaEntrega;
    }

}

