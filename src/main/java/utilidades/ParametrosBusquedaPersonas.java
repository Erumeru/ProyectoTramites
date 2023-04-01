/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.time.LocalDate;

/**
 *
 * @author mario
 */
public class ParametrosBusquedaPersonas {
    
    private String rfc;
    private String nombre; 
    private LocalDate fecha;

    public ParametrosBusquedaPersonas(String rfc, String nombre, LocalDate fecha) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
