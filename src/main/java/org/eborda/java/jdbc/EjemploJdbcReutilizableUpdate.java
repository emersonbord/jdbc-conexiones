package org.eborda.java.jdbc;

import org.eborda.java.jdbc.modelo.Categoria;
import org.eborda.java.jdbc.modelo.Producto;
import org.eborda.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.eborda.java.jdbc.repositorio.Repositorio;
import org.eborda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

//Debemos importar la clase ConexionBaseDatos dentro de la carpeta util
public class EjemploJdbcReutilizableUpdate {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {

            //Creamos la instancia del repositorio del tipo interface
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= Listar =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= Obtener por id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= Editar nuevo producto =============");
            Producto producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Corsair k95 mecánico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            //Guardamos el producto que creamos con los datos en la tabla usando repositorio
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con éxito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
