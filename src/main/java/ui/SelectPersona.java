/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.ConexionBD;
import implementaciones.PersonaDAO;
import interfaces.IConexionBD;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Persona;
import utilidades.ConstantesGUI;
import utilidades.ParametrosBusquedaPersonas;

/**
 * UI para seleccionar una persona
 * @author 233133_233259
 */
public class SelectPersona extends javax.swing.JFrame {

    /**
     * Conexión con la base de datos
     */
    private IConexionBD conexion;
    /**
     * Atributo PersonaDAO para realizar operaciones con persona
     */
    private PersonaDAO persona;
    /**
     * Constante que indica la operación a realizar
     */
    private ConstantesGUI operacion;

    /**
     * Constructor que crea una UI dependiendo de la constante indicada
     * Creates new form SelectPersona
     */
    public SelectPersona(IConexionBD conexion, ConstantesGUI gui) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.conexion = conexion;
        this.persona = new PersonaDAO(conexion.crearConexion());
        this.operacion = gui;
        this.cargarPersonas();
        this.establecerLimiteFecha();
    }

    /**
     * Método que establece un límite para la fecha
     */
    private void establecerLimiteFecha(){
        LocalDate fechaLimiteInferior = LocalDate.of(1900, 1, 1);
        LocalDate fechaLimiteSuperior = LocalDate.now();
        DpFecha.getSettings().setDateRangeLimits(fechaLimiteInferior, fechaLimiteSuperior);
    }
    
    /**
     * Método que carga las personas a la tabla y da formato a la fecha
     */
    private void cargarPersonas() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPersonas.getModel();
        modeloTabla.setRowCount(0);
        List<Persona> listaPersonas = new ArrayList<>();
        if (this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") && this.txtFieldRFC.getText().equalsIgnoreCase("Ingrese su RFC") && this.DpFecha.getDate() == null) {
            listaPersonas = persona.cargarTodasPersonas();
        } else {
            ParametrosBusquedaPersonas parametros = new ParametrosBusquedaPersonas(this.txtFieldRFC.getText(), this.txtFieldNombre.getText(), this.DpFecha.getDate());
            listaPersonas = persona.consultarPersonas(parametros);
        }
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) != null) {
                Object[] fila = {listaPersonas.get(i).getNombres(), listaPersonas.get(i).getApellido_paterno(),
                    listaPersonas.get(i).getApellido_materno(), listaPersonas.get(i).getRfc(), formateador.format((listaPersonas.get(i).getFecha_nacimiento()).getTime())};
                modeloTabla.addRow(fila);
            }
        }
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
     * Método que abre la ventana de automoviles cuando el trámite es de placas
     */
    private void abrirVentanaAutomoviles() {
        if (this.isVisible()) {
            Persona personaElegida = this.persona.consultarPersona((String) this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 3));
            new SelectAuto(conexion, personaElegida).setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * Método que abre la ventana de licencias cuando el trámite es de licencias
     */
    private void abrirVentanaLicencia() {
        if (this.isVisible()) {
            Persona personaElegida = this.persona.consultarPersona((String) this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 3));
            new ActualizarLicencia(conexion, personaElegida).setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * Método que muestra un mensaje en la pantalla mediante el String msj
     * @param msj Mensaje a mostrar
     */
    private void mostrarMensajePantalla(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que abre el menú de reporte (HistorialTramites para reportes) dependiendo la constante indicada
     * @param gui Constante para el constructor HistorialTramites
     */
    private void abrirMenuReporte(ConstantesGUI gui) {
        if (this.isVisible()) {
            Persona personaElegida = this.persona.consultarPersona((String) this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 3));
            HistorialTramites ventana = new HistorialTramites(conexion, gui, personaElegida);
            if(ventana.isVisible()){
                this.setVisible(false);
            }else{
                this.abrirMenuPrincipal();
            }
        }
    }

    /**
     * Método que comprueba que la persona puede continuar con el trámite de licencia
     * @param rfcPersonaSeleccionada Rfc de la persona
     */
    private void operacionLicencia(String rfcPersonaSeleccionada) {
        boolean vigencia = persona.consultarLicenciaVigentePersona(rfcPersonaSeleccionada),
                mayoriaEdad = persona.validarMayoriaEdadPersona(rfcPersonaSeleccionada);

        if (vigencia && mayoriaEdad) {
            this.mostrarMensajePantalla("No se puede registrar licencia para esta persona debido a que ya cuenta con una vigente");
        } else if (!vigencia && mayoriaEdad) {
            this.mostrarMensajePantalla("Cumple con los requisitos para seguir con el trámite");
            this.abrirVentanaLicencia();
        } else if (!vigencia && !mayoriaEdad) {
            this.mostrarMensajePantalla("No se puede registrar licencia para esta persona debido a que es menor de edad");
        } else {
            this.mostrarMensajePantalla("No se puede registrar licencia para esta persona debido a que es menor de edad");
        }
    }

    /**
     * Método que comprueba que la persona cuenta con los requisitos para seguir con el trámite de placas
     * @param rfcPersonaSeleccionada Rfc de la persona
     */
    private void operacionPlacas(String rfcPersonaSeleccionada) {
        boolean vigencia = persona.consultarLicenciaVigentePersona(rfcPersonaSeleccionada),
                mayoriaEdad = persona.validarMayoriaEdadPersona(rfcPersonaSeleccionada);
        if (vigencia && mayoriaEdad) {
            this.mostrarMensajePantalla("Cumple con los requisitos para seguir con el trámite");
            this.abrirVentanaAutomoviles();
        } else if (!vigencia && mayoriaEdad) {
            this.mostrarMensajePantalla("No se puede seguir con el trámite debido a que no cuenta con una licencia vigente");
        } else if (!vigencia && !mayoriaEdad) {
            this.mostrarMensajePantalla("No se puede seguir con el trámite debido a que no cuenta con una licencia vigente y es menor de edad");
        } else {
            this.mostrarMensajePantalla("No se puede seguir con el trámite debido a que es menor de edad");
        }
    }

    /**
     * Método que comprueba si la persona es mayor de edad y si lo es abre un HistorialTramites para ver el historial
     * @param rfcPersonaSeleccionada Rfc de la persona seleccionada
     */
    private void operacionHistorial(String rfcPersonaSeleccionada) {
        boolean mayoriaEdad = persona.validarMayoriaEdadPersona(rfcPersonaSeleccionada);
        if (mayoriaEdad) {
            this.mostrarMensajePantalla("Cumple con los requisitos para seguir con la operación");
            this.abrirMenuReporte(ConstantesGUI.HISTORIAL);
        } else {
            this.mostrarMensajePantalla("No se puede seguir con la operación debido a que es menor de edad");
        }
    }

    /**
     * Método que dependiendo de la constante realiza una operación al avanzar a la siguiente entrada
     */
    private void siguiente() {
        Integer indiceRenglonInicial = 0, indiceColumnaRFC = 3;
        if (this.tblPersonas.getSelectedRow() >= indiceRenglonInicial) {
            String rfcPersonaSeleccionada = (String) this.tblPersonas.getModel().getValueAt(this.tblPersonas.getSelectedRow(), indiceColumnaRFC);
            if (this.operacion == ConstantesGUI.LICENCIAS) {
                this.operacionLicencia(rfcPersonaSeleccionada);
            } else if (this.operacion == ConstantesGUI.PLACAS) {
                this.operacionPlacas(rfcPersonaSeleccionada);
            } else if (this.operacion == ConstantesGUI.HISTORIAL) {
                this.operacionHistorial(rfcPersonaSeleccionada);
            }
        } else {
            this.mostrarMensajePantalla("Seleccione a una persona o realice una búsqueda de personas");
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

        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jPanel1 = new javax.swing.JPanel();
        DpFecha = new com.github.lgooddatepicker.components.DatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSig = new javax.swing.JButton();
        txtFieldNombre = new javax.swing.JTextField();
        txtFieldRFC = new javax.swing.JTextField();
        lblRenglon = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(DpFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 260, 30));

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Ap. Paterno", "Ap. Materno", "RFC", "F.Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonas);
        if (tblPersonas.getColumnModel().getColumnCount() > 0) {
            tblPersonas.getColumnModel().getColumn(0).setPreferredWidth(12);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 760, 320));

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
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

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
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, -1, -1));

        btnSig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnSig.png"))); // NOI18N
        btnSig.setBorder(null);
        btnSig.setBorderPainted(false);
        btnSig.setContentAreaFilled(false);
        btnSig.setForeground(new java.awt.Color(51, 51, 51));
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });
        jPanel1.add(btnSig, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, -1, -1));

        txtFieldNombre.setText("Ingrese su Nombre");
        txtFieldNombre.setBorder(null);
        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
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
        jPanel1.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 178, 350, -1));

        txtFieldRFC.setText("Ingrese su RFC");
        txtFieldRFC.setBorder(null);
        txtFieldRFC.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldRFC.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldRFC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldRFCFocusLost(evt);
            }
        });
        txtFieldRFC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldRFCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldRFCMouseExited(evt);
            }
        });
        txtFieldRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldRFCActionPerformed(evt);
            }
        });
        txtFieldRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldRFCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldRFCKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 350, -1));

        lblRenglon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/lblRenglon.png"))); // NOI18N
        jPanel1.add(lblRenglon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/lblFondo.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldRFCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldRFCFocusLost
        if (txtFieldRFC.getText().equals("")) {
            txtFieldRFC.setText("Ingrese su RFC");
        }
    }//GEN-LAST:event_txtFieldRFCFocusLost

    private void txtFieldRFCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldRFCMouseEntered
        if (txtFieldRFC.getText().equals("Ingrese su RFC"))
            txtFieldRFC.setText("");
    }//GEN-LAST:event_txtFieldRFCMouseEntered

    private void txtFieldRFCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldRFCMouseExited
        if (txtFieldRFC.getText().equals("")) {
            txtFieldRFC.setText("Ingrese su RFC");
        } else if (!txtFieldRFC.getText().equals("Ingrese su RFC")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldRFCMouseExited

    private void txtFieldRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldRFCActionPerformed

    }//GEN-LAST:event_txtFieldRFCActionPerformed

    private void txtFieldRFCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldRFCKeyReleased
        // TODO add your handling code here:
        txtFieldRFC.setText(txtFieldRFC.getText().trim());
    }//GEN-LAST:event_txtFieldRFCKeyReleased

    private void txtFieldRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldRFCKeyTyped
        txtFieldRFC.setText(txtFieldRFC.getText().trim());
        if (txtFieldRFC.getText().equals("Ingrese su RFC")) {
            txtFieldRFC.setText("");
        }
        
        // Permitir solo letras y números
        char c = evt.getKeyChar();
        if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldRFCKeyTyped

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
        if (txtFieldNombre.getText().trim().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        } else if (!txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
        //txtFieldNombre.setText(txtFieldNombre.getText().trim());
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
        this.cargarPersonas();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        abrirMenuPrincipal();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSigActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker DpFecha;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSig;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblRenglon;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtFieldNombre;
    private javax.swing.JTextField txtFieldRFC;
    // End of variables declaration//GEN-END:variables

}
