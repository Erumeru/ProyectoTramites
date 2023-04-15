/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import criptografia.EncriptadorAESConverter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * Esta entidad representa personas con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    /**
     * Este atributo representa la llave primaria.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Este atributo representa el estado de discapacidad de una persona.
     */
    @Column(name = "discapacitado", nullable = false)
    private boolean discapacitado;
    
    /**
     * Este atributo representa la fecha de nacimiento de una persona.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;
    
    /**
     * Este atributo representa el teléfono de una persona.
     */
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;
    
    /**
     * Este atributo representa el rfc de una persona.
     */
    @Column(name = "rfc", nullable = false, length = 15)
    private String rfc;
    
    /**
     * Este atributo representa los nombres de una persona.
     */
    @Convert(converter = EncriptadorAESConverter.class)
    @Column(name = "nombres", nullable = false, length = 128)
    private String nombres;
    
    /**
     * Este atributo representa el apellido paterno de una persona.
     */
    @Convert(converter = EncriptadorAESConverter.class)
    @Column(name = "apellido_paterno", nullable = false, length = 128)
    private String apellido_paterno;
    
    /**
     * Este atributo representa el apellido materno de una persona.
     */
    @Convert(converter = EncriptadorAESConverter.class)
    @Column(name = "apellido_materno", nullable = false, length = 128)
    private String apellido_materno;

    /**
     * Este atributo representa los trámites que ha realizado una persona.
     */
    @OneToMany(mappedBy = "persona")
    private List<Tramite> tramites;
    
    /**
     * Este método es un constructor por defecto.
     */
    public Persona() {
    }

    /**
     * Este constructor crea la persona e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param discapacitado Representa el estado de discapacitadad de la persona.
     * @param fecha_nacimiento Representa la fecha de nacimiento de la persona.
     * @param telefono Representa el teléfono de una persona.
     * @param rfc Representa el rfc de una persona.
     * @param nombres Representa los nombres de una persona.
     * @param apellido_paterno Representa el apellido paterno de una persona.
     * @param apellido_materno Representa el apellido materno de una persona.
     */
    public Persona(boolean discapacitado, Calendar fecha_nacimiento, String telefono, String rfc, String nombres, String apellido_paterno, String apellido_materno) {
        this.discapacitado = discapacitado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    /**
     * Este constructor crea la persona e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria de una persona.
     * @param discapacitado Representa el estado de discapacitadad de la persona.
     * @param fecha_nacimiento Representa la fecha de nacimiento de la persona.
     * @param telefono Representa el teléfono de una persona.
     * @param rfc Representa el rfc de una persona.
     * @param nombres Representa los nombres de una persona.
     * @param apellido_paterno Representa el apellido paterno de una persona.
     * @param apellido_materno Representa el apellido materno de una persona.
     */
    public Persona(Long id, boolean discapacitado, Calendar fecha_nacimiento, String telefono, String rfc, String nombres, String apellido_paterno, String apellido_materno) {
        this.id = id;
        this.discapacitado = discapacitado;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    /**
     * Este método regresa la llave primaria de la persona.
     * @return Regresa la llave primaria de la persona.
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
     * Este método regresa el estado de discapacidad de la persona.
     * @return Regresa el estado de discapacidad de la persona.
     */
    public boolean isDiscapacitado() {
        return discapacitado;
    }

    /**
     * Este método asigna el valor del atributo discapacitado al valor recibido en el parámetro.
     * @param discapacitado Representa el valor a asignar.
     */
    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Este método regresa la fecha de nacimiento de la persona.
     * @return Regresa la fecha de nacimiento de la persona.
     */
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Este método asigna el valor del atributo discapacitado al valor recibido en el parámetro.
     * @param fecha_nacimiento Representa el valor a asignar.
     */
    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Este método regresa el teléfono de la persona.
     * @return Regresa el teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Este método asigna el valor del atributo telefono al valor recibido en el parámetro.
     * @param telefono Representa el valor a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Este método regresa el rfc de la persona.
     * @return Regresa el rfc de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Este método asigna el valor del atributo rfc al valor recibido en el parámetro.
     * @param rfc Representa el valor a asignar.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Este método regresa los nombres de la persona.
     * @return Regresa los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Este método asigna el valor del atributo nombres al valor recibido en el parámetro.
     * @param nombres Representa el valor a asignar.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Este método regresa el apellido paterno de la persona.
     * @return Regresa el apellido paterno de la persona.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Este método asigna el valor del atributo apellido_paterno al valor recibido en el parámetro.
     * @param apellido_paterno Representa el valor a asignar.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Este método regresa el apellido materno de la persona.
     * @return Regresa el apellido materno de la persona.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Este método asigna el valor del atributo apellido_materno al valor recibido en el parámetro.
     * @param apellido_materno Representa el valor a asignar.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Este método regresa los trámites realizados por la persona.
     * @return Regresa los trámites realizados por la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Este método asigna el valor del atributo tramites al valor recibido en el parámetro.
     * @param tramites Representa el valor a asignar.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
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
     * Este método equals compara dos objetos Persona a partir de su id.
     * @param object Representa el objeto Persona a comparar.
     * @return Regresa true en caso de que sean iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una cadena con los atributos de la persona.
     * @return Regresa una cadena con los atributos de la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + '}';
    }

}
