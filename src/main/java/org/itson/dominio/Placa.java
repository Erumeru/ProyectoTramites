/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author 233133_233259
 */
@Entity
@Table(name = "placas")
public class Placa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idTramitePlacas", nullable = false)
    private TramitePlacas tramitePlacas;
    
    @Column(name = "fechaRecepcion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaRecepcion;
    
    @Column(name = "seriePlacas", nullable = false, length = 7)
    private String seriePlacas;
    
    @ManyToOne
    @JoinColumn(name = "idAuto", nullable = false)
    private Auto automovil;

    public Placa() {
    }

    public Placa(TramitePlacas tramitePlacas, String seriePlacas, Auto automovil) {
        this.tramitePlacas = tramitePlacas;
        this.seriePlacas = seriePlacas;
        this.automovil = automovil;
    }

    public Placa(Long id, TramitePlacas tramitePlacas, String seriePlacas, Auto automovil) {
        this.id = id;
        this.tramitePlacas = tramitePlacas;
        this.seriePlacas = seriePlacas;
        this.automovil = automovil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TramitePlacas getTramitePlacas() {
        return tramitePlacas;
    }

    public void setTramitePlacas(TramitePlacas tramitePlacas) {
        this.tramitePlacas = tramitePlacas;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getSeriePlacas() {
        return seriePlacas;
    }

    public void setSeriePlacas(String seriePlacas) {
        this.seriePlacas = seriePlacas;
    }

    public Auto getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Auto automovil) {
        this.automovil = automovil;
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
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Placa{" + "id=" + id + ", seriePlacas=" + seriePlacas + '}';
    }

}
