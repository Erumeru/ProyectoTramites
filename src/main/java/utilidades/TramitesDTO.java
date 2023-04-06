/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author 
 */
public class TramitesDTO {
    
    private Long id;
    
    private Integer costoTramite;
    
    private Calendar fechaExpedicion;
    
    private String tipoTramite;
    
    private String nombrePersona;
    
    private String apellidoPersona;

    public TramitesDTO(Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    public TramitesDTO(Long id, Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.id = id;
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    public Integer getCostoTramite() {
        return costoTramite;
    }

    public void setCostoTramite(Integer costoTramite) {
        this.costoTramite = costoTramite;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TramitesDTO other = (TramitesDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
