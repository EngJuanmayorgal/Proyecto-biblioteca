package com.library.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PrestamoDAO {

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
    public PrestamoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public boolean ingresarPrestamo(String fPrestamo, String fDevolucion,
            int idLibro, int idLector) throws ClassNotFoundException {
        try {
            String ingresar = "INSERT INTO prestamo(fecha_prestamo,fecha_devolucion,id_libro,id_lector) "
                    + "VALUE('" + fPrestamo + "','" + fDevolucion + "'," + idLibro + "," + idLector + ")";
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(ingresar);
            st.close();
            Connectiondb.disconnected();
            new LibroDAO().cambiarUniDispo("-", idLibro);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ArrayList MostrarPrestamos() throws ClassNotFoundException {
        ArrayList<PrestamoVO> Prestamos = new ArrayList<>();
        String consulta = """
                          select name,id_prestamo,fecha_prestamo,fecha_devolucion,titulo from lector
                          join prestamo
                          on prestamo.id_lector=lector.id_lector
                          join libro
                          on prestamo.id_libro=libro.id_libro 
                          ;""";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PrestamoVO prestamo = new PrestamoVO(rs.getInt("id_prestamo"),
                        rs.getString("name"), rs.getString("titulo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"));
                Prestamos.add(prestamo);
            }
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
        return Prestamos;

    }

    public ArrayList MostrarPrestamosLector(int id_lector) throws ClassNotFoundException {
        ArrayList<PrestamoVO> Prestamos = new ArrayList<>();
        String consulta = """
                          select id_prestamo,fecha_prestamo,fecha_devolucion,prestamo.id_libro,titulo from lector
                          join prestamo
                          on prestamo.id_lector=lector.id_lector
                          join libro
                          on prestamo.id_libro=libro.id_libro 
                          where (lector.id_lector="""
                + id_lector + ");";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PrestamoVO prestamo = new PrestamoVO(rs.getInt("id_prestamo"),
                        rs.getInt("id_libro"), rs.getString("titulo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"));
                Prestamos.add(prestamo);
            }
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
        return Prestamos;

    }

    public void DevolverPrestamo(int idPrestamo, int idLibro) throws ClassNotFoundException {
        try {
            String eliminar = "DELETE FROM prestamo WHERE (id_prestamo = " + idPrestamo + ")";
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(eliminar);
            st.close();
            Connectiondb.disconnected();
            new LibroDAO().cambiarUniDispo("+", idLibro);
        } catch (SQLException ex) {
        }
    }
}
