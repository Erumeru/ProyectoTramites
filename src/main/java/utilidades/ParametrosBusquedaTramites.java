/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author mario
 */
public class ParametrosBusquedaTramites {
    
    
    private LocalDate fechaInicio;
    
    private LocalDate fechaFin;
    
    private String nombrePersona;
    
    public ParametrosBusquedaTramites(LocalDate fechaInicio, LocalDate fechaFin, String nombrePersona) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePersona = nombrePersona;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
