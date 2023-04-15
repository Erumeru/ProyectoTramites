/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import utilidades.AutomovilesPlacasDTO;

/**
 * Esta interfaz representa la DAO para automóviles.
 * @author 233133_233259
 */
public interface IAutoDAO {

    /**
     * Este método realiza una consulta jpql de todos los autos con su placa más reciente
     * en caso de tener alguna.
     * @return Regresa una lista de todos los autos con su placa más reciente.
     */
    List<AutomovilesPlacasDTO> cargarTodosLosAutos();

    /**
     * Este método regresa una lista de autos con su placa más reciente a partir
     * de una serie de placas.
     * @param placas Representa la serie de placas a ser utilizada para la búsqueda.
     * @return Regresa una lista de autos con su placa más reciente.
     */
    List<AutomovilesPlacasDTO> cargarAuto(String placas);

}
