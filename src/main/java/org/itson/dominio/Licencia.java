/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Esta entidad representa licencias con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name = "licencias")
public class Licencia implements Serializable {

    /**
     * Este atributo representa la llave primaria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Este atributo representa la vigencia de la licencia.
     */
    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;

    /**
     * Este atributo representa el trámite al que pertenece esta licencia.
     */
    @OneToOne(mappedBy="licencia")
    private TramiteLicencia tramiteLicencia;
    
    /**
     * Este método es un constructor por defecto.
     */
    public Licencia() {
    }

    /**
     * Este constructor crea la licencia e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria de la licencia.
     * @param vigencia Representa la vigencia de la licencia.
     */
    public Licencia(Long id, Integer vigencia) {
        this.id = id;
        this.vigencia = vigencia;

    }

    /**
     * Este constructor crea la licencia e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param vigencia Representa la vigencia de la licencia.
     */
    public Licencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Este constructor crea la licencia e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria de la licencia.
     * @param vigencia Representa la vigencia de la licencia.
     * @param tramiteLicencia Este atributo representa el trámite al que pertenece esta licencia.
     */
    public Licencia(Long id, Integer vigencia, TramiteLicencia tramiteLicencia) {
        this.id = id;
        this.vigencia = vigencia;
        this.tramiteLicencia = tramiteLicencia;
    }

    /**
     * Este constructor crea la licencia e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param vigencia Representa la vigencia de la licencia.
     * @param tramiteLicencia Este atributo representa el trámite al que pertenece esta licencia.
     */
    public Licencia(Integer vigencia, TramiteLicencia tramiteLicencia) {
        this.vigencia = vigencia;
        this.tramiteLicencia = tramiteLicencia;
    }

    /**
     * Este método regresa la llave primaria.
     * @return Regresa la llave primaria.
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
     * Este método regresa la vigencia de la licencia.
     * @return Regresa la vigencia de la licencia.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Este método asigna el valor del atributo vigencia al valor recibido en el parámetro.
     * @param vigencia Representa el valor a asignar. 
     */
    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
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
     * Este método equals compara dos objetos Licencia a partir de su id.
     * @param object Representa el objeto Licencia a comparar.
     * @return Regresa true en caso de que sean iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una cadena con los atributos de la licencia.
     * @return Regresa una cadena con los atributos de la licencia.
     */
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", vigencia=" + vigencia + '}';
    }

}
