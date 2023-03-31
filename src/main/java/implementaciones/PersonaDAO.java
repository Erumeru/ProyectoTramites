/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IPersonaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.itson.dominio.Persona;

/**
 *
 * @author eruma
 */
public class PersonaDAO implements IPersonaDAO {

    @Override
    public List<Persona> consultarPersonas() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_Proyecto2BDA");
        EntityManager entityManager = emFactory.createEntityManager();
       
        String query = "SELECT p.nombres FROM person as p";
        TypedQuery<Persona> result=entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        entityManager.close();
        return listPersonas;

    }

}
