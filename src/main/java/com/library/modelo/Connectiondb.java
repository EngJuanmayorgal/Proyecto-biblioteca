
package com.library.modelo;

import java.sql.*;
import java.util.logging.*;

/**
 * © 2025 Universidad Distrital Francisco José de Caldas. Todos los derechos reservados.
 * Licenciado para uso académico privado. Distribución no autorizada prohibida.
 *
 * Asignatura: Programación Avanzada – Semestre 2025–I
 * Profesora: María Fernanda Díaz Hernández
 * Grupo: 020-81
 *
 * Clase Connectiondb
 * Proporciona métodos para establecer y cerrar conexiones con la base de datos MySQL.
 * Se utiliza como clase auxiliar para las operaciones de persistencia en el proyecto.
 *
 * Autores:
 *   Juan David Mayorga López – ID 20232020116
 *   Ángel Iván López Rodríguez – ID 20232020113
 *   Edgar Andrés Ángel Pulido – ID 20232020133
 *
 * @version 1.0
 * @since 2025-04-30
 */
public class Connectiondb {

    /** Nombre de la base de datos utilizada */
    static String dbName = "biblioteca";

    /** URL base para la conexión JDBC */
    static String url = "jdbc:mysql://localhost:3306/";

    /** Nombre de usuario de la base de datos */
    static String user = "root";

    /** Contraseña de acceso a la base de datos */
    static String pass = "mysql";

    /** Objeto Connection activo */

 
    static Connection db;

    /**
     * Constructor de la clase.
     * Establece la conexión a la base de datos al ser instanciado.
     */
    public Connectiondb() {
        connection();
    }

    /**
     * Cierra la conexión con la base de datos asignando null al objeto Connection.
     */
    public static void disconnected() {
        db = null;
    }

    /**
     * Establece una conexión con la base de datos utilizando los parámetros definidos.
     * 
     * @return Objeto Connection activo si la conexión fue exitosa; de lo contrario, null.
     */
    public static Connection connection() {
        try {
            db = DriverManager.getConnection(url + dbName, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(java.sql.Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
}
