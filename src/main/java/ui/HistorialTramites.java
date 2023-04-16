/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.TramiteLicenciasDAO;
import implementaciones.TramitePlacasDAO;
import interfaces.IConexionBD;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.dominio.Persona;
import reportes.TramitesDataSource;
import utilidades.ConstantesGUI;
import utilidades.ParametrosBusquedaTramites;
import utilidades.TramitesDTO;

/**
 * UI para mostrar el Historial de Trámites
 * @author 233133_233259
 */
public class HistorialTramites extends javax.swing.JFrame {

    /**
     * Constante que indica la operación
     */
    private ConstantesGUI operacion;
    /**
     * Conexión con la base
     */
    private IConexionBD conexion;
    /**
     * Persona cuyos trámites quieren ser consultados
     */
    private Persona personaSeleccionada;
    /**
     * DAO para manejar los trámites de licencias
     */
    private TramiteLicenciasDAO licenciasDAO;
    /**
     * DAO para manejar los trámites de placas
     */
    private TramitePlacasDAO placasDAO;
    /**
     * Reporte de JasperReports.
     */
    private TramitesDataSource reporteJasper;

    /**
     * Constructor que inicializa la UI dependiendo de la operación seleccionada.
     * Creates new form HistorialTramites
     */
    public HistorialTramites(IConexionBD conexion, ConstantesGUI operacion, Persona personaSeleccionada) {
        initComponents();
        this.operacion = operacion;
        this.conexion = conexion;
        this.personaSeleccionada = personaSeleccionada;
        this.licenciasDAO = new TramiteLicenciasDAO(conexion.crearConexion());
        this.placasDAO = new TramitePlacasDAO(conexion.crearConexion());
        this.ajustarInterfaz();
        this.cargarTramites();
        this.setLocationRelativeTo(null);
    }

    /**
     * Ajusta la interfaz si sólo se desea ver el historial o se busca generar algún reporte
     */
    private void ajustarInterfaz() {
        if (operacion == ConstantesGUI.HISTORIAL) {
            btnBuscar.setVisible(false);
            dpFin.setVisible(false);
            dpInicio.setVisible(false);
            txtFieldNombre.setVisible(false);
            lblFondoReutilizar.setVisible(true);
            lblFondoReutilizar2.setVisible(true);
            btnReporte.setVisible(false);
        } else {
            btnBuscar.setVisible(true);
            dpFin.setVisible(true);
            dpInicio.setVisible(true);
            txtFieldNombre.setVisible(true);
            lblFondoReutilizar.setVisible(false);
            lblFondoReutilizar2.setVisible(false);
            btnReporte.setVisible(true);
            this.dpFin.getSettings().setDateRangeLimits(LocalDate.MIN, LocalDate.now());
            this.dpInicio.getSettings().setDateRangeLimits(LocalDate.MIN, LocalDate.now());
        }
    }

    /**
     * Método que carga los trámites cuando la constante es Historial
     * @param tramites Lista de TrámitesDTO
     * @param tipo Tipo de trámites
     */
    private void operacionHistorial(List<TramitesDTO> tramites, String tipo) {
        if (tipo.equals("Todo")) {
            tramites.addAll(licenciasDAO.cargarTramites(personaSeleccionada.getId()));
            tramites.addAll(placasDAO.cargarTramites(personaSeleccionada.getId()));
        } else if (tipo.equals("Placa")) {
            tramites.addAll(placasDAO.cargarTramites(personaSeleccionada.getId()));
        } else {
            tramites.addAll(licenciasDAO.cargarTramites(personaSeleccionada.getId()));
        }
    }

