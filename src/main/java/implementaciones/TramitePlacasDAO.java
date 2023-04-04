/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import javax.persistence.EntityManager;
import interfaces.ITramitePlacasDAO;
import java.util.Calendar;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;

/**
 *
 * @author eruma
 */
public class TramitePlacasDAO implements ITramitePlacasDAO {

    private final EntityManager entityManager;

    public TramitePlacasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void nuevoTramite(Placa placa) {
        entityManager.getTransaction().begin();
        if(placa.getTramitePlacas().getCosto()==1500){
            entityManager.persist(placa.getAutomovil());
        }
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
    }
}
