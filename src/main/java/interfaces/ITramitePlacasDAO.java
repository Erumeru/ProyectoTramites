/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.dominio.Placa;
import utilidades.ParametrosBusquedaTramites;
import utilidades.TramitesDTO;

/**
 * Esta interfaz representa la DAO para los trámites de placas.
 * @author 233133_233259
 */
public interface ITramitePlacasDAO {
    
    /**
     * Este método registra un nuevo trámite de placas al sistema.
     * @param placa Representa el trámite de placas a ser registrado.
     */
    void nuevoTramite(Placa placa);
    
    /**
     * Este método regresa los trámites de placas realizados por una persona
     * a partir de su id.
     * @param idPersona Representa el id de persona a utilizar.
     * @return Regresa los trámites de placas realizados por una persona.
     */
    List<TramitesDTO> cargarTramites(Long idPersona);
    
    /**
     * Este método realiza una búsqueda utilizando el operador OR de todos los trámites 
     * de placas que cumplan con los filtros recibidos en los parámetros, incluidos el 
     * período y el nombre de la persona que los realizó.
     * @param parametros Representan los parámetros que se utilizarán como filtros
     * para la búsqueda.
     * @return Regresa una lista de los trámites de placas coincidentes a la búsqueda.
     */
    List<TramitesDTO> cargarTramites(ParametrosBusquedaTramites parametros);
    
    /**
     * Este método regresa todos los trámites de placas realizados.
     * @return Regresa todos los trámites de placas realizados.
     */
    List<TramitesDTO> cargarTodosTramites();
}
