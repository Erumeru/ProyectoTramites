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
 * @author 233133_233259
 */
@Entity
@Table(name="TramitePlacas")
@PrimaryKeyJoinColumn(name = "id_tramite_placas")
public class TramitePlacas extends Tramite implements Serializable {

    @OneToOne(mappedBy="tramitePlacas")
    private Placa placa;

    public TramitePlacas() {
    }

    public TramitePlacas(int costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.placa = placa;
    }

    public TramitePlacas(int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.placa = placa;
    }
    
    public TramitePlacas(Placa placa, int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.placa = placa;
    }

    
    @Override
    public String toString() {
        return "TramitePlacas{" + "placa=" + placa + '}';
    }
   
}
