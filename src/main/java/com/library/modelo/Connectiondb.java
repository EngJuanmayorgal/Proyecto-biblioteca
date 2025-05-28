
package com.library.modelo;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author ADMIN
 */
public class Connectiondb {
    
    static String dbName = "biblioteca";
    static String url = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String pass = "mysql";
    static Connection db;
    

    public Connectiondb() {
        connection();
    }

    public static void disconnected(){
        db=null;
    }
    public static Connection connection() {
        try {
            db= DriverManager.getConnection(url+dbName,user,pass);
        } catch (SQLException ex) {
            Logger.getLogger(java.sql.Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }
}
