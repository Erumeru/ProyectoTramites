/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta entidad representa trámites de placas con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name="TramitePlacas")
@PrimaryKeyJoinColumn(name = "id_tramite_placas")
public class TramitePlacas extends Tramite implements Serializable {

    /**
     * Este atributo representa las placas relacionadas con este trámite.
     */
    @OneToOne(mappedBy="tramitePlacas")
    private Placa placa;

    /**
     * Este método es un constructor por defecto.
     */
    public TramitePlacas() {
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     */
    public TramitePlacas(int costo, Calendar fechaExpedicion) {
        super(costo, fechaExpedicion);
        this.placa = placa;
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     * @param persona Representa la persona que realizó el trámite.
     */
    public TramitePlacas(int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.placa = placa;
    }
    
    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param placa Representa las placas relacionadas con este trámite.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     * @param persona Representa la persona que realizó el trámite.
     */
    public TramitePlacas(Placa placa, int costo, Calendar fechaExpedicion, Persona persona) {
        super(costo, fechaExpedicion, persona);
        this.placa = placa;
    }

    /**
     * Este método regresa una cadena con los atributos del trámite.
     * @return Regresa una cadena con los atributos del trámite.
     */
    @Override
    public String toString() {
        return "TramitePlacas{" + "placa=" + placa + '}';
    }
   
}
