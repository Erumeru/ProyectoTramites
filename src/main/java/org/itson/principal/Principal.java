/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.principal;


import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import ui.SelectTramite;

/**
 * Esta es la clase principal que corre el programa.
 * @author 233133_233259
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexionBD conexion = new ConexionBD("org.itson_Proyecto2BDA");
        
        SelectTramite ventanaPrincipal = new SelectTramite(conexion);
        ventanaPrincipal.setVisible(true);
    }
    
}
