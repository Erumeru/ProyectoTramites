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
 *
 * @author mario
 */
public interface ITramiteLicenciasDAO {
    void nuevoTramite(TramiteLicencia tramite);
    List<TramitesDTO> cargarTramites(Long idPersona);
    List<TramitesDTO> cargarTramites(ParametrosBusquedaTramites parametros);
    List<TramitesDTO> cargarTodosTramites();
}
