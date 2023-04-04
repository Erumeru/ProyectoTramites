/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.dominio.Auto;
import utilidades.AutomovilesPlacasDTO;

/**
 *
 * @author eruma
 */
public interface IAutoDAO {

    List<AutomovilesPlacasDTO> cargarTodosLosAutos();
    
    List<AutomovilesPlacasDTO> cargarAuto(String placas);

}
