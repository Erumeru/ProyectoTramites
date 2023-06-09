/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.TramiteLicenciasDAO;
import interfaces.IConexionBD;
import java.awt.event.ItemEvent;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.TramiteLicencia;
import utilidades.ConstantesGUI;

/**
 * UI para actualizar la licencia de una persona
 * @author 233133_233259
 */
public class ActualizarLicencia extends javax.swing.JFrame {

    /**
     * Permite la conexión a la base de datos
     */
    private IConexionBD conexion;
    /**
     * Persona a la cual se le actualizará la licencia
     */
    private Persona persona;
    /**
     * EntityManager utilizado para interactuar con la base de datos
     */
    private EntityManager entityManager;
    /**
     * 
     */
    private Integer vigenciaLicencia;
    private Integer costoLicencia;
    private TramiteLicenciasDAO tramiteLicenciasDAO;

    /**
     * Creates new form CreateAutoNuevo
     */
    public ActualizarLicencia(IConexionBD conexion, Persona persona) {
        initComponents();
        this.conexion = conexion;
        this.persona = persona;
        this.txtFieldCosto.setEditable(false);
        this.txtFieldNombre.setEditable(false);
        this.entityManager = conexion.crearConexion();
        this.txtFieldNombre.setText(persona.getNombres() + " " + persona.getApellido_paterno());
        this.tramiteLicenciasDAO = new TramiteLicenciasDAO(this.entityManager);
        this.calcularCosto();
        this.setLocationRelativeTo(null);
    }

    /**
     * Constructor por defecto
     * Creates new form ActualizarLicencia
     */
    public ActualizarLicencia() {
        initComponents();
    }

    /**
     * Método que calcula el costo de una licencia mediante la vigencia seleccionada
     */
    private void calcularCosto() {
        String vigencia = (String) this.cbxVigencia.getSelectedItem();
        if (vigencia.equalsIgnoreCase("1 AÑO")) {
            this.vigenciaLicencia = 1;
            if (persona.isDiscapacitado()) {
                this.costoLicencia = 200;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            } else {
                this.costoLicencia = 600;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            }
        } else if (vigencia.equalsIgnoreCase("2 AÑOS")) {
            this.vigenciaLicencia = 2;
            if (persona.isDiscapacitado()) {
                this.costoLicencia = 500;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            } else {
                this.costoLicencia = 900;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            }
        } else {
            this.vigenciaLicencia = 3;
            if (persona.isDiscapacitado()) {
                this.costoLicencia = 700;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            } else {
                this.costoLicencia = 1100;
                this.txtFieldCosto.setText("Costo: "+this.costoLicencia);
            }
        }
    }

    /**
     * Método que muestra un mensaje en la pantalla mediante un String dado en los parámetros
     * @param msj String del mensaje a mostrar en la pantalla
     */
    private void mostrarMensajePantalla(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que hace la petición del trámite para crear una nueva licencia
     */
    private void crearLicencia() {
        Persona persona = entityManager.find(Persona.class, this.persona.getId());
        if (persona != null) {
            Licencia licencia = new Licencia(this.vigenciaLicencia);
            TramiteLicencia tramite = new TramiteLicencia(licencia, this.costoLicencia , new GregorianCalendar(), persona);
            
            this.tramiteLicenciasDAO.nuevoTramite(tramite);
            
            this.mostrarMensajePantalla("Se ha tramitado la licencia correctamente");
        } else {
            this.mostrarMensajePantalla("No se pudo tramitar la licencia");
        }
        this.abrirMenuPrincipal();
    }
    
    /**
     * Método que abre el buscador de personas
     * @param gui Constante para el constructor de SelectPersona
     */
    private void abrirBuscadorPersonas(ConstantesGUI gui) {
        if (this.isVisible()) {
            new SelectPersona(conexion, gui).setVisible(true);
            this.setVisible(false);
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtFieldCosto = new javax.swing.JTextField();
        btnSig = new javax.swing.JButton();
        cbxVigencia = new javax.swing.JComboBox<>();
        lblVigencia = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        txtFieldNombre = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFieldCosto.setEditable(false);
        txtFieldCosto.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtFieldCosto.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldCosto.setText("Costo: ");
        txtFieldCosto.setBorder(null);
        txtFieldCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldCostoFocusLost(evt);
            }
        });
        txtFieldCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldCostoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldCostoMouseExited(evt);
            }
        });
        txtFieldCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCostoActionPerformed(evt);
            }
        });
        txtFieldCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldCostoKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 290, 30));

        btnSig.setForeground(new java.awt.Color(51, 51, 51));
        btnSig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnSig.png"))); // NOI18N
        btnSig.setBorder(null);
        btnSig.setBorderPainted(false);
        btnSig.setContentAreaFilled(false);
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });
        jPanel1.add(btnSig, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        cbxVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 AÑO", "2 AÑOS", "3 AÑOS" }));
        cbxVigencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVigenciaItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 232, 150, 30));

        lblVigencia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblVigencia.setText("Vigencia:");
        jPanel1.add(lblVigencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        btnCancel.setForeground(new java.awt.Color(51, 51, 51));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnCancel.png"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, -1, -1));

        txtFieldNombre.setEditable(false);
        txtFieldNombre.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtFieldNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldNombre.setText("Nombre:");
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
        jPanel1.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 290, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgActualizarLicencia/lblFondo.png"))); // NOI18N
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
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldCostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldCostoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoFocusLost

    private void txtFieldCostoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCostoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoMouseEntered

    private void txtFieldCostoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldCostoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoMouseExited

    private void txtFieldCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoActionPerformed

    private void txtFieldCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCostoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoKeyReleased

    private void txtFieldCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCostoKeyTyped

    private void txtFieldNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldNombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreFocusLost

    private void txtFieldNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreMouseEntered

    private void txtFieldNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNombreMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreMouseExited

    private void txtFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreActionPerformed

    private void txtFieldNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreKeyReleased

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        crearLicencia();
    }//GEN-LAST:event_btnSigActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       this.abrirBuscadorPersonas(ConstantesGUI.LICENCIAS);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbxVigenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVigenciaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            calcularCosto();
        }
    }//GEN-LAST:event_cbxVigenciaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSig;
    private javax.swing.JComboBox<String> cbxVigencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JTextField txtFieldCosto;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}
