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
 *
 * @author eruma
 */
public class TramitesDataSource implements JRDataSource {

    private String[][] listadoDeTramites;
    private List<TramitesDTO> listaTramites;
    private int index;
    //   private final Object[][] listadoTramites;

    public TramitesDataSource(List<TramitesDTO> listaTramites) {
        this.listaTramites=listaTramites;
        this.listadoDeTramites= new String[listaTramites.size()][4];
        index = -1;
        for (int i = 0; i < listaTramites.size(); i++) {
            listadoDeTramites[i][0] = listaTramites.get(i).getTipoTramite();
            listadoDeTramites[i][1] = String.valueOf(listaTramites.get(i).getCostoTramite());
            Date fecha=listaTramites.get(i).getFechaExpedicion().getTime();
            listadoDeTramites[i][2] = fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900);
            listadoDeTramites[i][3] = listaTramites.get(i).getNombrePersona();
        }
    }

    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listadoDeTramites.length);
    }

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

    public JRDataSource getDataSource(){
        return new TramitesDataSource(this.listaTramites);
    }
}
