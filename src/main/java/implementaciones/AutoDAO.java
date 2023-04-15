/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IAutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.dominio.Auto;
import utilidades.AutomovilesPlacasDTO;

/**
 * Esta clase representa la DAO para automóviles.
 * @author 233133_233259
 */
public class AutoDAO implements IAutoDAO {

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
    public AutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Este método realiza una consulta jpql de todos los autos con su placa más reciente
     * en caso de tener alguna.
     * @return Regresa una lista de todos los autos con su placa más reciente.
     */
    @Override
    public List<AutomovilesPlacasDTO> cargarTodosLosAutos() {
        List<AutomovilesPlacasDTO> lista = new ArrayList<>();
        String jpql = "SELECT p.seriePlacas, a FROM TramitePlacas tp "
                + "INNER JOIN tp.placa p "
                + "INNER JOIN p.automovil a "
                + "WHERE p.fechaRecepcion IS NULL";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList) {
            lista.add(new AutomovilesPlacasDTO((String)objects[0], (Auto)objects[1]));
        }
        return lista;
    }
    
    /**
     * Este método regresa una lista de autos con su placa más reciente a partir
     * de una serie de placas.
     * @param placas Representa la serie de placas a ser utilizada para la búsqueda.
     * @return Regresa una lista de autos con su placa más reciente.
     */
    @Override
    public List<AutomovilesPlacasDTO> cargarAuto(String placas) {
        List<AutomovilesPlacasDTO> lista = new ArrayList<>();
        String jpql = "SELECT p.seriePlacas, a FROM TramitePlacas tp "
                + "INNER JOIN tp.placa p "
                + "INNER JOIN p.automovil a "
                + "WHERE p.fechaRecepcion IS NULL AND p.seriePlacas = :placa";
        
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("placa", placas);
        query.setMaxResults(1);
        
        List<Object[]> resultado = query.getResultList();
        
        for (Object[] object : resultado) {
            lista.add(new AutomovilesPlacasDTO((String)object[0], (Auto)object[1]));
        }
        
        return lista;
    }
    
    

}
