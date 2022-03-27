package org.eborda.java.jdbc;

import org.eborda.java.jdbc.modelo.Producto;
import org.eborda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eborda.java.jdbc.repositorio.Repositorio;
import org.eborda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

//Debemos importar la clase ConexionBaseDatos dentro de la carpeta util
public class EjemploJdbcReutilizableDelete {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            //Creamos la instancia del repositorio del tipo interface
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= Listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= Obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= Eliminar producto =============");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
