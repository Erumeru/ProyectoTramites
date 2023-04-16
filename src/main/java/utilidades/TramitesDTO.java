/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Calendar;
import java.util.Objects;

/**
 * Clase de transporte para trámites
 *
 * @author 233133_233259
 */
public class TramitesDTO {

    /**
     * Id de trámite
     */
    private Long id;

    /**
     * Costo del trámite
     */
    private Integer costoTramite;

    /**
     * Fecha de expedición del trámite
     */
    private Calendar fechaExpedicion;

    /**
     * Tipo del trámite
     */
    private String tipoTramite;

    /**
     * Nombre de la persona
     */
    private String nombrePersona;

    /**
     * Apellido de la persona
     */
    private String apellidoPersona;

    /**
     * Constructo de Trámite que inicializa los atributos con los parámetros
     *
     * @param costoTramite Costo del trámite
     * @param fechaExpedicion Fecha de expedición del trámite
     * @param tipoTramite Tipo del trámite
     * @param nombrePersona Nombre de la persona
     * @param apellidoPersona Apellido de la persona
     */
    public TramitesDTO(Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Constructo de Trámite que inicializa los atributos con los parámetros
     *
     * @param id id del trámite
     * @param costoTramite Costo del trámite
     * @param fechaExpedicion Fecha de expedición del trámite
     * @param tipoTramite Tipo del trámite
     * @param nombrePersona Nombre de la persona
     * @param apellidoPersona Apellido de la persona
     */
    public TramitesDTO(Long id, Integer costoTramite, Calendar fechaExpedicion, String tipoTramite, String nombrePersona, String apellidoPersona) {
        this.id = id;
        this.costoTramite = costoTramite;
        this.fechaExpedicion = fechaExpedicion;
        this.tipoTramite = tipoTramite;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Getter para el costo del trámite
     *
     * @return Integer del costo del trámite
     */
    public Integer getCostoTramite() {
        return costoTramite;
    }

    /**
     * Setter del costo del trámite
     *
     * @param costoTramite Costo al que settear el costo del trámite
     */
    public void setCostoTramite(Integer costoTramite) {
        this.costoTramite = costoTramite;
    }

    /**
     * Getter de la fecha expedición del trámite
     *
     * @return fecha de expedición del trámite
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Setter de fecha expedición del trámite
     * @param fechaExpedicion fecha nueva a cambiar por expedición del trámite
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Getter del tipo de trámite
     * @return String del tipo del trámite
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Setter del tipo de trámite
     * @param tipoTramite Tipo de trámite a cambiar
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Getter del nombre de la persona
     * @return String con el nombre de la persona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * Settter del nombre de la persona
     * @param nombrePersona Nombre de la persona a cambiar
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * Getter del apellido de la persona
     * @return Stringo con el apellido de la persona
     */
    public String getApellidoPersona() {
        return apellidoPersona;
    }

    /**
     * Setter del apellido de la persona
     * @param apellidoPersona Apellido nuevo a cambiar
     */
    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * Función HashCode con el id
     * @return Integer que representa el hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * función equals que compara otro objeto mediante su id
     * @param obj Objeto a comparar
     * @return True si son iguales, false en caso contrario
     */
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