    /**
     * Método que carga los trámites cuando la constante NO es Historial
     * @param tramites Lista de TrámitesDTO
     * @param tipo Tipo de trámites
     */
    private void operacionReporte(List<TramitesDTO> tramites, String tipo) {
        if (tipo.equals("Todo")) {
            tramites.addAll(licenciasDAO.cargarTramites(new ParametrosBusquedaTramites(this.dpInicio.getDate(), this.dpFin.getDate(), this.txtFieldNombre.getText())));
            tramites.addAll(placasDAO.cargarTramites(new ParametrosBusquedaTramites(this.dpInicio.getDate(), this.dpFin.getDate(), this.txtFieldNombre.getText())));
            if ((this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") || this.txtFieldNombre.getText().equals(""))
                    && this.dpInicio.getDate() == null && this.dpFin.getDate() == null) {
                tramites.addAll(licenciasDAO.cargarTodosTramites());
                tramites.addAll(placasDAO.cargarTodosTramites());
            }
        } else if (tipo.equals("Placa")) {
            tramites.addAll(placasDAO.cargarTramites(new ParametrosBusquedaTramites(this.dpInicio.getDate(), this.dpFin.getDate(), this.txtFieldNombre.getText())));
            if ((this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") || this.txtFieldNombre.getText().equals(""))
                    && this.dpInicio.getDate() == null && this.dpFin.getDate() == null) {
                tramites.addAll(placasDAO.cargarTodosTramites());
            }
        } else {
            tramites.addAll(licenciasDAO.cargarTramites(new ParametrosBusquedaTramites(this.dpInicio.getDate(), this.dpFin.getDate(), this.txtFieldNombre.getText())));
            if ((this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") || this.txtFieldNombre.getText().equals(""))
                    && this.dpInicio.getDate() == null && this.dpFin.getDate() == null) {
                tramites.addAll(licenciasDAO.cargarTodosTramites());
            }
        }
    }

    /**
     * Método que llena la tabla y da un formato a la fecha.
     * @param tramites Lista de TrámitesDTO con la que se llenará la tabla
     */
    private void llenarTabla(List<TramitesDTO> tramites) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTramites.getModel();
        modeloTabla.setRowCount(0);
        for (int i = 0; i < tramites.size(); i++) {
            if (tramites.get(i) != null) {
                Object[] fila = {tramites.get(i).getTipoTramite(), ("$" + tramites.get(i).getCostoTramite()), formateador.format((tramites.get(i).getFechaExpedicion()).getTime()),
                    (tramites.get(i).getNombrePersona() + " " + tramites.get(i).getApellidoPersona())};
                modeloTabla.addRow(fila);
            }
        }
    }

    /**
     * Método utilizado para cargar los trámites dependiendo de las operaciones solicitadas (Historial o no)
     */
    private void cargarTramites() {
        String tipo = (String) this.cbxTipo.getSelectedItem();
        List<TramitesDTO> tramites = new ArrayList<>();

        if (operacion == ConstantesGUI.HISTORIAL) {
            this.operacionHistorial(tramites, tipo);
        } else {
            this.operacionReporte(tramites, tipo);
        }

        this.llenarTabla(tramites);

        if (tramites.size() == 0) {
            if (operacion == ConstantesGUI.HISTORIAL) {
                this.mostrarMensajePantalla("Esta persona no ha realizado trámites");
            } else {
                if (this.dpInicio.getDate() != null && this.dpFin.getDate() != null) {
                    if (this.dpInicio.getDate().isAfter(this.dpFin.getDate())) {
                        this.mostrarMensajePantalla("La fecha de inicio está después que la del final");
                        return;
                    }
                }else{
                    this.mostrarMensajePantalla("Periodo malformado");
                    return;
                }
                this.mostrarMensajePantalla("No hay trámites registrados actualmente en el sistema");
            }
        }

        this.reporteJasper = new TramitesDataSource(tramites);
    }

    /**
     * Método que muestra un mensaje en la pantalla mediante el parámetro msj
     * @param msj Mensaje a mostrar
     */
    private void mostrarMensajePantalla(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que abre el menú principal
     */
    private void abrirMenuPrincipal() {
        if (this.isVisible()) {
            new SelectTramite(conexion).setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * Método que genera el reporte de JasperReports y te da una previsualización de cómo se verá
     */
    private void generarReporte() {
        //Se genera el reporte utilizando la libreria JasperReports.
        try {
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("src\\main\\java\\reportes\\MaritElmer.jasper");
            JasperPrint jPrint = JasperFillManager.fillReport(report, null, this.reporteJasper.getDataSource());
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            ex.getMessage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFondoReutilizar = new javax.swing.JLabel();
        lblFondoReutilizar2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtFieldNombre = new javax.swing.JTextField();
        dpFin = new com.github.lgooddatepicker.components.DatePicker();
        dpInicio = new com.github.lgooddatepicker.components.DatePicker();
        cbxTipo = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        lblLinea = new javax.swing.JLabel();
        lblGuion = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFondoReutilizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/lblFondoReutilizar.png"))); // NOI18N
        lblFondoReutilizar.setText("jLabel1");
        jPanel1.add(lblFondoReutilizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 260, 50));

        lblFondoReutilizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/lblFondoReutilizar.png"))); // NOI18N
        lblFondoReutilizar2.setText("jLabel1");
        jPanel1.add(lblFondoReutilizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 520, 70));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnCancel.png"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 584, -1, -1));

        tblTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Costo", "Fecha Expedición", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTramites);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 750, 330));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnLupa.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNombre.setText("Ingrese su Nombre");
        txtFieldNombre.setBorder(null);
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldNombreFocusLost(evt);
            }
        });
        txtFieldNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldNombreMouseExited(evt);
            }
        });
        txtFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNombreActionPerformed(evt);
            }
        });
        txtFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 206, 350, -1));
        jPanel1.add(dpFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 162, -1, -1));
        jPanel1.add(dpInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 162, -1, -1));

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Placa", "Licencia" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 125, 120, -1));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/btnReporte.png"))); // NOI18N
        btnReporte.setBorder(null);
        btnReporte.setBorderPainted(false);
        btnReporte.setContentAreaFilled(false);
        btnReporte.setForeground(new java.awt.Color(51, 51, 51));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 584, -1, -1));

        lblLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/lblLinea.png"))); // NOI18N
        lblLinea.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        lblGuion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/lblGuion.png"))); // NOI18N
        lblGuion.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(lblGuion, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 175, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/lblFondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        }
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseEntered
        if (txtFieldNombre.getText().equals("Ingrese su Nombre"))
            txtFieldNombre.setText("");
    }//GEN-LAST:event_txtFieldNombreMouseEntered

    private void txtFieldNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseExited
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        } else if (!txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased

    }//GEN-LAST:event_txtFieldNombreKeyReleased
    private boolean spacePressed = false;

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            // El caracter ingresado es una letra
            evt.setKeyChar(c); // Permitir el caracter
            spacePressed = false;
        } else if (Character.isISOControl(c)) {
            // Permitir caracteres de control como backspace y delete
            evt.setKeyChar(c);
            spacePressed = false;
        } else if (Character.isWhitespace(c)) {
            // Permitir un solo espacio
            if (!spacePressed) {
                evt.setKeyChar(c);
                spacePressed = true;
            } else {
                evt.consume(); // Ignorar el caracter
            }
        } else {
            // El caracter ingresado no es una letra ni un caracter de control
            evt.consume(); // Ignorar el caracter
            spacePressed = false;
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarTramites();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        this.generarReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.abrirMenuPrincipal();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed

    }//GEN-LAST:event_cbxTipoActionPerformed

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cargarTramites();
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbxTipo;
    private com.github.lgooddatepicker.components.DatePicker dpFin;
    private com.github.lgooddatepicker.components.DatePicker dpInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondoReutilizar;
    private javax.swing.JLabel lblFondoReutilizar2;
    private javax.swing.JLabel lblGuion;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
