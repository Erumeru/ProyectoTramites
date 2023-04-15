/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Esta entidad representa placas con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name = "placas")
public class Placa implements Serializable {

    /**
     * Este atributo representa la llave primaria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Este atributo representa el trámite al que pertenece esta placa.
     */
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idTramitePlacas", nullable = false)
    private TramitePlacas tramitePlacas;

    /**
     * Este atributo representa la fecha en la que dejan de ser válidas las placas.
     */
    @Column(name = "fechaRecepcion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaRecepcion;

    /**
     * Este atributo representa la serie de placas correspondientes.
     */
    @Column(name = "seriePlacas", nullable = false, length = 7)
    private String seriePlacas;

    /**
     * Este atributo representa el auto al que pertenecen estas placas.
     */
    @ManyToOne
    @JoinColumn(name = "idAuto", nullable = false)
    private Auto automovil;

    /**
     * Este método es un constructor por defecto.
     */
    public Placa() {
    }

    /**
     * Este constructor crea las placas e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param tramitePlacas Representa el trámite al que pertenece esta placa.
     * @param seriePlacas Representa la serie de placas correspondientes.
     * @param automovil Representa el auto al que pertenecen estas placas.
     */
    public Placa(TramitePlacas tramitePlacas, String seriePlacas, Auto automovil) {
        this.tramitePlacas = tramitePlacas;
        this.seriePlacas = seriePlacas;
        this.automovil = automovil;
    }

    /**
     * Este constructor crea las placas e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria.
     * @param tramitePlacas Representa el trámite al que pertenece esta placa.
     * @param seriePlacas Representa la serie de placas correspondientes.
     * @param automovil Representa el auto al que pertenecen estas placas.
     */
    public Placa(Long id, TramitePlacas tramitePlacas, String seriePlacas, Auto automovil) {
        this.id = id;
        this.tramitePlacas = tramitePlacas;
        this.seriePlacas = seriePlacas;
        this.automovil = automovil;
    }

    /**
     * Este método regresa la llave primaria de las placas.
     * @return Regresa la llave primaria de las placas.
     */
    public Long getId() {
        return id;
    }

    /**
     * Este método asigna el valor del atributo id al valor recibido en el parámetro.
     * @param id Representa el valor a asignar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Este método regresa el trámite al que pertenece esta placa.
     * @return Regresa el trámite al que pertenece esta placa.
     */
    public TramitePlacas getTramitePlacas() {
        return tramitePlacas;
    }

    /**
     * Este método asigna el valor del atributo tramitePlacas al valor recibido en el parámetro.
     * @param tramitePlacas Representa el valor a asignar.
     */
    public void setTramitePlacas(TramitePlacas tramitePlacas) {
        this.tramitePlacas = tramitePlacas;
    }

    /**
     * Este constructor crea las placas e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param tramitePlacas Representa el trámite al que pertenece esta placa.
     * @param fechaRecepcion Representa la fecha en la que dejan de ser válidas las placas.
     * @param seriePlacas Representa la serie de placas correspondientes.
     * @param automovil Representa el auto al que pertenecen estas placas.
     */
    public Placa(TramitePlacas tramitePlacas, Calendar fechaRecepcion, String seriePlacas, Auto automovil) {
        this.tramitePlacas = tramitePlacas;
        this.fechaRecepcion = fechaRecepcion;
        this.seriePlacas = seriePlacas;
        this.automovil = automovil;
    }

    /**
     * Este método regresa la fecha en la que dejan de ser válidas las placas.
     * @return Regresa la fecha en la que dejan de ser válidas las placas.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Este método asigna el valor del atributo fechaRecepcion al valor recibido en el parámetro.
     * @param fechaRecepcion Representa el valor a asignar.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Este método regresa la serie de placas correspondientes.
     * @return Regresa la serie de placas correspondientes.
     */
    public String getSeriePlacas() {
        return seriePlacas;
    }

    /**
     * Este método asigna el valor del atributo seriePlacas al valor recibido en el parámetro.
     * @param seriePlacas Representa el valor a asignar.
     */
    public void setSeriePlacas(String seriePlacas) {
        this.seriePlacas = seriePlacas;
    }

    /**
     * Este método regresa el auto al que pertenecen estas placas.
     * @return Regresa el auto al que pertenecen estas placas.
     */
    public Auto getAutomovil() {
        return automovil;
    }

    /**
     * Este método asigna el valor del atributo automovil al valor recibido en el parámetro.
     * @param automovil Representa el valor a asignar.
     */
    public void setAutomovil(Auto automovil) {
        this.automovil = automovil;
    }

    /**
     * Este método regresa el hash correspondiente a la entidad a partir del id.
     * @return Regresa el hash correspondiente a la entidad a partir del id.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Este método equals compara dos objetos Placa a partir de su id.
     * @param object Representa el objeto Placa a comparar.
     * @return Regresa true en caso de que sean iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una cadena con los atributos de la placa.
     * @return Regresa una cadena con los atributos de la placa.
     */
    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", seriePlacas=" + seriePlacas + '}';
    }

}
