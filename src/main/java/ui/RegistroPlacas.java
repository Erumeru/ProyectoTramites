/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.ConexionBD;
import implementaciones.PlacasDAO;
import implementaciones.TramitePlacasDAO;
import interfaces.IConexionBD;
import interfaces.IPlacasDAO;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;
import org.itson.dominio.Auto;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.TramitePlacas;
import utilidades.AutomovilesPlacasDTO;
import utilidades.GeneradorPlacas;

/**
 *
 * @author eruma
 */
public class RegistroPlacas extends javax.swing.JFrame {

    private IConexionBD conexion = new ConexionBD("org.itson_Proyecto2BDA");
    private TramitePlacasDAO tramitePlacasDAO;
    private IPlacasDAO placasDAO;
    private Persona persona;
    private AutomovilesPlacasDTO auto;
    private int costo;
    private String placaNueva;

    /**
     * Creates new form RegistroPlacas
     */
    public RegistroPlacas(IConexionBD conexion, Persona persona, AutomovilesPlacasDTO auto, int costo) {
        initComponents();
        this.tramitePlacasDAO = new TramitePlacasDAO(conexion.crearConexion());
        this.persona = persona;
        this.auto = auto;
        this.costo = costo;
        this.placasDAO = new PlacasDAO(conexion.crearConexion());
        this.generarPlaca();
        this.mostrarPlacas();
        this.txtFieldCosto.setText(String.valueOf(this.costo));
        this.setLocationRelativeTo(null);
    }

    private void mostrarPlacas() {
        if (costo == 1500) {
            this.txtFieldPlacaNueva.setText(placaNueva);
            this.txtFieldPlacaNueva.setEditable(false);
        } else {
            this.txtFieldPlacaNueva.setText(placaNueva);
            this.txtFieldPlacaNueva.setEditable(false);
            this.txtFieldPlacaAnt.setText(auto.getPlacas());
            this.txtFieldPlacaAnt.setEditable(false);
        }
    }

    private void generarPlaca() {
        while (true) {
            String placaGenerada = GeneradorPlacas.generarCadena();
            if (!placasDAO.validarExistenciaPlaca(placaGenerada)) {
                this.placaNueva = placaGenerada;
                break;
            }
        }
    }

    private void abrirMenuPrincipal() {
        if (this.isVisible()) {
            new SelectTramite(conexion).setVisible(true);
            this.setVisible(false);
        }
    }

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
        btnOk = new javax.swing.JButton();
        txtFieldPlacaAnt = new javax.swing.JTextField();
        txtFieldPlacaNueva = new javax.swing.JTextField();
        txtFieldCosto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
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

        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectPersona/btnCancel.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, -1, -1));

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
        if (costo == 1000) {
            Placa placaAnterior = this.placasDAO.obtenerPlaca(this.auto.getPlacas());
            if (placaAnterior != null) {
                this.placasDAO.cancelarPlacasAuto(placaAnterior);
            }
        }
        this.tramitePlacasDAO.nuevoTramite(new Placa(new TramitePlacas(costo, new GregorianCalendar(), persona), this.placaNueva, auto.getAutomovil()));
        this.mostrarMensajePantalla("Se ha realizado el trámite de las placas");
        this.abrirMenuPrincipal();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.abrirMenuPrincipal();
    }//GEN-LAST:event_btnCancelarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextField txtFieldCosto;
    private javax.swing.JTextField txtFieldPlacaAnt;
    private javax.swing.JTextField txtFieldPlacaNueva;
    // End of variables declaration//GEN-END:variables
}
