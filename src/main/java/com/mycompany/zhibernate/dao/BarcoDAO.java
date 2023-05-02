package com.mycompany.zhibernate.dao;

/**
 *
 * @author Marcos Miranda
 */
import com.mycompany.zhibernate.modelo.Amarre;
import com.mycompany.zhibernate.modelo.Barco;
import java.util.List;

public interface BarcoDAO {

    // Crear un nuevo barco
    void crear(Barco barco);

    // Leer un barco por ID
    Barco obtenerPorId(Long id);

    // Leer todos los barcos
    List<Barco> obtenerTodos();

    // Actualizar un barco
    void actualizar(Barco barco);

    // Eliminar un barco
    void eliminar(Barco barco);

    // Amarrar un barco a un amarre específico
    void amarrar(Barco barco, Amarre amarre);

    // Desamarrar un barco e un amarre específico
    void desamarrar(Barco barco, Amarre amarre);

    // Buscar barcos por nombre (ignorando mayúsculas y minúsculas)
    List<Barco> findByNombreContainingIgnoreCase(String nombre);

    // Buscar barcos por nombre y ordenar por eslora de forma descendente
    List<Barco> findByNombreOrderByEsloraDesc(String nombre);
}
