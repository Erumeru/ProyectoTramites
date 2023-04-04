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
 *
 * @author eruma
 */
public class AutoDAO implements IAutoDAO {

    private final EntityManager entityManager;

    public AutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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
