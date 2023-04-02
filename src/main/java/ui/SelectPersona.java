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
import java.util.List;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Persona;
import utilidades.ConstantesGUI;
import utilidades.ParametrosBusquedaPersonas;

/**
 *
 * @author eruma
 */
public class SelectPersona extends javax.swing.JFrame {

    private IConexionBD conexion = new ConexionBD("org.itson_Proyecto2BDA");
    private PersonaDAO persona;
    private ConstantesGUI operacion;

    /**
     * Creates new form SelectPersona
     */
    public SelectPersona(IConexionBD conexion, ConstantesGUI gui) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.persona = new PersonaDAO(conexion.crearConexion());
        this.operacion = gui;
        this.cargarPersonas();
    }

    private void cargarPersonas() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPersonas.getModel();
        modeloTabla.setRowCount(0);
        if (this.txtFieldNombre.getText().equalsIgnoreCase("Ingrese su Nombre") && this.txtFieldRFC.getText().equalsIgnoreCase("Ingrese su RFC") && this.DpFecha.getDate() == null) {
            List<Persona> listaPersonas = persona.cargarTodasPersonas();
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i) != null) {
                    Object[] fila = {listaPersonas.get(i).getNombres(), listaPersonas.get(i).getApellido_paterno(),
                        listaPersonas.get(i).getApellido_materno(), listaPersonas.get(i).getRfc(), formateador.format((listaPersonas.get(i).getFecha_nacimiento()).getTime())};
                    modeloTabla.addRow(fila);
                    System.out.println(listaPersonas.get(i));
                }
            }
        } else {
            ParametrosBusquedaPersonas parametros = new ParametrosBusquedaPersonas(this.txtFieldRFC.getText(), this.txtFieldNombre.getText(), this.DpFecha.getDate());
            List<Persona> listaPersonas = persona.consultarPersonas(parametros);
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i) != null) {
                    Object[] fila = {listaPersonas.get(i).getNombres(), listaPersonas.get(i).getApellido_paterno(),
                        listaPersonas.get(i).getApellido_materno(), listaPersonas.get(i).getRfc(), formateador.format((listaPersonas.get(i).getFecha_nacimiento()).getTime())};
                    modeloTabla.addRow(fila);
                    System.out.println(listaPersonas.get(i));
                }
            }
        }
    }

    private void abrirMenuPrincipal() {
        if (this.isVisible()) {
            new SelectTramite(conexion).setVisible(true);
            this.setVisible(false);
        }
    }

    private void siguiente(){
        Integer indiceRenglonInicial = 0, indiceColumnaRFC = 3;
        if (this.tblPersonas.getSelectedRow() >= indiceRenglonInicial) {

            if (this.operacion == ConstantesGUI.LICENCIAS) {
                String rfcPersonaSeleccionada = (String) this.tblPersonas.getModel().getValueAt(this.tblPersonas.getSelectedRow(), indiceColumnaRFC);

                boolean vigencia = persona.consultarLicenciaVigentePersona(rfcPersonaSeleccionada),
                        mayoriaEdad = persona.validarMayoriaEdadPersona(rfcPersonaSeleccionada);
                
                if(vigencia&&mayoriaEdad){
                    System.out.printf("La persona con el rfc %s cuenta con una licencia vigente y es mayor de edad\n", rfcPersonaSeleccionada);
                    System.out.println("Regresar al inicio o dejar en la misma pantalla ya que no se puede registrar licencia para esta persona debido a que ya cuenta con una vigente");
                }else if(!vigencia&&mayoriaEdad){
                    System.out.printf("La persona con el rfc %s no cuenta con una licencia vigente y es mayor de edad\n", rfcPersonaSeleccionada);
                    System.out.println("Cuenta con los requisitos para continuar con el proceso para tramitar licencia");
                }else if(!vigencia&&!mayoriaEdad){
                    System.out.printf("La persona con el rfc %s no cuenta con una licencia vigente y no es mayor de edad\n", rfcPersonaSeleccionada);
                    System.out.println("Regresar al inicio o dejar en la misma pantalla ya que no se puede registrar licencia para esta persona ya que no es mayor de edad");
                }else{
                    System.out.printf("La persona con el rfc %s cuenta con una licencia vigente y no es mayor de edad\n", rfcPersonaSeleccionada);
                    System.out.println("Validar la informacion para verificar si esta persona menor de edad cuenta con una licencia ya que no es posible");
                }
            } else if (this.operacion == ConstantesGUI.PLACAS) {
                System.out.println("En desarrollo");
            } else {
                System.out.println("Operación inválida");
            }

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
        btnSig1 = new javax.swing.JButton();
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

        btnSig1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnLupa.png"))); // NOI18N
        btnSig1.setBorder(null);
        btnSig1.setBorderPainted(false);
        btnSig1.setContentAreaFilled(false);
        btnSig1.setForeground(new java.awt.Color(51, 51, 51));
        btnSig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSig1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, -1));

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

        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.setText("Ingrese su Nombre");
        txtFieldNombre.setBorder(null);
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
        if (txtFieldNombre.getText().equals("")) {
            txtFieldNombre.setText("Ingrese su Nombre");
        } else if (!txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed

    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
    }//GEN-LAST:event_txtFieldNombreKeyReleased

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
        if (txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            txtFieldNombre.setText("");
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void btnSig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSig1ActionPerformed
        this.cargarPersonas();
    }//GEN-LAST:event_btnSig1ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        abrirMenuPrincipal();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        siguiente();
    }//GEN-LAST:event_btnSigActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker DpFecha;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSig;
    private javax.swing.JButton btnSig1;
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
