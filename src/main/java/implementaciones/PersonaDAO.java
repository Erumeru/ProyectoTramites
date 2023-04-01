/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IPersonaDAO;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
/**
 *
 * @author eruma
 */
public class PersonaDAO implements IPersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Persona> consultarPersonas(String rfc, String nombre, LocalDate fecha) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_Proyecto2BDA");
        EntityManager entityManager = emFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);
        //Cuando el nombre y rfc son dados
        if ((!nombre.equalsIgnoreCase("Ingrese su Nombre"))
                && (!rfc.equalsIgnoreCase("Ingrese su RFC")) && fecha==null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(criteriaBuilder.like(personaRoot.get("rfc"), rfc),
                    criteriaBuilder.like(personaRoot.get("nombres"), nombre)));
            System.out.println("RFC Y NOMBRE OBTENIDOS");
        }
        
        //Cuando solo el nombre es dado
        else if (rfc.equalsIgnoreCase("Ingrese su RFC") && fecha==null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.like(personaRoot.get("nombres"), nombre)));
            System.out.println("RFC INVALIDO");
        }
        
        //Cuando solo el RFC es dado
        else if (nombre.equalsIgnoreCase("Ingrese su Nombre") & fecha==null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.like(personaRoot.get("rfc"), rfc)));
            System.out.println("NOMBRE INVALIDO");
        }
        
        //Cuando solo la fecha es dada
        else if (nombre.equalsIgnoreCase("Ingrese su Nombre") && rfc.equalsIgnoreCase("Ingrese su RFC")) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fecha.toString())));
        }
        
        CriteriaQuery<Persona> select = criteriaQuery.select(personaRoot);
        TypedQuery<Persona> query = entityManager.createQuery(select);

        return query.getResultList();

//        
//        String query = "SELECT p FROM Persona as p";
//        TypedQuery<Persona> result=entityManager.createQuery(query, Persona.class);
//        List<Persona> listPersonas = result.getResultList();
//        entityManager.close();
//        return listPersonas;
    }

    public List<Persona> cargarTodasPersonas() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_Proyecto2BDA");
        EntityManager entityManager = emFactory.createEntityManager();

        String query = "SELECT p FROM Persona as p";
        TypedQuery<Persona> result = entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        entityManager.close();
        System.out.println("Todas las personas");
        return listPersonas;
    }
}
