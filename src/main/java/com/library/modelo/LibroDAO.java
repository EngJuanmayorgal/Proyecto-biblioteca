package com.library.modelo;

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
                            rs.getString("titulo"), rs.getString("autor"),
                            rs.getInt("anio_publicacion"), rs.getString("isbn"),
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
                System.out.println(rs.getInt("anio_publicacion"));
                LibroVO libro = new LibroVO(rs.getInt("id_libro"),
                        rs.getString("titulo"), rs.getString("autor"),
                        rs.getInt("anio_publicacion"), rs.getString("isbn"),
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
}
