/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import org.itson.dominio.Auto;

/**
 *
 * @author mario
 */
public class AutomovilesPlacasDTO {
    
    private String placas;
    
    private Auto automovil;

    public AutomovilesPlacasDTO() {
    }

    public AutomovilesPlacasDTO(String placas, Auto automovil) {
        this.placas = placas;
        this.automovil = automovil;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public Auto getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Auto automovil) {
        this.automovil = automovil;
    }
    
}
