package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Puerto;
import java.util.List;

/**
 *
 * @author Marcos Miranda
 */
public interface PuertoDAO {
    
    // Crear un nuevo propietario
    void crear(Puerto puerto);

    // Leer un propietario por dni
    Puerto obtenerPorCiudad(String ciudad);

    // Leer todos los propietarios
    List<Puerto> obtenerTodos();

    // Actualizar un propietario
    void actualizar(Puerto puerto);

    // Eliminar un propietario
    void eliminar(Puerto puerto);
}
    

