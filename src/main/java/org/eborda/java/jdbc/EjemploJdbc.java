package org.eborda.java.jdbc;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        //CREAMOS LOS PARÁMETROS
        String url = "jdbc:mysql://localhost:3306/java_curso"; //En caso de error agregar la zona horaria del país en donde habitan ?serverTimezone=America/Santiago justo al final del nombre de la BD ej: java_curso?serverTimezone=America/Santiago
        String username = "root";
        String password = "123456";
        try {
            //Primero creamos el objeto de conexión para MySQL.
            //DriverManager se encarga de administrar las conexiones y drivers disponible
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            //Devuelve un cursor y se maneja bajo un ResulSet
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");
            //Iteramos el cursos utilizando un while
            while (resultado.next()){
                System.out.println(resultado.getString("nombre"));
            }
            //cerramos los recursos, primero el resultado
            resultado.close();
            //Cerramos la sentencia del objeto Statement
            stmt.close();
            //Cerramos la conexión
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
