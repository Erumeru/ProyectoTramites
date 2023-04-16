/*t`
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import utilidades.TramitesDTO;

/**
 * Clase que sirve para la creación del reporte Jasper
 * @author 233133_233259
 */
public class TramitesDataSource implements JRDataSource {

    /**
     * Matriz la cual representa nuestra tabla a llenar con información
     */
    private String[][] listadoDeTramites;
    /**
     * Atributo que sirve de DTO para información de los trámites
     */
    private List<TramitesDTO> listaTramites;
    /**
     * Atributo que sirve como index para la tabla.
     */
    private int index;
    //   private final Object[][] listadoTramites;

    /**
     * Constructor que llena el arreglo bidimensional con una lista de TramitesDTO
     * @param listaTramites Lista de trámites con las que llenar el reporte
     */
    public TramitesDataSource(List<TramitesDTO> listaTramites) {
        this.listaTramites=listaTramites;
        this.listadoDeTramites= new String[listaTramites.size()][4];
        index = -1;
        for (int i = 0; i < listaTramites.size(); i++) {
            listadoDeTramites[i][0] = listaTramites.get(i).getTipoTramite();
            listadoDeTramites[i][1] = "$"+String.valueOf(listaTramites.get(i).getCostoTramite());
            Date fecha=listaTramites.get(i).getFechaExpedicion().getTime();
            listadoDeTramites[i][2] = fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900);
            listadoDeTramites[i][3] = listaTramites.get(i).getNombrePersona()+ " "+listaTramites.get(i).getApellidoPersona();
        }
    }

    /**
     * Método que analiza si el index actual es menor al length del listado de tramites
     * @return Verdadero si el index es menor al lenght de listado de los trámites, falso en caso contrario
     * @throws JRException Excepción que llega a lanzar.
     */
    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listadoDeTramites.length);
    }

    /**
     * Método que te regresa el valor de algún campo
     * @param jrf Field a analizar
     * @return Regresa un objeto que está en el campo solicitado
     * @throws JRException Excepción que llega a lanzar
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object value = null;

        String fieldName = jrf.getName();
        switch (fieldName) {
            case "campoTipo":
                value = listadoDeTramites[index][0];
                break;
            case "campoCosto":
                value = listadoDeTramites[index][1];
                break;
            case "campoFecha":
                value = listadoDeTramites[index][2];
                break;
            case "campoNombre":
                value = listadoDeTramites[index][3];
                break;

        }
        return value;
    }

    /**
     * Método público el cual regresa el DataSource de TramitesDataSource.
     * @return DataSource de TramitesDataSource.
     */
    public JRDataSource getDataSource(){
        return new TramitesDataSource(this.listaTramites);
    }
}
