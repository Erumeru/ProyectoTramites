/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Clase que representa los parámetros de búsqueda de trámites
 * @author 233133_233259
 */
public class ParametrosBusquedaTramites {
    
    /**
     * Fecha de inicio de un trámite
     */
    private LocalDate fechaInicio;
    /**
     * Fecha de fin de un trámite
     */
    private LocalDate fechaFin;
    /**
     * nombre de la persona del trámite
     */
    private String nombrePersona;
    
    /**
     * Constructor que inicializa los atributos con los parámetros
     * @param fechaInicio Fecha de inicio de un trámite
     * @param fechaFin Fecha de fin de un trámite
     * @param nombrePersona  nombre de la persona del trámite
     */
    public ParametrosBusquedaTramites(LocalDate fechaInicio, LocalDate fechaFin, String nombrePersona) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePersona = nombrePersona;
    }

    /**
     * Getter de la fecha inicio del trámite
     * @return LocalDate con la fecha de inicio del trámite
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Setter de la fecha inicio 
     * @param fechaInicio Nueva fecha a iniciar el trámite
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Getter de la fecha fin del trámite
     * @return LocalDate de la fechaFin del trámite
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Setter de la fecha fin del trámite
     * @param fechaFin nueva fecha fin del trámite
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Nombre de la persona a la que le concierne el trámite
     * @return String con el nombre de la persona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * Setter de el nombre de la persona del trámite
     * @param nombrePersona Nuevo nombre de persona para el trámite
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
