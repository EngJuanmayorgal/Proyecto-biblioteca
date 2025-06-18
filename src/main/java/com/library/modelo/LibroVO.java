package com.library.modelo;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos
 * reservados. Licenciado para uso académico privado. Distribución no autorizada
 * prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I Profesora: María Fernanda
 * Díaz Hernández Grupo: 020-81
 *
 * Clase LibroVO Representa un libro dentro del sistema de biblioteca. Contiene
 * información sobre el título, autor, género y unidades disponibles.
 *
 * Autores: Juan David Mayorga López – ID 20232020116 Ángel Iván López Rodríguez
 * – ID 20232020113 Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class LibroVO {

    /**
     * Número de id del libro
     */
    private  int id_libro;
    /**
     * Título del libro (estático, compartido entre todas las instancias)
     */
    private  String titulo;

    /**
     * Autor del libro (estático, compartido entre todas las instancias)
     */
    private  String autor;
    /**
     * isbn del libro
     */
    private  String isbn;
    /**
     * Año de publicacion del libro
     */
    private  int año_publi;
    /**
     * Género literario del libro (estático, compartido entre todas las
     * instancias)
     */
    private  String genero;

    /**
     * Número de unidades disponibles del libro
     */
    private int unidDispo;

    /**
     * Constructor de la clase LibroVO.
     *
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param genero Género del libro
     * @param año_publi publicacion del libro
     * @param isbn Isbn del libro
     * @param unidDispo Unidades disponibles
     * @param id_libro Unidades disponibles
     */
    public LibroVO(int id_libro, String titulo, String autor, int año_publi, String isbn, String genero, int unidDispo) {
        this.id_libro = id_libro;
        this.isbn = isbn;
        this.año_publi = año_publi;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.unidDispo = unidDispo;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return Título del libro
     */
    public  String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return Autor del libro
     */
    public  String getAutor() {
        return autor;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return Género del libro
     */
    public  String getGenero() {
        return genero;
    }
    /**
     * Obtiene el isbn del libro.
     *
     * @return isbn del libro
     */
    public  String getIsbn() {
        return isbn;
    }

    /**
     * Obtiene el id del libro.
     *
     * @return id del libro
     */
    public  int getId_libro() {
        return id_libro;
    }

    /**
     * Obtiene el id del libro.
     *
     * @return id del libro
     */
    public  int getAño_publi() {
        return año_publi;
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
