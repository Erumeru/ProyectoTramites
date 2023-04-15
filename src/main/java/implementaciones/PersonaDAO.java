/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IPersonaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
import org.itson.dominio.TramiteLicencia;
import utilidades.ParametrosBusquedaPersonas;

/**
 * Esta clase representa la DAO para personas.
 * @author 233133_233259
 */
public class PersonaDAO implements IPersonaDAO {

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
    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Este método realiza una consulta jpql de una persona a partir de su rfc.
     * @param rfc Representa el rfc de la persona a buscar.
     * @return Regresa una persona en caso de que la encuentre.
     */
    @Override
    public Persona consultarPersona(String rfc){
        String jpql = "SELECT ps FROM Persona ps WHERE ps.rfc = :rfc";
        TypedQuery<Persona> query = entityManager.createQuery(jpql, Persona.class);
        query.setParameter("rfc", rfc);
        query.setMaxResults(1);

        return query.getSingleResult();
    }
    
    /**
     * Este método realiza una consulta CriteriaQuery a partir de los parámetros de 
     * fecha de nacimiento, rfc y nombre completo similar utilizando un operador OR.
     * @param parametros Representan los parámetros que se utilizarán como filtros
     * para la búsqueda.
     * @return Regresa una lista de las personas coincidentes a la búsqueda.
     */
    @Override
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas parametros) {
        String nombre = parametros.getNombre(), rfc = parametros.getRfc();
        LocalDate fecha = parametros.getFecha();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = criteriaQuery.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();

        if (!rfc.equalsIgnoreCase("Ingrese su RFC") && !rfc.isBlank()) {
            filtros.add(criteriaBuilder.like(personaRoot.get("rfc"), rfc+"%"));
        }
        if (fecha != null) {
            Calendar fechaActual = Calendar.getInstance();
            fechaActual.set(fecha.getYear(), fecha.getMonthValue() - 1, fecha.getDayOfMonth());
            filtros.add(criteriaBuilder.equal(personaRoot.get("fecha_nacimiento"), fechaActual));
        }

        criteriaQuery = criteriaQuery.select(personaRoot).where(criteriaBuilder.or((filtros.toArray(new Predicate[0]))));

        TypedQuery<Persona> query = entityManager.createQuery(criteriaQuery);

        Set<Persona> queryFechaRFC = new HashSet<>(query.getResultList());
        
        if (!nombre.equalsIgnoreCase("Ingrese su Nombre") && !nombre.isBlank()) {
            List<Persona> personasNombreSimilar = new ArrayList<>();
            List<Persona> registroPersonas = this.cargarTodasPersonas();
            for (Persona registroPersona : registroPersonas) {
                String nombreCompleto = registroPersona.getNombres() + " "+registroPersona.getApellido_paterno() + " "+ registroPersona.getApellido_materno();
                if((nombreCompleto.toUpperCase()).contains(nombre.toUpperCase().trim())){
                    personasNombreSimilar.add(registroPersona);
                }
            }
            Set<Persona> queryNombresSimilares = new HashSet<>(personasNombreSimilar);
            queryFechaRFC.addAll(queryNombresSimilares);
            List<Persona> personasEncontradas = new ArrayList<>(queryFechaRFC);
            return personasEncontradas;
        }        
        return query.getResultList();
    }

    /**
     * Este método regresa una lista de todas las personas registradas.
     * @return Regresa una lista de todas las personas registradas.
     */
    @Override
    public List<Persona> cargarTodasPersonas() {
        String query = "SELECT p FROM Persona as p";
        TypedQuery<Persona> result = entityManager.createQuery(query, Persona.class);
        List<Persona> listPersonas = result.getResultList();
        return listPersonas;
    }

    /**
     * Este método verifica si una persona cuenta con una licencia vigente a partir de su rfc.
     * @param rfc Representa el rfc a utilizar para la búsqueda.
     * @return Regresa true en caso de que cuente con una licencia vigente, false en caso contrario.
     */
    @Override
    public boolean consultarLicenciaVigentePersona(String rfc) {
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

    /**
     * Este método inserta 20 registros de personas para pruebas.
     * @return Regresa true en caso de que se haya realizado la operación, false 
     * en caso de que ya existan suficientes registros para pruebas.
     */
    @Override
    public boolean insercionMasivaPersonas() {
        if (cargarTodasPersonas().size() >= 15) {
            return false;
        } else {
            String[] nombres = {"Ana", "Luis", "Miguel", "Sofia", "Diego", "Valentina", "Jorge", "Gabriela", "Roberto", "Maria", "Carmen", "Juan", "Carla", "Francisco", "Alejandra", "Pablo", "Lucia", "Andres", "Mariana", "Fernando"};
            String[] apellidosPaternos = {"Garcia", "Gonzalez", "Hernandez", "Martinez", "Lopez", "Perez", "Gomez", "Diaz", "Ruiz", "Flores", "Ramirez", "Sanchez", "Torres", "Reyes", "Mendoza", "Castro", "Ortiz", "Chavez", "Vargas", "Aguilar"};
            String[] apellidosMaternos = {"Ramirez", "Hernandez", "Garcia", "Torres", "Martinez", "Sanchez", "Gonzalez", "Castillo", "Fernandez", "Chavez", "Gomez", "Mendoza", "Perez", "Diaz", "Herrera", "Vazquez", "Ramos", "Lopez", "Soto", "Sosa"};
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

    /**
     * Este método valida si una persona es mayor de edad a partir de su rfc.
     * @param rfc Representa el rfc a utilizar para la validación.
     * @return Regresa true en caso de que sea mayor de edad, false en caso contrario.
     */
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
