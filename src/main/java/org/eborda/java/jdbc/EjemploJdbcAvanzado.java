package org.eborda.java.jdbc;

import java.sql.*;

public class EjemploJdbcAvanzado {
    public static void main(String[] args) {
        //CREAMOS LOS PARÁMETROS
        String url = "jdbc:mysql://localhost:3306/java_curso"; //En caso de error agregar la zona horaria del país en donde habitan ?serverTimezone=America/Santiago justo al final del nombre de la BD ej: java_curso?serverTimezone=America/Santiago
        String username = "root";
        String password = "123456";
        /** Forma optimizada con "autoclose" se cierra de forma automática, la máquina virtual lo maneja por detrás de escena, utilizando el try con recursos */
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

            while (resultado.next()) {
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getDate("fecha_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
