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
    public Persona consultarPersona(String rfc){
        String jpql = "SELECT ps FROM Persona ps WHERE ps.rfc = :rfc";
        TypedQuery<Persona> query = entityManager.createQuery(jpql, Persona.class);
        query.setParameter("rfc", rfc);
        query.setMaxResults(1);

        return query.getSingleResult();
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

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();

        if (!nombre.equalsIgnoreCase("Ingrese su Nombre") && !nombre.equals("")) {
            filtros.add(criteriaBuilder.like(personaRoot.get("nombres"), "%" + nombre + "%"));
        }
        if (!rfc.equalsIgnoreCase("Ingrese su RFC") && !nombre.equals("")) {
            filtros.add(criteriaBuilder.like(personaRoot.get("rfc"), rfc));
        }
        if (fecha != null) {
            Calendar fechaActual = Calendar.getInstance();
            fechaActual.set(fecha.getYear(), fecha.getMonthValue() - 1, fecha.getDayOfMonth());
            filtros.add(criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fechaActual));
        }

        criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.or((filtros.toArray(new Predicate[0]))));

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public List<Persona> cargarTodasPersonas() {
        String query = "SELECT p FROM Persona as p";
        TypedQuery<Persona> result = entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        //entityManager.close();
        System.out.println("Todas las personas");
        return listPersonas;
    }

    @Override
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

    @Override
    public boolean insercionMasivaPersonas() {
        if (cargarTodasPersonas().size() >= 15) {
            return false;
        } else {
            String[] nombres = {"Ana", "Luis", "Miguel", "Sofía", "Diego", "Valentina", "Jorge", "Gabriela", "Roberto", "María", "Carmen", "Juan", "Carla", "Francisco", "Alejandra", "Pablo", "Lucía", "Andrés", "Mariana", "Fernando"};
            String[] apellidosPaternos = {"García", "González", "Hernández", "Martínez", "López", "Pérez", "Gómez", "Díaz", "Ruiz", "Flores", "Ramírez", "Sánchez", "Torres", "Reyes", "Mendoza", "Castro", "Ortiz", "Chávez", "Vargas", "Aguilar"};
            String[] apellidosMaternos = {"Ramírez", "Hernández", "García", "Torres", "Martínez", "Sánchez", "González", "Castillo", "Fernández", "Chávez", "Gómez", "Mendoza", "Pérez", "Díaz", "Herrera", "Vázquez", "Ramos", "López", "Soto", "Sosa"};
            String[] rfcs = {"ABC12345678901", "DEF23456789012", "GHI34567890123", "JKL45678901234", "MNO56789012345", "PQR67890123456", "STU78901234567", "VWX89012345678", "YZA90123456789", "BCD01234567890", "EFG12345678901", "HIJ23456789012", "KLM34567890123", "NOP45678901234", "QRS56789012345", "TUV67890123456", "WXY78901234567", "ZAB89012345678", "CDE90123456789", "FGH01234567890"};
            String[] telefonos = {"6441100001", "6441200002", "6441300003", "6441400004", "6441500005", "6441600006", "6441700007", "6441800008", "6441900009", "6442100010", "6442200011", "6442300012", "6442400013", "6442500014", "6442600015", "6442700016", "6442800017", "6442900018", "6443100019", "6443200020"};

            GregorianCalendar[] fechasDeNacimiento = new GregorianCalendar[20];

            fechasDeNacimiento[0] = new GregorianCalendar(1990, 3, 22);
            fechasDeNacimiento[1] = new GregorianCalendar(1985, 11, 10);
            fechasDeNacimiento[2] = new GregorianCalendar(1992, 8, 5);
            fechasDeNacimiento[3] = new GregorianCalendar(1988, 5, 28);
            fechasDeNacimiento[4] = new GregorianCalendar(1995, 0, 15);
            fechasDeNacimiento[5] = new GregorianCalendar(1991, 10, 2);
            fechasDeNacimiento[6] = new GregorianCalendar(1997, 6, 18);
            fechasDeNacimiento[7] = new GregorianCalendar(1984, 2, 30);
            fechasDeNacimiento[8] = new GregorianCalendar(1993, 4, 8);
            fechasDeNacimiento[9] = new GregorianCalendar(1999, 1, 14);

            fechasDeNacimiento[10] = new GregorianCalendar(2006, 7, 1);
            fechasDeNacimiento[11] = new GregorianCalendar(2002, 3, 11);
            fechasDeNacimiento[12] = new GregorianCalendar(2009, 11, 24);
            fechasDeNacimiento[13] = new GregorianCalendar(2010, 6, 7);
            fechasDeNacimiento[14] = new GregorianCalendar(2012, 1, 16);
            fechasDeNacimiento[15] = new GregorianCalendar(2014, 8, 28);
            fechasDeNacimiento[16] = new GregorianCalendar(2015, 4, 10);
            fechasDeNacimiento[17] = new GregorianCalendar(2016, 2, 2);
            fechasDeNacimiento[18] = new GregorianCalendar(2017, 9, 19);
            fechasDeNacimiento[19] = new GregorianCalendar(2018, 7, 3);

            entityManager.getTransaction().begin();
            for (int i = 0; i < 20; i++) {
                boolean discapacitado = (i % 2 == 0 ? false : true);
                Persona persona = new Persona(discapacitado, fechasDeNacimiento[i], telefonos[i], rfcs[i], nombres[i], apellidosPaternos[i], apellidosMaternos[i]);
                entityManager.persist(persona);
            }
            entityManager.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean validarMayoriaEdadPersona(String rfc) {
        Persona persona = this.consultarPersona(rfc);
        Calendar fechaNacimiento = persona.getFecha_nacimiento();
        
        if (persona != null) {
            Calendar fechaCumpleMayoriaEdad = Calendar.getInstance();
            fechaCumpleMayoriaEdad.setTime(fechaNacimiento.getTime());
            fechaCumpleMayoriaEdad.add(Calendar.YEAR, 18);
            
            Calendar fechaActual = Calendar.getInstance();
            
            return !fechaActual.before(fechaCumpleMayoriaEdad);
        } else {
            System.out.println("Error al buscar la persona");
            return false;
        }
    }
}
