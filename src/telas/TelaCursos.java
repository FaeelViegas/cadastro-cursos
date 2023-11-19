/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Areas;
import model.bean.Cursos;
import model.dao.AreaDAO;
import model.dao.CursosDAO;

/**
 *
 * @author Senai
 */
public class TelaCursos extends javax.swing.JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form TelaCursos
     */
    public TelaCursos() {
        initComponents();
        restaurarDadosComboBox();
        leitura();
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
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        txtCurso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE CURSO");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tblCursos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCursos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CURSO", "NOME CURSO", "ÁREA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCursos);
        if (tblCursos.getColumnModel().getColumnCount() > 0) {
            tblCursos.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 146, 730, 220));

        txtCurso.setBackground(new java.awt.Color(0, 102, 102));
        txtCurso.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtCurso.setForeground(new java.awt.Color(255, 255, 255));
        txtCurso.setBorder(null);
        txtCurso.setOpaque(false);
        jPanel1.add(txtCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 430, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("________________________________________________________________");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 460, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ÁREA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 10, 120, 20));

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 120, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 540, 60));

        cbxArea.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        cbxArea.setMaximumRowCount(20);
        cbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));
        cbxArea.setToolTipText("");
        cbxArea.setBorder(null);
        jPanel1.add(cbxArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 108, -1));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 8, 130, 150));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CURSO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String area = (String) cbxArea.getSelectedItem();
        if (area.equals("Selecionar")) {
            JOptionPane.showMessageDialog(null, "Selecione uma área para o curso!");
            return;
        }
        Cursos objCurso = new Cursos();
        String curso = txtCurso.getText();
        int codArea = id_area.get(cbxArea.getSelectedIndex() - 1);
        
        objCurso.setArea(codArea);
        objCurso.setNomeCurso(curso);
        if (objCurso.getNomeCurso().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            CursosDAO cursoDao = new CursosDAO();
            cursoDao.cadastrarCurso(objCurso);
            leitura();
            limparCampos();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal objTelaPrincipal = new TelaPrincipal();
        objTelaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    private void leitura() {
        tableModel = (DefaultTableModel) tblCursos.getModel();
        tableModel.setNumRows(0);
        CursosDAO cursosDAO = new CursosDAO();
        List<Cursos> cursos = cursosDAO.leitura();
        AreaDAO areaDao = new AreaDAO();
        List<Areas> areas = areaDao.leitura();

        for (Cursos objCursos : cursos) {
            // Encontrar a área correspondente ao curso
            Areas objArea = encontrarAreaPorId(areas, objCursos.getArea());

            Object[] rowData = {objCursos.getIdCurso(), objCursos.getNomeCurso(), objArea.getNomeArea()};
            tableModel.addRow(rowData);
        }
    }

    private Areas encontrarAreaPorId(List<Areas> areas, int idArea) {
        for (Areas objArea : areas) {
            if (objArea.getIdArea() == idArea) {
                return objArea;
            }
        }
        return null;
    }

    public void limparCampos() {
        txtCurso.setText("");

    }

    Vector<Integer> id_area = new Vector<Integer>();
    
    private void restaurarDadosComboBox() {
        try {
            CursosDAO objCursosDao = new CursosDAO();
            ResultSet rs = objCursosDao.listarArea();
            while (rs.next()) {
                id_area.addElement(rs.getInt(1));
                cbxArea.addItem(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(TelaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}