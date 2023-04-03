/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author eruma
 */
public class RegistroPlacas extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPlacas
     */
    public RegistroPlacas() {
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
        btnOk = new javax.swing.JButton();
        txtFieldPlacaAnt = new javax.swing.JTextField();
        txtFieldPlacaNueva = new javax.swing.JTextField();
        txtFieldCosto = new javax.swing.JTextField();
        btnOk1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOk.setForeground(new java.awt.Color(51, 51, 51));
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistroPlacas/btnOk.png"))); // NOI18N
        btnOk.setBorder(null);
        btnOk.setBorderPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel1.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 572, -1, -1));

        txtFieldPlacaAnt.setEditable(false);
        txtFieldPlacaAnt.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtFieldPlacaAnt.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldPlacaAnt.setBorder(null);
        txtFieldPlacaAnt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPlacaAntFocusLost(evt);
            }
        });
        txtFieldPlacaAnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldPlacaAntMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldPlacaAntMouseExited(evt);
            }
        });
        txtFieldPlacaAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPlacaAntActionPerformed(evt);
            }
        });
        txtFieldPlacaAnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldPlacaAntKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPlacaAntKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldPlacaAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 310, 30));

        txtFieldPlacaNueva.setEditable(false);
        txtFieldPlacaNueva.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtFieldPlacaNueva.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldPlacaNueva.setBorder(null);
        txtFieldPlacaNueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPlacaNuevaFocusLost(evt);
            }
        });
        txtFieldPlacaNueva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldPlacaNuevaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldPlacaNuevaMouseExited(evt);
            }
        });
        txtFieldPlacaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPlacaNuevaActionPerformed(evt);
            }
        });
        txtFieldPlacaNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldPlacaNuevaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPlacaNuevaKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldPlacaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 265, 310, 30));

        txtFieldCosto.setEditable(false);
        txtFieldCosto.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        txtFieldCosto.setForeground(new java.awt.Color(153, 153, 153));
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
        jPanel1.add(txtFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 375, 310, 30));

        btnOk1.setForeground(new java.awt.Color(51, 51, 51));
        btnOk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnCancel.png"))); // NOI18N
        btnOk1.setBorder(null);
        btnOk1.setBorderPainted(false);
        btnOk1.setContentAreaFilled(false);
        btnOk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOk1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnOk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgRegistroPlacas/lblFondo.png"))); // NOI18N
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

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

    }//GEN-LAST:event_btnOkActionPerformed

    private void btnOk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOk1ActionPerformed

    private void txtFieldPlacaNuevaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaFocusLost

    }//GEN-LAST:event_txtFieldPlacaNuevaFocusLost

    private void txtFieldPlacaNuevaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaMouseEntered

    }//GEN-LAST:event_txtFieldPlacaNuevaMouseEntered

    private void txtFieldPlacaNuevaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaMouseExited

    }//GEN-LAST:event_txtFieldPlacaNuevaMouseExited

    private void txtFieldPlacaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaActionPerformed

    }//GEN-LAST:event_txtFieldPlacaNuevaActionPerformed

    private void txtFieldPlacaNuevaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaKeyReleased

    }//GEN-LAST:event_txtFieldPlacaNuevaKeyReleased

    private void txtFieldPlacaNuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacaNuevaKeyTyped

    }//GEN-LAST:event_txtFieldPlacaNuevaKeyTyped

    private void txtFieldPlacaAntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntFocusLost

    private void txtFieldPlacaAntMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntMouseEntered

    private void txtFieldPlacaAntMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntMouseExited

    private void txtFieldPlacaAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntActionPerformed

    private void txtFieldPlacaAntKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntKeyReleased

    private void txtFieldPlacaAntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacaAntKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPlacaAntKeyTyped

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
            java.util.logging.Logger.getLogger(RegistroPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPlacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPlacas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOk1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextField txtFieldCosto;
    private javax.swing.JTextField txtFieldPlacaAnt;
    private javax.swing.JTextField txtFieldPlacaNueva;
    // End of variables declaration//GEN-END:variables
}