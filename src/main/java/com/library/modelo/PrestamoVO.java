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
    

    /**
     * id del prestamo
     */
    private final int idPrestamo;
    
    /** titulo del libro prestado */
    private final  String titulo;

    /** Fecha de retiro del libro  */
    private final  String fechaRetiro;

    /** Fecha de entrega del libro  */
    private final  String fechaEntrega;

    /**
     * Constructor de la clase PrestamoVO.
     *
     * @param idPrestamo id del prestamo
     * @param titulo titulo del libro prestado
     * @param fechaRetiro Fecha de retiro del libro
     * @param fechaEntrega Fecha de entrega del libro
     */
    public  PrestamoVO(int idPrestamo, String titulo, String fechaRetiro, String fechaEntrega) {    
        this.idPrestamo = idPrestamo;
        this.titulo = titulo;
        this.fechaRetiro = fechaRetiro;
        this.fechaEntrega = fechaEntrega;
    }
/**
     * Obtiene el id del prestamo.
     *
     * @return id del prestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }
/**
     * Obtiene el titulo del libro prestado.
     *
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la fecha de retiro del libro.
     *
     * @return Fecha de retiro
     */
    public String getFechaRetiro() {
        return fechaRetiro;
    }

    /**
     * Obtiene la fecha de entrega del libro.
     *
     * @return Fecha de entrega
     */
    public  String getFechaEntrega() {
        return fechaEntrega;
    }

}

