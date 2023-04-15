/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.dominio.Persona;
import utilidades.ParametrosBusquedaPersonas;

/**
 * Esta interfaz representa la DAO para personas.
 * @author 233133_233259
 */
public interface IPersonaDAO {
    
    /**
     * Este método realiza una consulta CriteriaQuery a partir de los parámetros de 
     * fecha de nacimiento, rfc y nombre completo similar utilizando un operador OR.
     * @param parametros Representan los parámetros que se utilizarán como filtros
     * para la búsqueda.
     * @return Regresa una lista de las personas coincidentes a la búsqueda.
     */
    List <Persona> consultarPersonas(ParametrosBusquedaPersonas parametros);
    
    /**
     * Este método regresa una lista de todas las personas registradas.
     * @return Regresa una lista de todas las personas registradas.
     */
    List<Persona> cargarTodasPersonas();
    
    /**
     * Este método verifica si una persona cuenta con una licencia vigente a partir de su rfc.
     * @param rfc Representa el rfc a utilizar para la búsqueda.
     * @return Regresa true en caso de que cuente con una licencia vigente, false en caso contrario.
     */
    boolean consultarLicenciaVigentePersona(String rfc);
    
    /**
     * Este método inserta 20 registros de personas para pruebas.
     * @return Regresa true en caso de que se haya realizado la operación, false 
     * en caso de que ya existan suficientes registros para pruebas.
     */
    boolean insercionMasivaPersonas();
    
    /**
     * Este método valida si una persona es mayor de edad a partir de su rfc.
     * @param rfc Representa el rfc a utilizar para la validación.
     * @return Regresa true en caso de que sea mayor de edad, false en caso contrario.
     */
    boolean validarMayoriaEdadPersona(String rfc);
    
    /**
     * Este método realiza una consulta jpql de una persona a partir de su rfc.
     * @param rfc Representa el rfc de la persona a buscar.
     * @return Regresa una persona en caso de que la encuentre.
     */
    Persona consultarPersona(String rfc);
}
