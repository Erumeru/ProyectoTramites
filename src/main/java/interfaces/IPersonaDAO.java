/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.util.List;
import org.itson.dominio.Persona;
import utilidades.ParametrosBusquedaPersonas;

/**
 *
 * @author eruma
 */
public interface IPersonaDAO {
    
    List <Persona> consultarPersonas(ParametrosBusquedaPersonas parametros);
    List<Persona> cargarTodasPersonas();
    boolean consultarLicenciaVigentePersona(String rfc);
}
