/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import implementaciones.PersonaDAO;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Auto;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.TramitePlacas;

/**
 *
 * @author mario
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson_Proyecto2BDA");
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        
        Persona persona = new Persona(false, new GregorianCalendar(), "123456", "DASDM355123", "Mario", "Diaz", "Padilla");
        TramitePlacas tramite = new TramitePlacas(100, new GregorianCalendar(), persona);
        Auto auto = new Auto("Corolla", "Blanco", "ABC-123", "2003", "Toyota", true);
        Placa placa = new Placa(tramite, "ABC-123", auto);
        
        entityManager.persist(auto);
        entityManager.persist(persona);
        entityManager.persist(tramite);
        entityManager.persist(placa);
        
        entityManager.getTransaction().commit();
        
    }
    
}
