
package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Propietario;
import java.util.List;

/**
 *
 * @author Marcos Miranda
 */
public interface PropietarioDAO {
    
    
    // Crear un nuevo propietario
    void crear(Propietario propietario);

    // Leer un propietario por dni
    Propietario obtenerPorDni(String dni);

    // Leer todos los propietarios
    List<Propietario> obtenerTodos();

    // Actualizar un propietario
    void actualizar(Propietario propietario);

    // Eliminar un propietario
    void eliminar(Propietario propietario);
}


