/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.telas;

import br.com.conexao.BancoDadosConexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Welton
 */
public class TelaCadastroFuncionarios extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCadastroFuncionarios
     */
    public TelaCadastroFuncionarios() {
        initComponents();
        conn = BancoDadosConexao.getConnection();
    }

    private void cadastrar_funcionario() {
        String sql = "insert into funcionarios(id,nome,cargo,salario,login,senha)values(?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtFunId.getText());
            pst.setString(2, txtFunNome.getText());
            pst.setString(3, txtFunCargo.getText());
            pst.setString(4, txtFunSalario.getText());
            pst.setString(5, txtFunLogin.getText());
            pst.setString(6, txtFunSenha.getText());

            if (txtFunId.getText().isEmpty() || (txtFunNome.getText().isEmpty() || (txtFunCargo.getText().isEmpty() || (txtFunSalario.getText().isEmpty() || (txtFunLogin.getText().isEmpty() || (txtFunSenha.getText().isEmpty())))))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                    limpar_campos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void pesquisar_funcionario() {
        String sql = "select * from funcionarios where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtFunId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtFunNome.setText(rs.getString(2));
                txtFunCargo.setText(rs.getString(3));
                txtFunSalario.setText(rs.getString(4));
                txtFunLogin.setText(rs.getString(5));
                txtFunSenha.setText(rs.getString(6));
                btnFunAdd.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário inexistente");
                limpar_campos();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editar_funcionario() {
        String sql = "update funcionarios set nome = ?, cargo = ?, salario = ?, login = ?, senha = ? where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtFunNome.getText());
            pst.setString(2, txtFunCargo.getText());
            pst.setString(3, txtFunSalario.getText());
            pst.setString(4, txtFunLogin.getText());
            pst.setString(5, txtFunSenha.getText());
            pst.setString(6, txtFunId.getText());

            if (txtFunNome.getText().isEmpty() || (txtFunCargo.getText().isEmpty() || (txtFunSalario.getText().isEmpty() || (txtFunLogin.getText().isEmpty() || (txtFunSenha.getText().isEmpty() || (txtFunId.getText().isEmpty())))))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                    limpar_campos();
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void deletar_funcionario() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Funcionário", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from funcionarios where id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtFunId.getText());
                int removido = pst.executeUpdate();
                if (removido > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
                    limpar_campos();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    private void limpar_campos() {
        txtFunId.setText(null);
        txtFunNome.setText(null);
        txtFunCargo.setText(null);
        txtFunSalario.setText(null);
        txtFunLogin.setText(null);
        txtFunSenha.setText(null);
        btnFunAdd.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFunNome = new javax.swing.JTextField();
        txtFunCargo = new javax.swing.JTextField();
        txtFunSalario = new javax.swing.JTextField();
        txtFunLogin = new javax.swing.JTextField();
        txtFunSenha = new javax.swing.JTextField();
        btnFunAdd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtFunId = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnFunAlterar = new javax.swing.JButton();
        btnFunDeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LOJA LUXURY - Cadastro de Funcionários");
        setPreferredSize(new java.awt.Dimension(897, 540));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("*Nome:");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("*Cargo:");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("*Salário:");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("*Login:");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("*Senha:");

        btnFunAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Folder add.png"))); // NOI18N
        btnFunAdd.setToolTipText("Adicionar");
        btnFunAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunAdd.setPreferredSize(new java.awt.Dimension(64, 64));
        btnFunAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunAddActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("*Id");

        txtFunId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFunIdActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/8684048_folder_file_document_search_find_icon.png"))); // NOI18N
        btnPesquisar.setToolTipText("Pesquisar");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnFunAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/retomar.png"))); // NOI18N
        btnFunAlterar.setToolTipText("Alterar");
        btnFunAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunAlterar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnFunAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunAlterarActionPerformed(evt);
            }
        });

        btnFunDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/8684042_folder_file_document_cancel_cross_icon.png"))); // NOI18N
        btnFunDeletar.setToolTipText("Deletar");
        btnFunDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFunSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFunCargo))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFunNome, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFunSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23)
                                .addComponent(txtFunLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnFunAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnFunAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnFunDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFunNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFunCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFunSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFunLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFunSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnFunAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFunAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFunDeletar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        setBounds(0, 0, 897, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFunIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFunIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFunIdActionPerformed

    private void btnFunAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunAddActionPerformed
        // TODO add your handling code here:
        cadastrar_funcionario();
    }//GEN-LAST:event_btnFunAddActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        pesquisar_funcionario();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnFunAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunAlterarActionPerformed
        // TODO add your handling code here:
        editar_funcionario();
    }//GEN-LAST:event_btnFunAlterarActionPerformed

    private void btnFunDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunDeletarActionPerformed
        // TODO add your handling code here:
        deletar_funcionario();
    }//GEN-LAST:event_btnFunDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFunAdd;
    private javax.swing.JButton btnFunAlterar;
    private javax.swing.JButton btnFunDeletar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFunCargo;
    private javax.swing.JTextField txtFunId;
    private javax.swing.JTextField txtFunLogin;
    private javax.swing.JTextField txtFunNome;
    private javax.swing.JTextField txtFunSalario;
    private javax.swing.JTextField txtFunSenha;
    // End of variables declaration//GEN-END:variables
}
