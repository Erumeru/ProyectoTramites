/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 * Esta interfaz representa una conexión a la base de datos. 
 * @author 233133_233259
 */
public interface IConexionBD {
    
    /**
     * Este método regresa un objeto de tipo EntityManager para poder realizar
     * operaciones con la base de datos a partir del PERSISTENCE_UNIT_NAME 
     * recibido en el constructor.
     * @return Regresa un objeto de tipo EntityManager.
     */
    EntityManager crearConexion();
}
