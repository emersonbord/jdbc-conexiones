package org.eborda.java.jdbc;

import org.eborda.java.jdbc.modelo.Producto;
import org.eborda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eborda.java.jdbc.repositorio.Repositorio;
import org.eborda.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

//Debemos importar la clase ConexionBaseDatos dentro de la carpeta util
public class EjemploJdbcReutilizable {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            //Creamos la instancia del repositorio del tipo interface
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porId(2L));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
