/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.ITramiteLicenciasDAO;
import javax.persistence.EntityManager;
import org.itson.dominio.TramiteLicencia;

/**
 *
 * @author mario
 */
public class TramiteLicenciasDAO implements ITramiteLicenciasDAO {

    private final EntityManager entityManager;

    public TramiteLicenciasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void nuevoTramite(TramiteLicencia tramite) {
        entityManager.getTransaction().begin();
        entityManager.persist(tramite);
        entityManager.getTransaction().commit();
    }

}
