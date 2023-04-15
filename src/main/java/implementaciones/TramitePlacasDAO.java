/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import javax.persistence.EntityManager;
import interfaces.ITramitePlacasDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.TypedQuery;
import org.itson.dominio.Placa;
import utilidades.ParametrosBusquedaTramites;
import utilidades.TramitesDTO;
import java.lang.Long;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase representa la DAO para los trámites de placas.
 * @author 233133_233259
 */
public class TramitePlacasDAO implements ITramitePlacasDAO {

    /**
     * Este atributo representa un objeto de tipo EntityManager.
     */
    private final EntityManager entityManager;

    /**
     * Este constructor inicializa el valor del atributo entityManager
     * utilizando el valor recibido en el parámetro.
     * @param entityManager Representa el objeto entityManager que
     * será utilizado en la clase.
     */
    public TramitePlacasDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Este método registra un nuevo trámite de placas al sistema.
     * @param placa Representa el trámite de placas a ser registrado.
     */
    @Override
    public void nuevoTramite(Placa placa) {
        entityManager.getTransaction().begin();
        if (placa.getTramitePlacas().getCosto() == 1500) {
            entityManager.persist(placa.getAutomovil());
        }
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
    }

    /**
     * Este método regresa los trámites de placas realizados por una persona
     * a partir de su id.
     * @param idPersona Representa el id de persona a utilizar.
     * @return Regresa los trámites de placas realizados por una persona.
     */
    @Override
    public List<TramitesDTO> cargarTramites(Long idPersona) {
        List<TramitesDTO> lista = new ArrayList<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p WHERE p.id = :id";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        query.setParameter("id", idPersona);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
    }
    
    /**
     * Este método regresa todos los trámites de placas realizados.
     * @return Regresa todos los trámites de placas realizados.
     */
    @Override
    public List<TramitesDTO> cargarTodosTramites() {
        List<TramitesDTO> lista = new ArrayList<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion
        String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion FROM TramitePlacas tl "
                + "INNER JOIN tl.persona p";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();

        for (Object[] tramite : resultados) {
            lista.add(new TramitesDTO((Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
        }
        return lista;
    }

    /**
     * Este método realiza una búsqueda utilizando el operador OR de todos los trámites 
     * de placas que cumplan con los filtros recibidos en los parámetros, incluidos el 
     * período y el nombre de la persona que los realizó.
     * @param parametros Representan los parámetros que se utilizarán como filtros
     * para la búsqueda.
     * @return Regresa una lista de los trámites de placas coincidentes a la búsqueda.
     */
    @Override
    public List<TramitesDTO> cargarTramites(ParametrosBusquedaTramites parametros) {
        Set<TramitesDTO> consultaFiltros = new HashSet<>();
        //0 - nombres  1 - apellidoPaterno  2 - costo  3 - fechaExpedicion  4 - idTramite 5 - apellidoMaterno

        if (parametros.getFechaInicio() != null && parametros.getFechaFin() != null) {
            Calendar fechaInicio = Calendar.getInstance();
            Calendar fechaFin = Calendar.getInstance();
            fechaInicio.set(parametros.getFechaInicio().getYear(), parametros.getFechaInicio().getMonthValue() - 1, parametros.getFechaInicio().getDayOfMonth());
            fechaFin.set(parametros.getFechaFin().getYear(), parametros.getFechaFin().getMonthValue() - 1, parametros.getFechaFin().getDayOfMonth());
            
            List<TramitesDTO> listaFecha = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id FROM TramitePlacas tl "
                    + "INNER JOIN tl.persona p WHERE tl.fechaExpedicion >= :inicio AND tl.fechaExpedicion <= :fin";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
            query.setParameter("inicio", fechaInicio);
            query.setParameter("fin", fechaFin);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                listaFecha.add(new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]));
            }
            Set<TramitesDTO> consultaFiltroFecha = new HashSet<>(listaFecha);
            consultaFiltros.addAll(consultaFiltroFecha);
        }
        if (!parametros.getNombrePersona().equalsIgnoreCase("Ingrese su Nombre") && !parametros.getNombrePersona().isBlank()) {
            List<TramitesDTO> listaNombresSimilares = new ArrayList<>();
            String jpql = "SELECT p.nombres, p.apellido_paterno, tl.costo, tl.fechaExpedicion, tl.id, p.apellido_materno FROM TramitePlacas tl "
                    + "INNER JOIN tl.persona p";

            TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

            List<Object[]> resultados = query.getResultList();
            for (Object[] tramite : resultados) {
                TramitesDTO tramiteIteracion = new TramitesDTO((Long) tramite[4], (Integer) tramite[2], (Calendar) tramite[3], "Placa", (String) tramite[0], (String) tramite[1]);
                String nombreCompleto = tramiteIteracion.getNombrePersona() + " " + tramiteIteracion.getApellidoPersona() + " " + (String) tramite[5];
                if ((nombreCompleto.toUpperCase()).contains(parametros.getNombrePersona().toUpperCase().trim())) {
                    listaNombresSimilares.add(tramiteIteracion);
                }
            }
            Set<TramitesDTO> consultaFiltroNombre = new HashSet<>(listaNombresSimilares);
            consultaFiltros.addAll(consultaFiltroNombre);
        }

        List<TramitesDTO> tramitesEncontrados = new ArrayList<>(consultaFiltros);
        return tramitesEncontrados;
    }

}
