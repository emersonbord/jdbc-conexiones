package org.eborda.java.jdbc.repositorio;

import org.eborda.java.jdbc.modelo.Producto;
import org.eborda.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    //Método privado para obtener la conexión y se utilizará para todos los métodos, listar, porID, etc
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {
        //Iteramos el cursor el ResulSet con while, y por cada registro en la BD creamos un bojeto producto y la guardamos a la esta lista productos
            while (rs.next()){
                Producto p = new Producto();
                p.setId(rs.getLong("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFechaRegistro(rs.getDate("fecha_registro"));
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
