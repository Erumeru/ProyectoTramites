/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import org.itson.dominio.Auto;

/**
 * Clase de transporte para transportar información de un auto y sus placas
 * @author 233133_233259
 */
public class AutomovilesPlacasDTO {
    
    /**
     * Placas del auto
     */
    private String placas;
    
    /**
     * Objeto Auto que contiene la información del auto
     */
    private Auto automovil;

    /**
     * Constructor por defecto
     */
    public AutomovilesPlacasDTO() {
    }

    /**
     * Constructor que inicializa los parámetros con sus atributos
     * @param placas Placas del auto
     * @param automovil Auto
     */
    public AutomovilesPlacasDTO(String placas, Auto automovil) {
        this.placas = placas;
        this.automovil = automovil;
    }

    /**
     * Método que regresa las placas del auto
     * @return String con las placas del auto
     */
    public String getPlacas() {
        return placas;
    }

    /**
     * Setter de las placas del auto
     * @param placas Placas a settear
     */
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    /**
     * Método que regresa el auto
     * @return Objeto Auto que representa al auto
     */
    public Auto getAutomovil() {
        return automovil;
    }

    /**
     * Setter para el auto
     * @param automovil Auto a settear
     */
    public void setAutomovil(Auto automovil) {
        this.automovil = automovil;
    }
    
}
