package com.library.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. All rights reserved.
 * Licensed for private academic use only. Unauthorized distribution prohibited.
 *
 * Asignatura: Programación Avanzada
 * Semestre: 2025–I
 * Profesora: María Fernanda Díaz Hernández
 * Grupo: 020-81
 *
 * <p>Data Access Object (DAO) para las operaciones relacionadas con el
 * administrador dentro del sistema de biblioteca.</p>
 *
 * Funcionalidades:
 * <ul>
 *   <li>Verificar existencia de usuario administrador.</li>
 *   <li>Registrar nuevo administrador.</li>
 *   <li>Gestionar autenticación de administrador.</li>
 * </ul>
 *
 * Autores:
 * <ul>
 *   <li>Juan David Mayorga López – ID 20232020116 – Desarrollador Backend</li>
 *   <li>Ángel Iván López Rodríguez – ID 20232020113 – Analista de Requisitos</li>
 *   <li>Edgar Andrés Ángel Pulido – ID 20232020133 – QA & Documentación</li>
 * </ul>
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class AdminDAO {

    /**
     * Conexión JDBC con la base de datos.
     */
    private java.sql.Connection con;

    /**
     * Objeto Statement para ejecución de consultas SQL.
     */
    private Statement st;

    /**
     * Objeto ResultSet para almacenar resultados de consultas.
     */
    private ResultSet rs;

    /**
     * Constructor por defecto. Inicializa variables de conexión a null.
     */
    public AdminDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Inserta un nuevo administrador en la base de datos.
     *
     * @param admin Cadena con los valores a insertar (username, password, email) en formato SQL.
     * @return {@code true} si la inserción fue exitosa; {@code false} en caso de error.
     */
    public boolean ingresarAdmin(String admin) {
        try {
            String query = "INSERT INTO admin(user,pass,email) VALUES(" + admin + ")";
            con = Connectiondb.connection();
            st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            Connectiondb.disconnected();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Verifica las credenciales de un administrador existente.
     *
     * @param user Nombre de usuario del administrador.
     * @param pass Contraseña asociada al administrador.
     * @return {@code true} si las credenciales son válidas; {@code false} en caso contrario.
     */
    public boolean entrarAdmin(String user, String pass) {
        String query = "SELECT id_admin FROM admin WHERE user = '" + user + "' AND pass = '" + pass + "'";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            boolean exists = rs.next();
            st.close();
            Connectiondb.disconnected();
            return exists;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * Comprueba si un nombre de usuario de administrador ya existe.
     *
     * @param user Nombre de usuario a verificar.
     * @return {@code true} si el usuario existe; {@code false} si está disponible.
     */
    public boolean nameAdmin(String user) {
        String query = "SELECT id_admin FROM admin WHERE user = '" + user + "'";
        try {
            con = Connectiondb.connection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            boolean exists = rs.next();
            st.close();
            Connectiondb.disconnected();
            return exists;
        } catch (SQLException ex) {
            return false;
        }
    }

}
