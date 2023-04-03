/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IAutoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.itson.dominio.Auto;

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
    public List<Auto> cargarTodosLosAutos() {
        String query = "SELECT a FROM Auto as a";
        TypedQuery<Auto> result = entityManager.createQuery(query, Auto.class);
        List<Auto> listAutos = result.getResultList();
        //entityManager.close();
        System.out.println("Todos los autos");
        return listAutos;
    }
}
