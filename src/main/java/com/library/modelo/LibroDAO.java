package com.library.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jeide
 */
public class LibroDAO {

    /**
     * Conexión con la base de datos
     */
    private java.sql.Connection con;

    /**
     * Objeto Statement para ejecutar sentencias SQL
     */
    private Statement st;

    /**
     * Objeto ResultSet para almacenar resultados de consultas
     */
    private ResultSet rs;

    /**
     * Constructor de la clase que inicializa los campos como nulos
     */
    public LibroDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public ArrayList<LibroVO> MostrarLibros(int id_lector) {
        ArrayList<LibroVO> libros = new ArrayList<>();
        String consulta = "SELECT * FROM libro ORDER BY id_libro";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                if (rs.getInt("cantidad_disponible") != 0 && comprobarLibroYaPrestado(rs.getString("titulo"), id_lector)) {
                    LibroVO libro = new LibroVO(rs.getInt("id_libro"),
                            rs.getString("titulo"), rs.getString("editorial"), rs.getString("autor"),
                            rs.getString("isbn"), rs.getInt("anio_publicacion"),
                            rs.getString("genero"), rs.getInt("cantidad_disponible"));
                    libros.add(libro);
                }
            }
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
        return libros;
    }

    public ArrayList<LibroVO> MostrarLibros() {
        ArrayList<LibroVO> libros = new ArrayList<>();
        String consulta = "SELECT * FROM libro ORDER BY id_libro;";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                LibroVO libro = new LibroVO(rs.getInt("id_libro"),
                        rs.getString("titulo"), rs.getString("editorial"), rs.getString("autor"),
                        rs.getString("isbn"), rs.getInt("anio_publicacion"),
                        rs.getString("genero"), rs.getInt("cantidad_disponible"));
                libros.add(libro);
            }
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
        return libros;
    }

    public boolean comprobarLibroYaPrestado(String titulo, int id_lector) {
        ArrayList<PrestamoVO> prestamos = new PrestamoDAO().MostrarPrestamosLector(id_lector);
        for (PrestamoVO prestamo : prestamos) {
            if (prestamo.getTitulo().equals(titulo)) {
                return false;
            }
        }
        return true;
    }

    public boolean cambiarUniDispo(String opcion, int id_libro) {

        String consulta = "UPDATE libro SET cantidad_disponible = "
                + " cantidad_disponible" + opcion + "1 WHERE (id_libro = " + id_libro + ")";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(consulta);
            Connectiondb.disconnected();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void eliminarLibro(int id_libro) {
        String consulta = "DELETE FROM libro WHERE (id_libro = " + id_libro + ");";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(consulta);
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
    }

    public void agregarLibro(String lector) {
        String consulta = "INSERT INTO libro (titulo, autor, editorial, isbn, "
                + "genero, anio_publicacion, cantidad_disponible) VALUES (" + lector + ");";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(consulta);
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
    }

    public void editarLibro(LibroVO libro) {
        String consulta = "UPDATE libro SET titulo = ?, autor = ?, editorial = ?, isbn = ?, genero = ?, anio_publicacion = ?, cantidad_disponible = ? WHERE id_libro = ?";
        try {
            con = Connectiondb.connection();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEditorial());
            ps.setString(4, libro.getIsbn());
            ps.setString(5, libro.getGenero());
            ps.setInt(6, libro.getAño_publi());
            ps.setInt(7, libro.getUnidDispo());
            ps.setInt(8, libro.getId_libro());

            ps.executeUpdate();
            Connectiondb.disconnected();
        } catch (SQLException ex) {
            System.out.println("Error al editar libro: " + ex.getMessage());
        }
    }

}
