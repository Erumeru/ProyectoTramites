/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Calendar;
import java.util.List;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import utilidades.ParametrosBusquedaTramites;
import utilidades.TramitesDTO;

/**
 *
 * @author eruma
 */
public interface ITramitePlacasDAO {
    
    void nuevoTramite(Placa placa);
    List<TramitesDTO> cargarTramites(Long idPersona);
    List<TramitesDTO> cargarTramites(ParametrosBusquedaTramites parametros);
    List<TramitesDTO> cargarTodosTramites();
}
