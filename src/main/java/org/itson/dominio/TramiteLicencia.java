/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author eruma
 */
@Entity
@Table(name="TramiteLicencia")
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
public class TramiteLicencia extends Tramite implements Serializable {

    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="licenciaId",referencedColumnName="id")
    private Licencia licencia;

    public TramiteLicencia() {
    }

    public TramiteLicencia(Licencia licencia, int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.licencia = licencia;
    }

    public TramiteLicencia(Licencia licencia, int costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.licencia = licencia;
    }
    
    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "TramiteLicencia{" + "licencia=" + licencia + '}';
    }
    
    
    
}
