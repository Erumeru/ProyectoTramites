/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Esta entidad representa trámites con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Este atributo representa la llave primaria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    /**
     * Este atributo representa el costo del trámite.
     */
    @Column(name="costo", nullable=false)
    private int costo;
    
    /**
     * Este atributo representa la fecha en la que se realizó el trámite.
     */
    @Column(name="fechaExpedicion", nullable=false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    /**
     * Este atributo representa la persona que realizó el trámite.
     */
    @ManyToOne
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona persona;
    
    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     */
    public Tramite(Long id, int costo, Calendar fechaExpedicion) {
        this.id = id;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Este método es un constructor por defecto.
     */
    public Tramite() {
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     */
    public Tramite(int costo, Calendar fechaExpedicion) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Este constructor crea el trámite e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param costo Representa el costo del trámite.
     * @param fechaExpedicion Representa la fecha en la que se realizó el trámite.
     * @param persona Representa la persona que realizó el trámite.
     */
    public Tramite(int costo, Calendar fechaExpedicion, Persona persona) {
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.persona = persona;
    }
    
    /**
     * Este método regresa la llave primaria del trámite.
     * @return Regresa la llave primaria del trámite.
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
     * Este método regresa el costo del trámite.
     * @return Regresa el costo del trámite.
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Este método asigna el valor del atributo costo al valor recibido en el parámetro.
     * @param costo Representa el valor a asignar.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Este método regresa la fecha en la que se realizó el trámite.
     * @return Regresa la fecha en la que se realizó el trámite.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Este método asigna el valor del atributo fechaExpedicion al valor recibido en el parámetro.
     * @param fechaExpedicion Representa el valor a asignar.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Este método regresa la persona que realizó el trámite.
     * @return Regresa la persona que realizó el trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Este método asigna el valor del atributo persona al valor recibido en el parámetro.
     * @param persona Representa el valor a asignar.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
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
     * Este método equals compara dos objetos Tramite a partir de su id.
     * @param object Representa el objeto Tramite a comparar.
     * @return Regresa true en caso de que sean iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una cadena con los atributos del trámite.
     * @return Regresa una cadena con los atributos del trámite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", costo=" + costo + '}';
    }

    
    
}
