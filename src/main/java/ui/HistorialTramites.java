/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author eruma
 */
public class HistorialTramites extends javax.swing.JFrame {

    /**
     * Creates new form HistorialTramites
     */
    public HistorialTramites() {
        initComponents();
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
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTramites = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtFieldNombre = new javax.swing.JTextField();
        dpFin = new com.github.lgooddatepicker.components.DatePicker();
        dpInicio = new com.github.lgooddatepicker.components.DatePicker();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        lblLinea = new javax.swing.JLabel();
        lblGuion = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnLupa.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, -1));

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
        jPanel1.add(txtFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 206, 350, -1));
        jPanel1.add(dpFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 162, -1, -1));
        jPanel1.add(dpInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 162, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Placa", "Licencia" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 125, 120, -1));

        btnReporte.setForeground(new java.awt.Color(51, 51, 51));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgHistorialTramites/btnReporte.png"))); // NOI18N
        btnReporte.setBorder(null);
        btnReporte.setBorderPainted(false);
        btnReporte.setContentAreaFilled(false);
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
        // TODO add your handling code here:
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
    }//GEN-LAST:event_txtFieldNombreKeyReleased

    private void txtFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldNombreKeyTyped
        txtFieldNombre.setText(txtFieldNombre.getText().trim());
        if (txtFieldNombre.getText().equals("Ingrese su Nombre")) {
            txtFieldNombre.setText("");
        }
    }//GEN-LAST:event_txtFieldNombreKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistorialTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialTramites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialTramites().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReporte;
    private com.github.lgooddatepicker.components.DatePicker dpFin;
    private com.github.lgooddatepicker.components.DatePicker dpInicio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblGuion;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JTable tblTramites;
    private javax.swing.JTextField txtFieldNombre;
    // End of variables declaration//GEN-END:variables
}