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
 *
 * @author mario
 */
public class ConexionBD implements IConexionBD{
    
    private final String PERSISTENCE_UNIT_NAME;

    public ConexionBD(String PERSISTENCE_UNIT_NAME) {
        this.PERSISTENCE_UNIT_NAME = PERSISTENCE_UNIT_NAME;
    }
    
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
