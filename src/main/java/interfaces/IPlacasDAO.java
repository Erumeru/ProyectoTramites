/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import org.itson.dominio.Placa;

/**
 *
 * @author mario
 */
public interface IPlacasDAO {
    boolean validarExistenciaPlaca(String seriePlacas);
    void cancelarPlacasAuto(Placa placa);
    Placa obtenerPlaca(String seriePlacas);
}
