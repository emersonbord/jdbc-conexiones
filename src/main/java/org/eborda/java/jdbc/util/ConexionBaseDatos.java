package org.eborda.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static String url = "jdbc:mysql://localhost:3306/java_curso"; //En caso de error agregar la zona horaria del país en donde habitan ?serverTimezone=America/Santiago justo al final del nombre de la BD ej: java_curso?serverTimezone=America/Santiago
    private static String username = "root";
    private static String password = "123456";
    //Atributo de conexion singleton
    private static Connection connection;

    //Creamos método estático getConnection() para establecer la conexión
    public static Connection getInstance() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}
