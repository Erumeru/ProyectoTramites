/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta entidad representa trámites de licencias con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name="TramiteLicencia")
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
public class TramiteLicencia extends Tramite implements Serializable {

    /**
     * Este atributo representa la licencia relacionada con este trámite.
     */
    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="licenciaId",referencedColumnName="id")
    private Licencia licencia;

    /**
     * Este método es un constructor por defecto.
     */
    public TramiteLicencia() {
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param licencia Representa la licencia relacionada con este trámite.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     * @param persona Representa la persona que realizó el trámite. 
     */
    public TramiteLicencia(Licencia licencia, int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.licencia = licencia;
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param licencia Representa la licencia relacionada con este trámite.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     */
    public TramiteLicencia(Licencia licencia, int costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.licencia = licencia;
    }
    
    /**
     * Este método regresa la licencia relacionada con este trámite.
     * @return Regresa la licencia relacionada con este trámite.
     */
    public Licencia getLicencia() {
        return licencia;
    }

    /**
     * Este método asigna el valor del atributo licencia al valor recibido en el parámetro.
     * @param licencia Representa el valor a asignar.
     */
    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    /**
     * Este método regresa una cadena con los atributos del trámite.
     * @return Regresa una cadena con los atributos del trámite.
     */
    @Override
    public String toString() {
        return "TramiteLicencia{" + "licencia=" + licencia + '}';
    }
    
    
    
}
