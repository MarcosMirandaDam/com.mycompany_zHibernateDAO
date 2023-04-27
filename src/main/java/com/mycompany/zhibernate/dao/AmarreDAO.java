package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Amarre;
import java.util.List;

/**
 *
 * @author Marcos Miranda
 */
public interface AmarreDAO {

    // Crear un nuevo amarre
    void crear(Amarre amarre);

    // Leer un amarre por ID
    Amarre obtenerPorId(Long id);

    // Leer todos los amarres
    List<Amarre> obtenerTodos();

    // Actualizar un amarre
    void actualizar(Amarre amarre);

    // Eliminar un amarre
    void eliminar(Amarre amarre);
}
