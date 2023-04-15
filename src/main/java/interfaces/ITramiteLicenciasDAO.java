/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.dominio.TramiteLicencia;
import utilidades.ParametrosBusquedaTramites;
import utilidades.TramitesDTO;

/**
 * Esta interfaz representa la DAO para los trámites de licencias.
 * @author 233133_233259
 */
public interface ITramiteLicenciasDAO {
    
    /**
     * Este método registra un nuevo trámite de licencias al sistema.
     * @param tramite Representa el trámite a ser registrado.
     */
    void nuevoTramite(TramiteLicencia tramite);
    
    /**
     * Este método regresa los trámites de licencias realizados por una persona
     * a partir de su id.
     * @param idPersona Representa el id de persona a utilizar.
     * @return Regresa los trámites de licencias realizados por una persona.
     */
    List<TramitesDTO> cargarTramites(Long idPersona);
    
    /**
     * Este método realiza una búsqueda utilizando el operador OR de todos los trámites 
     * de licencias que cumplan con los filtros recibidos en los parámetros, incluidos el 
     * período y el nombre de la persona que los realizó.
     * @param parametros Representan los parámetros que se utilizarán como filtros
     * para la búsqueda.
     * @return Regresa una lista de los trámites de licencias coincidentes a la búsqueda.
     */
    List<TramitesDTO> cargarTramites(ParametrosBusquedaTramites parametros);
    
    /**
     * Este método regresa todos los trámites de licencias realizados.
     * @return Regresa todos los trámites de licencias realizados.
     */
    List<TramitesDTO> cargarTodosTramites();
}
