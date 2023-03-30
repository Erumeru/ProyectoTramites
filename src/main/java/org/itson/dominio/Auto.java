/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 233133_233259
 */
@Entity
@Table(name="autos")
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="modelo",nullable=false, length=20)
    private String modelo;
    @Column(name="color",nullable=false, length=20)
    private String color;
    @Column(name="numSerie",nullable=false, length=20)
    private String numSerie;
    @Column(name="linea",nullable=false, length=20)
    private String linea;
    @Column(name="marca",nullable=false, length=20)
    private String marca;
    @Column(name="nuevo",nullable=false)
    private boolean nuevo;

    public Auto(Long id, String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

    public Auto() {
    }

    public Auto(Long id) {
        this.id = id;
    }

    public Auto(String modelo, String color, String numSerie, String linea, String marca, boolean nuevo) {
        this.modelo = modelo;
        this.color = color;
        this.numSerie = numSerie;
        this.linea = linea;
        this.marca = marca;
        this.nuevo = nuevo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public String getLinea() {
        return linea;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.itson.dominio.Auto[ id=" + id + " ]";
    }
    
}
