package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Regata;
import java.util.List;

public interface RegataDAO {

    // Crear una nueva regata
    void crear(Regata regata);

    // Leer una regata por ID
    Regata obtenerPorId(Long id);

    // Leer todas las regatas
    List<Regata> obtenerTodos();

    // Actualizar una regata
    void actualizar(Regata regata);

    // Eliminar una regata
    void eliminar(Regata regata);
}
