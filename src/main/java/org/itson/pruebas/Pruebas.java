/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Persona;

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
        
        Persona persona = new Persona(false, new GregorianCalendar(), "6444123456", "DSDAER35462DSA", "Pepe", "Lopez", "Cota");
        
        entityManager.persist(persona);
        
    }
    
}
