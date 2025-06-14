package com.library.modelo;

import java.sql.*;
import java.util.ArrayList;

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
public class LectorDAO {

    /** Conexión con la base de datos */
    private java.sql.Connection con;

    /** Objeto Statement para ejecutar sentencias SQL */
    private Statement st;

    /** Objeto ResultSet para almacenar resultados de consultas */
    private ResultSet rs;

    /** Constructor de la clase que inicializa los campos como nulos */
    public LectorDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Registra un nuevo lector en la base de datos.
     *
     * @param jugador Cadena con los valores a insertar (nombre, contraseña y email)
     * @return true si la operación fue exitosa, false en caso contrario
     */
    public boolean ingresarLector(String jugador) {
        try {
            String ingresar = "INSERT INTO lector(name,pass,email) "
                    + "VALUE(" + jugador + ")";
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(ingresar);
            st.close();
            Connectiondb.disconnected();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Verifica si un lector puede iniciar sesión con las credenciales proporcionadas.
     *
     * @param user Nombre de usuario
     * @param pass Contraseña del usuario
     * @return true si el lector existe, false en caso contrario
     */
    public boolean entrarLector(String user, String pass) {
        String consulta = "SELECT id_lector FROM lector WHERE name = '" + user + "' AND pass = " + pass;
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                st.close();
                Connectiondb.disconnected();
                return true;
            } else {
                st.close();
                Connectiondb.disconnected();
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Verifica si un lector con el nombre dado ya está registrado en la base de datos.
     *
     * @param user Nombre de usuario
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean nameLector(String user) {
        String consulta = "SELECT id_lector FROM lector WHERE name = '" + user + "'";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                st.close();
                Connectiondb.disconnected();
                return true;
            } else {
                st.close();
                Connectiondb.disconnected();
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Recupera todos los lectores registrados en la base de datos.
     *
     * @return Lista de objetos LectorVO con la información de cada lector
     */
    
    public ArrayList<LectorVO> MostrarLectores() {
        ArrayList<LectorVO> lectores = new ArrayList<>();
        String consulta = "SELECT * FROM lector ORDER BY id_lector";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                LectorVO lector = new LectorVO(rs.getInt("id_lector"), rs.getString("name"), rs.getString("email"));
                lectores.add(lector);
            }
            Connectiondb.disconnected();
        } catch (SQLException ex) {
        }
        return lectores;
    }
}
