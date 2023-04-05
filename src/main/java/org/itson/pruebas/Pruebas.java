/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;


import criptografia.EncriptadorAESConverter;
import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.SelectTramite;

/**
 *
 * @author mario
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexionBD conexion = new ConexionBD("org.itson_Proyecto2BDA");
        
        /*
        EntityManager entityManager = conexion.crearConexion();
        entityManager.getTransaction().begin();
        
        
        
        Persona persona = entityManager.find(Persona.class, L);
        Licencia licencia = new Licencia(3);
        TramiteLicencia tramite = new TramiteLicencia(licencia, 1000, new GregorianCalendar(), persona);
        
        
        entityManager.persist(tramite);
        
        Persona pE = entityManager.find(Persona.class, 21L);
        TramitePlacas t = new TramitePlacas(1000, new GregorianCalendar(), pE);
        Auto a = entityManager.find(Auto.class, 1L);
        Placa p = new Placa(t, "ABC-123", a);
        
        
        entityManager.persist(a);
        entityManager.persist(p);
        
        entityManager.getTransaction().commit();
        
        */
        
        
        SelectTramite ventanaPrincipal = new SelectTramite(conexion);
        ventanaPrincipal.setVisible(true);
    }
    
}
