/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IPlacasDAO;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.dominio.Placa;

/**
 * Esta clase representa la DAO para placas.
 * @author 233133_233259
 */
public class PlacasDAO implements IPlacasDAO{
    
    /**
     * Este atributo representa un objeto de tipo EntityManager.
     */
    private final EntityManager entityManager;

    /**
     * Este constructor inicializa el valor del atributo entityManager
     * utilizando el valor recibido en el parámetro.
     * @param entityManager Representa el objeto entityManager que
     * será utilizado en la clase.
     */
    public PlacasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Este método realiza la validación de la existencia de unas placas a partir
     * de su serie de placas.
     * @param seriePlacas Representan las placas a utilizar para validación.
     * @return Regresa true en caso de que existan, false en caso contrario.
     */
    @Override
    public boolean validarExistenciaPlaca(String seriePlacas){
        String jpql = "SELECT p FROM Placa p WHERE p.seriePlacas = :serie";

        TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
        query.setParameter("serie", seriePlacas);
        query.setMaxResults(1);

        List<Placa> placas = query.getResultList();
        return !placas.isEmpty();
    }
    
    /**
     * Este método regresa una placa a partir de su serie de placas.
     * @param seriePlacas Representan las placas a utilizar para validación.
     * @return Regresa un objeto Placa en caso de que se encuentre, null
     * en caso contrario.
     */
    @Override
    public Placa obtenerPlaca(String seriePlacas){
        String jpql = "SELECT p FROM Placa p WHERE p.seriePlacas = :serie";

        TypedQuery<Placa> query = entityManager.createQuery(jpql, Placa.class);
        query.setParameter("serie", seriePlacas);
        query.setMaxResults(1);
        
        List<Placa> lista = query.getResultList();
        
        return lista.isEmpty() ? null : lista.get(0);
    }
    
    /**
     * Este método realiza la cancelación de unas placas estableciendo
     * su fecha de recepción a la fecha del sistema.
     * @param placa Representan las placas a ser canceladas.
     */
    @Override
    public void cancelarPlacasAuto(Placa placa){
        entityManager.getTransaction().begin();
        
        placa.setFechaRecepcion(new GregorianCalendar());
        entityManager.persist(placa);
        
        entityManager.getTransaction().commit();
    }
}
