/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Esta entidad representa automóviles con sus respectivos atributos.
 * @author 233133_233259
 */
@Entity
@Table(name = "autos")
public class Auto implements Serializable {

    /**
     * Este atributo representa la llave primaria.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Este atributo representa el modelo del auto.
     */
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    
    /**
     * Este atributo representa el color del auto.
     */
    @Column(name = "color", nullable = false, length = 40)
    private String color;
    
    /**
     * Este atributo representa el número de serie del auto.
     */
    @Column(name = "numSerie", nullable = false, length = 20)
    private String numSerie;
    
    /**
     * Este atributo representa la línea del auto.
     */
    @Column(name = "linea", nullable = false, length = 40)
    private String linea;
    
    /**
     * Este atributo representa la marca del auto.
     */
    @Column(name = "marca", nullable = false, length = 40)
    private String marca;
    
    /**
     * Este atributo muestra si el auto es nuevo o no.
     */
    @Column(name = "nuevo", nullable = false)
    private boolean nuevo;

    /**
     * Este atributo representa la lista de placas pertenecientes al auto.
     */
    @OneToMany(mappedBy = "automovil", cascade = {CascadeType.PERSIST})
    private List<Placa> placas;

    /**
     * Este constructor crea el auto e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param id Representa la llave primaria del auto.
     * @param modelo Representa el modelo del auto.
     * @param color Representa el color del auto.
     * @param numSerie Representa el número de serie del auto.
     * @param linea Representa la línea del auto.
     * @param marca Representa la marca del auto.
     * @param nuevo Representa el estado del auto.
     */
    public Auto(Long id, String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

    /**
     * Este constructor crea el auto e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param modelo Representa el modelo del auto.
     * @param color Representa el color del auto.
     * @param numSerie Representa el número de serie del auto.
     * @param linea Representa la línea del auto.
     * @param marca Representa la marca del auto.
     */
    public Auto(String modelo, String color, String numSerie, String linea, String marca) {
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = true;
    }

    /**
     * Este método es un constructor por defecto.
     */
    public Auto() {
    }

    /**
     * Este constructor crea el auto utilizando solo la llave primaria.
     * @param id Representa la llave primaria del auto.
     */
    public Auto(Long id) {
        this.id = id;
    }

    /**
     * Este constructor crea el auto e inicializa sus atributos a los valores
     * recibidos en los parámetros.
     * @param modelo Representa el modelo del auto.
     * @param color Representa el color del auto.
     * @param numSerie Representa el número de serie del auto.
     * @param linea Representa la línea del auto.
     * @param marca Representa la marca del auto.
     * @param nuevo Representa el estado del auto.
     */
    public Auto(String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

    /**
     * Este método regresa el modelo del auto.
     * @return Regresa el modelo del auto.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Este método regresa el color del auto.
     * @return Regresa el color del auto.
     */
    public String getColor() {
        return color;
    }

    /**
     * Este método regresa el número de serie del auto.
     * @return Regresa el número de serie del auto.
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Este método regresa la línea del auto.
     * @return Regresa la línea del auto.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Este método regresa la marca del auto.
     * @return 
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Este método regresa el estado del carro.
     * @return Regresa el estado del carro.
     */
    public boolean isNuevo() {
        return nuevo;
    }

    /**
     * Este método asigna el valor del atributo modelo al valor recibido en el parámetro.
     * @param modelo Representa el valor a asignar.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Este método asigna el valor del atributo color al valor recibido en el parámetro.
     * @param color Representa el valor a asignar.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Este método asigna el valor del atributo numSerie al valor recibido en el parámetro.
     * @param numSerie Representa el valor a asignar.
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Este método asigna el valor del atributo linea al valor recibido en el parámetro.
     * @param linea Representa el valor a asignar.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Este método asigna el valor del atributo marca al valor recibido en el parámetro.
     * @param marca Representa el valor a asignar.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Este método asigna el valor del atributo nuevo al valor recibido en el parámetro.
     * @param nuevo Representa el valor a asignar.
     */
    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
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
     * Este método equals compara dos objetos Auto a partir de su id.
     * @param object Representa el objeto Auto a comparar.
     * @return Regresa true en caso de que sean iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auto)) {
            return false;
        }
        Auto other = (Auto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Este método regresa una cadena con los atributos del auto.
     * @return Regresa una cadena con los atributos del auto.
     */
    @Override
    public String toString() {
        return "org.itson.dominio.Auto[ id=" + id + " ]";
    }

}
