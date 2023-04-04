/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import implementaciones.AutoDAO;
import implementaciones.ConexionBD;
import interfaces.IConexionBD;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Auto;
import utilidades.AutomovilesPlacasDTO;
import utilidades.ConstantesGUI;

/**
 *
 * @author eruma
 */
public class SelectAuto extends javax.swing.JFrame {

    private IConexionBD conexion = new ConexionBD("org.itson_Proyecto2BDA");
    private AutoDAO autoDAO;

    /**
     * Creates new form SelectAuto
     */
    public SelectAuto(IConexionBD conexion) {
        initComponents();
        this.autoDAO = new AutoDAO(conexion.crearConexion());
        this.cargarAutos();
    }

    private void cargarAutos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAutos.getModel();
        modeloTabla.setRowCount(0);
        String placas = this.txtFieldPlacas.getText();
        if (placas.equalsIgnoreCase("Ingrese su Serie de Placas") || placas.equalsIgnoreCase("")) {
            List<AutomovilesPlacasDTO> listAutos = autoDAO.cargarTodosLosAutos();
            for (int i = 0; i < listAutos.size(); i++) {
                if (listAutos.get(i) != null) {
                    Object[] fila = {listAutos.get(i).getPlacas(), listAutos.get(i).getAutomovil().getNumSerie(), listAutos.get(i).getAutomovil().getMarca(),
                        listAutos.get(i).getAutomovil().getModelo(), listAutos.get(i).getAutomovil().getColor()};
                    modeloTabla.addRow(fila);
                    System.out.println(listAutos.get(i));
                }
            }
        } else {
            List<AutomovilesPlacasDTO> listAutos = autoDAO.cargarAuto(placas);
            for (int i = 0; i < listAutos.size(); i++) {
                if (listAutos.get(i) != null) {
                    Object[] fila = {listAutos.get(i).getPlacas(), listAutos.get(i).getAutomovil().getNumSerie(), listAutos.get(i).getAutomovil().getMarca(),
                        listAutos.get(i).getAutomovil().getModelo(), listAutos.get(i).getAutomovil().getColor()};
                    modeloTabla.addRow(fila);
                    System.out.println(listAutos.get(i));
                }
            }
        }
    }

    private void abrirBuscadorPersonas(ConstantesGUI gui) {
        if (this.isVisible()) {
            new SelectPersona(conexion, gui).setVisible(true);
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
        txtFieldPlacas = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutos = new javax.swing.JTable();
        btnSig = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAddAuto = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFieldPlacas.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtFieldPlacas.setForeground(new java.awt.Color(153, 153, 153));
        txtFieldPlacas.setText("Ingrese su Serie de Placas");
        txtFieldPlacas.setBorder(null);
        txtFieldPlacas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldPlacasFocusLost(evt);
            }
        });
        txtFieldPlacas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtFieldPlacasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldPlacasMouseExited(evt);
            }
        });
        txtFieldPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPlacasActionPerformed(evt);
            }
        });
        txtFieldPlacas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldPlacasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFieldPlacasKeyTyped(evt);
            }
        });
        jPanel1.add(txtFieldPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 350, -1));

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
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        tblAutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "No. Serie", "Marca", "Modelo", "Color"
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
        jScrollPane1.setViewportView(tblAutos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 760, 370));

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

        btnAddAuto.setForeground(new java.awt.Color(51, 51, 51));
        btnAddAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectAuto/lblAddAuto.png"))); // NOI18N
        btnAddAuto.setBorder(null);
        btnAddAuto.setBorderPainted(false);
        btnAddAuto.setContentAreaFilled(false);
        btnAddAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 576, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSelectAuto/fondo.png"))); // NOI18N
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

    private void btnAddAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAutoActionPerformed

    }//GEN-LAST:event_btnAddAutoActionPerformed

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed

    }//GEN-LAST:event_btnSigActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        abrirBuscadorPersonas(ConstantesGUI.PLACAS);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtFieldPlacasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldPlacasFocusLost
        if (txtFieldPlacas.getText().equals("")) {
            txtFieldPlacas.setText("Ingrese su Serie de Placas");
        }
    }//GEN-LAST:event_txtFieldPlacasFocusLost

    private void txtFieldPlacasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacasMouseEntered
        if (txtFieldPlacas.getText().equals("Ingrese su Serie de Placas"))
            txtFieldPlacas.setText("");
    }//GEN-LAST:event_txtFieldPlacasMouseEntered

    private void txtFieldPlacasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldPlacasMouseExited
        if (txtFieldPlacas.getText().equals("")) {
            txtFieldPlacas.setText("Ingrese su Serie de Placas");
        } else if (!txtFieldPlacas.getText().equals("Ingrese su Serie de Placas")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFieldPlacasMouseExited

    private void txtFieldPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPlacasActionPerformed

    }//GEN-LAST:event_txtFieldPlacasActionPerformed

    private void txtFieldPlacasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacasKeyReleased
        // TODO add your handling code here:
        txtFieldPlacas.setText(txtFieldPlacas.getText().trim());
    }//GEN-LAST:event_txtFieldPlacasKeyReleased

    private void txtFieldPlacasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPlacasKeyTyped
        txtFieldPlacas.setText(txtFieldPlacas.getText().trim());
        if (txtFieldPlacas.getText().equals("Ingrese su Serie de Placas")) {
            txtFieldPlacas.setText("");
        }
    }//GEN-LAST:event_txtFieldPlacasKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.cargarAutos();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAuto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSig;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tblAutos;
    private javax.swing.JTextField txtFieldPlacas;
    // End of variables declaration//GEN-END:variables
}
