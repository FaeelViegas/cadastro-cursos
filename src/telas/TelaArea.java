/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.bean.Areas;
import model.bean.Cursos;
import model.dao.AreaDAO;
import model.dao.CursosDAO;

/**
 *
 * @author Senai
 */
public final class TelaArea extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private int id = 0;

    /**
     * Creates new form TelaArea
     */
    public TelaArea() {
        initComponents();
        leitura();
        tblAreas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int setar = tblAreas.getSelectedRow();
                if (setar >= 0) {
                    id = (int) tblAreas.getModel().getValueAt(setar, 0);
                } else {
                    limparCampos();
                }
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAreas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCadastrar1 = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO AREA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAreas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblAreas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tblAreas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID AREA", "ÁREA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAreas);
        if (tblAreas.getColumnModel().getColumnCount() > 0) {
            tblAreas.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 142, 730, 230));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("_____________________________________________________________");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 44, 440, 40));

        txtArea.setBackground(new java.awt.Color(0, 102, 102));
        txtArea.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtArea.setForeground(new java.awt.Color(255, 255, 255));
        txtArea.setBorder(null);
        txtArea.setOpaque(false);
        jPanel1.add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 430, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ÁREA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, 20));

        btnDeletar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDeletar.setText("DELETAR");
        btnDeletar.setBorderPainted(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 120, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 530, 60));

        btnCadastrar1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCadastrar1.setText("CADASTRAR");
        btnCadastrar1.setBorderPainted(false);
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 120, 30));

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        CursosDAO cursosDAO = new CursosDAO();
        List<Cursos> cursos = cursosDAO.leitura();
        for (Cursos objCursos : cursos) {
            if (objCursos.getArea() == id) {
                JOptionPane.showMessageDialog(null, "Você não pode excluir uma área associada a um curso sem primeiro excluir o curso correspondente!");
                return;
            }
        }
        Areas objArea = new Areas();
        if (id == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um campo!");
        } else {
            objArea.setIdArea(id);
            AreaDAO areaDao = new AreaDAO();
            areaDao.deletarCampo(objArea);
            leitura();
        }
        id = 0;
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        Areas objArea = new Areas();
        String area = txtArea.getText();
        objArea.setNomeArea(area);
        if (objArea.getNomeArea().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            AreaDAO areaDao = new AreaDAO();
            areaDao.cadastrarArea(objArea);
            leitura();
            limparCampos();
        }
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal objTelaPrincipal = new TelaPrincipal();
        objTelaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void limparCampos() {
        txtArea.setText("");

    }

    public void leitura() {
        tableModel = (DefaultTableModel) tblAreas.getModel();
        tableModel.setNumRows(0);
        AreaDAO areaDao = new AreaDAO();
        List<Areas> areas = areaDao.leitura();

        for (Areas objArea : areas) {
            Object[] rowData = {objArea.getIdArea(), objArea.getNomeArea()};
            tableModel.addRow(rowData);
        }
    }

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
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAreas;
    private javax.swing.JTextField txtArea;
    // End of variables declaration//GEN-END:variables
}
