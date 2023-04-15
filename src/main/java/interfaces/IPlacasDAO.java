/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import org.itson.dominio.Placa;

/**
 * Esta interfaz representa la DAO para placas.
 * @author 233133_233259
 */
public interface IPlacasDAO {
    
    /**
     * Este método realiza la validación de la existencia de unas placas a partir
     * de su serie de placas.
     * @param seriePlacas Representan las placas a utilizar para validación.
     * @return Regresa true en caso de que existan, false en caso contrario.
     */
    boolean validarExistenciaPlaca(String seriePlacas);
    
    /**
     * Este método realiza la cancelación de unas placas estableciendo
     * su fecha de recepción a la fecha del sistema.
     * @param placa Representan las placas a ser canceladas.
     */
    void cancelarPlacasAuto(Placa placa);
    
    /**
     * Este método regresa una placa a partir de su serie de placas.
     * @param seriePlacas Representan las placas a utilizar para validación.
     * @return Regresa un objeto Placa en caso de que se encuentre, null
     * en caso contrario.
     */
    Placa obtenerPlaca(String seriePlacas);
}
