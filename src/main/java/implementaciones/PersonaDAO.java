/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IPersonaDAO;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.dominio.TramiteLicencia;
import utilidades.ParametrosBusquedaPersonas;

/**
 *
 * @author eruma
 */
public class PersonaDAO implements IPersonaDAO {

    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas parametros) {
        /*
        String nombre = parametros.getNombre(), rfc = parametros.getRfc();
        LocalDate fecha = parametros.getFecha();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);
        //Cuando el nombre y rfc son dados
        if ((!nombre.equalsIgnoreCase("Ingrese su Nombre"))
                && (!rfc.equalsIgnoreCase("Ingrese su RFC")) && fecha == null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(criteriaBuilder.like(personaRoot.get("rfc"), rfc),
                    criteriaBuilder.like(personaRoot.get("nombres"), nombre)));
            System.out.println("RFC Y NOMBRE OBTENIDOS");
        } //Cuando solo el nombre es dado
        else if (rfc.equalsIgnoreCase("Ingrese su RFC") && fecha == null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.like(personaRoot.get("nombres"), nombre)));
            System.out.println("RFC INVALIDO");
        } //Cuando solo el RFC es dado
        else if (nombre.equalsIgnoreCase("Ingrese su Nombre") & fecha == null) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.like(personaRoot.get("rfc"), rfc)));
            System.out.println("NOMBRE INVALIDO");
        } //Cuando solo la fecha es dada
        else if (nombre.equalsIgnoreCase("Ingrese su Nombre") && rfc.equalsIgnoreCase("Ingrese su RFC")) {
            criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.and(
                    criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fecha.toString())));
        }

        CriteriaQuery<Persona> select = criteriaQuery.select(personaRoot);
        TypedQuery<Persona> query = entityManager.createQuery(select);

        return query.getResultList();
         */

        String nombre = parametros.getNombre(), rfc = parametros.getRfc();
        LocalDate fecha = parametros.getFecha();
        
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.set(fecha.getYear(), fecha.getMonthValue()-1, fecha.getDayOfMonth());
        
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();

        if (!nombre.equalsIgnoreCase("Ingrese su Nombre")) {
            filtros.add(criteriaBuilder.like(personaRoot.get("nombres"), "%" + nombre + "%"));
        }
        if (!rfc.equalsIgnoreCase("Ingrese su RFC")) {
            filtros.add(criteriaBuilder.like(personaRoot.get("rfc"), rfc));
        }
        if (fecha != null) {
            filtros.add(criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fechaActual));
        }

        criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.or((filtros.toArray(new Predicate[0]))));

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    public List<Persona> cargarTodasPersonas() {
        String query = "SELECT p FROM Persona as p";
        TypedQuery<Persona> result = entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        //entityManager.close();
        System.out.println("Todas las personas");
        return listPersonas;
    }

    public boolean consultarLicenciaVigentePersona(String rfc) {
        //Funciona pero falta implementar la comprobación de la vigencia en la sentencia jpql
        String jpql = "SELECT tl FROM TramiteLicencia tl "
                + "INNER JOIN tl.persona ps "
                + "INNER JOIN tl.licencia lc "
                + "WHERE ps.rfc = :rfc ORDER BY tl.fechaExpedicion DESC";

        TypedQuery<TramiteLicencia> query = entityManager.createQuery(jpql, TramiteLicencia.class);
        query.setParameter("rfc", rfc);
        query.setMaxResults(1);

        List<TramiteLicencia> tramites = query.getResultList();

        if (tramites.isEmpty()) {
            return false;
        } else {
            TramiteLicencia tramite = tramites.get(0);
            Calendar fechaVigencia = tramite.getFechaExpedicion();
            fechaVigencia.add(Calendar.YEAR, tramite.getLicencia().getVigencia());

            GregorianCalendar actual = new GregorianCalendar();

            return !actual.after(fechaVigencia);
        }
    }
}
