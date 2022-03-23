package org.eborda.java.jdbc.repositorio;

import java.util.List;

//Esta clase repositorio se encargará de todas las consultas y operaciones a la base de datos
public interface Repositorio<T> {
    List<T> listar();
    //Método buscar por id
    T porId(Long id);
    //Método para guardar
    void guardar(T t);
    //Método para modificar
    void eliminar(Long id);
}
