/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase representa una conexión a la base de datos. 
 * @author 233133_233259
 */
public class ConexionBD implements IConexionBD{
    
    /**
     * Este atributo representa una referencia a nuestro mapeo de entidades
     * para poder crear una conexión y crear un EntityManager.
     */
    private final String PERSISTENCE_UNIT_NAME;

    /**
     * Este constructor inicializa el valor del atributo PERSISTENCE_UNIT_NAME 
     * al valor recibido en el parámetro.
     * @param PERSISTENCE_UNIT_NAME Representa el valor que será asignado.
     */
    public ConexionBD(String PERSISTENCE_UNIT_NAME) {
        this.PERSISTENCE_UNIT_NAME = PERSISTENCE_UNIT_NAME;
    }
    
    /**
     * Este método regresa un objeto de tipo EntityManager para poder realizar
     * operaciones con la base de datos a partir del PERSISTENCE_UNIT_NAME 
     * recibido en el constructor.
     * @return Regresa un objeto de tipo EntityManager.
     */
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
