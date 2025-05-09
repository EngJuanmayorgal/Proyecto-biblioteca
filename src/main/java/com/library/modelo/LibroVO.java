
package com.library.modelo;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos reservados.
 * Licenciado para uso académico privado. Distribución no autorizada prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I  
 * Profesora: María Fernanda Díaz Hernández  
 * Grupo: 020-81
 *
 * Clase LibroVO  
 * Representa un libro dentro del sistema de biblioteca. Contiene información sobre el título, autor, género y unidades disponibles.
 *
 * Autores:
 *   Juan David Mayorga López – ID 20232020116  
 *   Ángel Iván López Rodríguez – ID 20232020113  
 *   Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class LibroVO {

    /** Título del libro (estático, compartido entre todas las instancias) */
    private static String titulo;

    /** Autor del libro (estático, compartido entre todas las instancias) */
    private static String autor;

    /** Género literario del libro (estático, compartido entre todas las instancias) */
    private static String genero;

    /** Número de unidades disponibles del libro */
    private int unidDispo;

    /**
     * Constructor de la clase LibroVO.
     *
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param genero Género del libro
     * @param unidDispo Unidades disponibles
     */
    public LibroVO(String titulo, String autor, String genero, int unidDispo) {
        LibroVO.titulo = titulo;
        LibroVO.autor = autor;
        LibroVO.genero = genero;
        this.unidDispo = unidDispo;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro
     */
    public static String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return Autor del libro
     */
    public static String getAutor() {
        return autor;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return Género del libro
     */
    public static String getGenero() {
        return genero;
    }

    /**
     * Obtiene la cantidad de unidades disponibles.
     *
     * @return Unidades disponibles
     */
    public int getUnidDispo() {
        return unidDispo;
    }

    /**
     * Establece la cantidad de unidades disponibles.
     *
     * @param unidDispo Nuevas unidades disponibles
     */
    public void setUnidDispo(int unidDispo) {
        this.unidDispo = unidDispo;
    }
}
