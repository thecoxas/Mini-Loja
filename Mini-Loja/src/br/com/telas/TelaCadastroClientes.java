/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.telas;

import java.sql.*;
import br.com.conexao.BancoDadosConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Welton
 */
public class TelaCadastroClientes extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCadastroClientes
     */
    public TelaCadastroClientes() {
        initComponents();
        conn = BancoDadosConexao.getConnection();
    }

    private void cadastrar_cliente() {
        String sql = "insert into clientes (nome,sexo,endereco,telefone)values(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCadCliNome.getText());
            pst.setString(2, cboCadCliSexo.getSelectedItem().toString());
            pst.setString(3, txtCadCliEndereco.getText());
            pst.setString(4, txtCadCliFone.getText());

            if (txtCadCliNome.getText().isEmpty() || (txtCadCliEndereco.getText().isEmpty() || (txtCadCliFone.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios");

            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                    limpar_campos();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void pesquisar_cliente() {
        String sql = "select * from clientes where nome like ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCliPesquisar.getText() + "%");
            rs = pst.executeQuery();
            tblCliente.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setar_campos() {
        int setar = tblCliente.getSelectedRow();
        txtCadCliId.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
        txtCadCliNome.setText(tblCliente.getModel().getValueAt(setar, 1).toString());
        cboCadCliSexo.setSelectedItem(tblCliente.getModel().getValueAt(setar, 2).toString());
        txtCadCliEndereco.setText(tblCliente.getModel().getValueAt(setar, 3).toString());
        txtCadCliFone.setText(tblCliente.getModel().getValueAt(setar, 4).toString());
        btnCliAdd.setEnabled(false);
    }

    private void alterar_cliente() {
        String sql = "update clientes set nome = ?, sexo = ?, endereco = ?, telefone = ? where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtCadCliNome.getText());
            pst.setString(2, cboCadCliSexo.getSelectedItem().toString());
            pst.setString(3, txtCadCliEndereco.getText());
            pst.setString(4, txtCadCliFone.getText());
            pst.setString(5, txtCadCliId.getText());
            if (txtCadCliNome.getText().isEmpty() || (txtCadCliEndereco.getText().isEmpty() || (txtCadCliFone.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos Obrigatórios");
            } else {
                int alterado = pst.executeUpdate();
                if (alterado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso");
                    limpar_campos();
                    btnCliAdd.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void deletar_cliente() {
        int deletado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Excluir este cliente", "Atenção", JOptionPane.YES_NO_OPTION);
        if (deletado == JOptionPane.YES_OPTION) {
            String sql = "delete from clientes where id = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtCadCliId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
                    limpar_campos();
                    btnCliAdd.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void limpar_campos() {
        txtCadCliId.setText(null);
        txtCadCliNome.setText(null);
        cboCadCliSexo.setSelectedItem(null);
        txtCadCliEndereco.setText(null);
        txtCadCliFone.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCadCliNome = new javax.swing.JTextField();
        cboCadCliSexo = new javax.swing.JComboBox<>();
        txtCadCliEndereco = new javax.swing.JTextField();
        btnCliAdd = new javax.swing.JButton();
        btnCliEditar = new javax.swing.JButton();
        btnCliDeletar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        txtCadCliFone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCadCliId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LOJA LUXURY - Cadastro de Clientes");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("*Telefone:");

        jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("*Endereço:");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Sexo:");

        jLabel5.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("*Nome:");

        txtCadCliNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cboCadCliSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboCadCliSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Masculino", "Feminino" }));

        txtCadCliEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnCliAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/Folder add.png"))); // NOI18N
        btnCliAdd.setPreferredSize(new java.awt.Dimension(64, 64));
        btnCliAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliAddActionPerformed(evt);
            }
        });

        btnCliEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/retomar.png"))); // NOI18N
        btnCliEditar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnCliEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliEditarActionPerformed(evt);
            }
        });

        btnCliDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/8684042_folder_file_document_cancel_cross_icon.png"))); // NOI18N
        btnCliDeletar.setPreferredSize(new java.awt.Dimension(64, 64));
        btnCliDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDeletarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        txtCliPesquisar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCliPesquisar.setForeground(new java.awt.Color(0, 0, 102));
        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagens/search-engine-optimization (1).png"))); // NOI18N

        tblCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Sexo", "Endereço", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        txtCadCliFone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Id cliente:");

        txtCadCliId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCadCliId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCadCliFone, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCadCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCadCliNome)
                            .addComponent(txtCadCliEndereco))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnCliAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnCliEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCliDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCadCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCadCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCadCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboCadCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadCliFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCliDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliAddActionPerformed
        // TODO add your handling code here:
        cadastrar_cliente();
    }//GEN-LAST:event_btnCliAddActionPerformed

    private void txtCliPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnCliEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliEditarActionPerformed
        // TODO add your handling code here:
        alterar_cliente();
    }//GEN-LAST:event_btnCliEditarActionPerformed

    private void btnCliDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDeletarActionPerformed
        // TODO add your handling code here:
        deletar_cliente();
    }//GEN-LAST:event_btnCliDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliAdd;
    private javax.swing.JButton btnCliDeletar;
    private javax.swing.JButton btnCliEditar;
    private javax.swing.JComboBox<String> cboCadCliSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtCadCliEndereco;
    private javax.swing.JTextField txtCadCliFone;
    private javax.swing.JTextField txtCadCliId;
    private javax.swing.JTextField txtCadCliNome;
    private javax.swing.JTextField txtCliPesquisar;
    // End of variables declaration//GEN-END:variables
}
