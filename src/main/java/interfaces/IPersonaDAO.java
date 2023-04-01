/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.util.List;
import org.itson.dominio.Persona;

/**
 *
 * @author eruma
 */
public interface IPersonaDAO {
    
    List <Persona> consultarPersonas(String rfc, String nombre, LocalDate fecha);
    List<Persona> cargarTodasPersonas();
}
