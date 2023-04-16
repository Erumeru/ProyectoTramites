/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.PersonaDAO;
import interfaces.IConexionBD;
import interfaces.IPersonaDAO;
import javax.swing.JOptionPane;
import utilidades.ConstantesGUI;

/**
 * UI para seleccionar un trámite
 * @author 233133_233259
 */
public class SelectTramite extends javax.swing.JFrame {

    /**
     * Conexion con la base de datos
     */
    private IConexionBD conexion;
    /**
     * Interfaz IPersonaDAO
     */
    private IPersonaDAO personaDAO;
    
    /**
     * Constructor que crea la conexión con la base de datos e inicializa la ventana de selección de trámites
     * Creates new form SelectTramite
     */
    public SelectTramite(IConexionBD conexion) {
        initComponents();
        this.conexion = conexion;
        this.personaDAO = new PersonaDAO(this.conexion.crearConexion());
        this.setLocationRelativeTo(null);
    }

    /**
     * Método que abre el buscador de las personas mediante la constante brindada
     * @param gui Constante que indica la operación al BuscadorPersonas
     */
    private void abrirBuscadorPersonas(ConstantesGUI gui) {
        if (this.isVisible()) {
            new SelectPersona(conexion, gui).setVisible(true);
            this.setVisible(false);
        }
    }
    
    /**
     * Método que abre el menú de reportes (HistorialTramites) mediante la constante dada 
     * @param gui Constante que indica la operación al HistorialTramites
     */
    private void abrirMenuReporte(ConstantesGUI gui) {
        if (this.isVisible()) {
            HistorialTramites ventana = new HistorialTramites(conexion, gui, null);
            if(ventana.isVisible()){
                this.setVisible(false);
            }
        }
    }
    
    /**
     * Método que muestra un mensaje en la pantalla
     * @param msj mensaje a mostrar
     */
    private void mostrarMensajePantalla(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
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
        btnPlacas = new javax.swing.JButton();
        btnLicencias = new javax.swing.JButton();
        btnConsultaReporte = new javax.swing.JButton();
        btnUserHistorial = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        lblAddCuentas = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlacas.setForeground(new java.awt.Color(51, 51, 51));
        btnPlacas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/btnPlacas.png"))); // NOI18N
        btnPlacas.setBorder(null);
        btnPlacas.setBorderPainted(false);
        btnPlacas.setContentAreaFilled(false);
        btnPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacasActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, -1, -1));

        btnLicencias.setForeground(new java.awt.Color(51, 51, 51));
        btnLicencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/btnLicencia.png"))); // NOI18N
        btnLicencias.setBorder(null);
        btnLicencias.setBorderPainted(false);
        btnLicencias.setContentAreaFilled(false);
        btnLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciasActionPerformed(evt);
            }
        });
        jPanel1.add(btnLicencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, -1, -1));

        btnConsultaReporte.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnConsultaReporte.setForeground(new java.awt.Color(51, 51, 51));
        btnConsultaReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectAuto/lblAddAuto.png"))); // NOI18N
        btnConsultaReporte.setText("   Consulta por reporte");
        btnConsultaReporte.setBorder(null);
        btnConsultaReporte.setBorderPainted(false);
        btnConsultaReporte.setContentAreaFilled(false);
        btnConsultaReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultaReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 250, 50));

        btnUserHistorial.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnUserHistorial.setForeground(new java.awt.Color(51, 51, 51));
        btnUserHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/btnUserHistorial.png"))); // NOI18N
        btnUserHistorial.setText("  Consulta de historial");
        btnUserHistorial.setBorder(null);
        btnUserHistorial.setBorderPainted(false);
        btnUserHistorial.setContentAreaFilled(false);
        btnUserHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnUserHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 250, 40));

        btnAddUser.setForeground(new java.awt.Color(51, 51, 51));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/addUser.png"))); // NOI18N
        btnAddUser.setBorder(null);
        btnAddUser.setBorderPainted(false);
        btnAddUser.setContentAreaFilled(false);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 570, -1, -1));

        lblAddCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/lblAgregarCuentas.png"))); // NOI18N
        jPanel1.add(lblAddCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1180, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectTramite/FondoBase.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que abre el buscador de personas para trámites de licencias
     * @param evt evento del actionPerformed
     */
    private void btnLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciasActionPerformed
        abrirBuscadorPersonas(ConstantesGUI.LICENCIAS);
    }//GEN-LAST:event_btnLicenciasActionPerformed

    /**
     * Método que abre el buscador de personas para trámite de placas
     * @param evt evento del actionPerformed
     */
    private void btnPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacasActionPerformed
        abrirBuscadorPersonas(ConstantesGUI.PLACAS);
    }//GEN-LAST:event_btnPlacasActionPerformed

    /**
     * Método que reliza una inserción masiva de personas
     * @param evt evento del actionPerformed
     */
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        if(personaDAO.insercionMasivaPersonas()){
            mostrarMensajePantalla("Se han insertado 20 registros de Personas para pruebas");
        }else{
            mostrarMensajePantalla("Ya hay suficientes registros para pruebas");
        }
        
    }//GEN-LAST:event_btnAddUserActionPerformed

    /**
     * Método que abre el menú de reporte para el reporte
     * @param evt evento del actionPerformed
     */
    private void btnConsultaReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaReporteActionPerformed
        this.abrirMenuReporte(ConstantesGUI.REPORTE);
    }//GEN-LAST:event_btnConsultaReporteActionPerformed

    /**
     * Método que abre el buscador de personas para el historial
     * @param evt evento del actionPerformed
     */
    private void btnUserHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserHistorialActionPerformed
        this.abrirBuscadorPersonas(ConstantesGUI.HISTORIAL);
    }//GEN-LAST:event_btnUserHistorialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnConsultaReporte;
    private javax.swing.JButton btnLicencias;
    private javax.swing.JButton btnPlacas;
    private javax.swing.JButton btnUserHistorial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddCuentas;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
