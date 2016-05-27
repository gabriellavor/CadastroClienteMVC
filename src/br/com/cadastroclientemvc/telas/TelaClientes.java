package br.com.cadastroclientemvc.telas;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.cadastroclientemvc.conexao.ModuloConexao;
import br.com.cadastroclientemvc.dao.ClientesDAO;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import br.com.cadastroclientemvc.clientes.Clientes;
/**
 *
 * @author Gabriel Lavor
 */
public class TelaClientes extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet resultado = null;

    public TelaClientes() {
        initComponents();
        conexao = ModuloConexao.conectar();
        if (conexao != null) {
            lblClienteStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/power_on.png")));
        } else {
            lblClienteStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/power_off.png")));
        }
    }

    public void incluir() {
        Clientes clientes = new Clientes();
        ClientesDAO clientesDao = new ClientesDAO();
        clientes.setNome(txtClienteNome.getText());
        clientes.setEmail(txtClienteEmail.getText());
        clientes.setSoube_nos(comClienteSoubeNos.getSelectedItem().toString());
        if (chkClienteSim.isSelected()) {
            clientes.setReceber_notificacao("1");
        }

        if (buttonGroup1.isSelected(rdoClienteMasculino.getModel())) {
            clientes.setSexo("M");
        } else {
            clientes.setSexo("F");
        }
        if (txtClienteNome.getText().isEmpty() || txtClienteEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios(*)");
        } else {
            if (clientesDao.incluir(clientes)) {
                JOptionPane.showMessageDialog(null, "Incluido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao incluir");
            }
        }
    }

    public void pesquisar() {
        try {
            String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtClienteNome.getText() + "%");
            resultado = pst.executeQuery();
            tblCliente.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void atualizar() {
        Clientes clientes = new Clientes();
        ClientesDAO clientesDao = new ClientesDAO();
        clientes.setNome(txtClienteNome.getText());
        clientes.setEmail(txtClienteEmail.getText());
        clientes.setCodigo(Integer.parseInt(txtClienteCodigo.getText()));
        clientes.setSoube_nos(comClienteSoubeNos.getSelectedItem().toString());
        if (chkClienteSim.isSelected()) {
            clientes.setReceber_notificacao("1");
        }

        if (buttonGroup1.isSelected(rdoClienteMasculino.getModel())) {
            clientes.setSexo("M");
        } else {
            clientes.setSexo("F");
        }
        if (txtClienteCodigo.getText().isEmpty() || txtClienteNome.getText().isEmpty() || txtClienteEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatorios(*) e o CÃ³digo");
        } else {
            if (clientesDao.atualizar(clientes)) {
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                btnClienteIncluir.setEnabled(true);
                txtClienteCodigo.setText("");
                txtClienteNome.setText("");
                txtClienteEmail.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao incluir");
            }
        }
    }

    public void excluir() {
        Clientes clientes = new Clientes();
        ClientesDAO clientesDao = new ClientesDAO();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza", "AtenÃ§Ã£o", JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION) {
            if(!txtClienteCodigo.getText().isEmpty()){               
                if(clientesDao.excluir(txtClienteCodigo.getText())){
                    JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                    btnClienteIncluir.setEnabled(true);
                    txtClienteCodigo.setText("");
                    txtClienteEmail.setText("");
                    txtClienteNome.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Informe o codigo");
            }
        }
    }

    public void setarCampos() {
        int setar = tblCliente.getSelectedRow();
        txtClienteCodigo.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
        txtClienteNome.setText(tblCliente.getModel().getValueAt(setar, 1).toString());
        txtClienteEmail.setText(tblCliente.getModel().getValueAt(setar, 2).toString());
        btnClienteIncluir.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        lblClienteStatus = new javax.swing.JLabel();
        lblClienteCodigo = new javax.swing.JLabel();
        txtClienteCodigo = new javax.swing.JTextField();
        lblClienteNome = new javax.swing.JLabel();
        txtClienteNome = new javax.swing.JTextField();
        lblClienteEmail = new javax.swing.JLabel();
        txtClienteEmail = new javax.swing.JTextField();
        btnClienteIncluir = new javax.swing.JButton();
        btnClientePesquisar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        rdoClienteMasculino = new javax.swing.JRadioButton();
        rdoClienteFeminino = new javax.swing.JRadioButton();
        lblClienteSexo = new javax.swing.JLabel();
        comClienteSoubeNos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        chkClienteSim = new javax.swing.JCheckBox();
        lblClienteNotificacoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadatro de Clientes");
        setResizable(false);

        lblClienteStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/power_off.png"))); // NOI18N

        lblClienteCodigo.setText("Código");

        txtClienteCodigo.setEnabled(false);

        lblClienteNome.setText("Nome (*)");

        txtClienteNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteNomeKeyReleased(evt);
            }
        });

        lblClienteEmail.setText("E-mail (*)");

        btnClienteIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/plus.png"))); // NOI18N
        btnClienteIncluir.setToolTipText("Novo");
        btnClienteIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteIncluirActionPerformed(evt);
            }
        });

        btnClientePesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/search.png"))); // NOI18N
        btnClientePesquisar.setToolTipText("Pesquisar");
        btnClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientePesquisarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/edit.png"))); // NOI18N
        jButton3.setToolTipText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cadastroclientemvc/icones/delete.png"))); // NOI18N
        jButton4.setToolTipText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        tblCliente.getColumnModel().getColumn(0).setResizable(false);
        tblCliente.getColumnModel().getColumn(1).setResizable(false);
        tblCliente.getColumnModel().getColumn(2).setResizable(false);

        buttonGroup1.add(rdoClienteMasculino);
        rdoClienteMasculino.setSelected(true);
        rdoClienteMasculino.setText("Masculino");
        rdoClienteMasculino.setName("M"); // NOI18N

        buttonGroup1.add(rdoClienteFeminino);
        rdoClienteFeminino.setText("Feminino");

        lblClienteSexo.setText("Sexo");

        comClienteSoubeNos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Recomendação", "Site", "Outros" }));

        jLabel1.setText("Como Soube de Nós");

        chkClienteSim.setText("Sim");

        lblClienteNotificacoes.setText("Deseja Receber Notificações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClienteIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblClienteStatus))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClienteNome)
                            .addComponent(lblClienteEmail)
                            .addComponent(lblClienteCodigo)
                            .addComponent(lblClienteSexo)
                            .addComponent(jLabel1)
                            .addComponent(lblClienteNotificacoes))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoClienteMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoClienteFeminino))
                            .addComponent(comClienteSoubeNos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkClienteSim)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtClienteNome, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                        .addComponent(txtClienteEmail)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCodigo)
                    .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteNome)
                        .addComponent(txtClienteNome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteEmail)
                    .addComponent(txtClienteEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteSexo)
                    .addComponent(rdoClienteMasculino)
                    .addComponent(rdoClienteFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comClienteSoubeNos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkClienteSim)
                    .addComponent(lblClienteNotificacoes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClienteIncluir)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(540, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteIncluirActionPerformed
        incluir();
    }//GEN-LAST:event_btnClienteIncluirActionPerformed

    private void btnClientePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientePesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnClientePesquisarActionPerformed

    private void txtClienteNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteNomeKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtClienteNomeKeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        atualizar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        excluir();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClienteIncluir;
    private javax.swing.JButton btnClientePesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox chkClienteSim;
    private javax.swing.JComboBox comClienteSoubeNos;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClienteCodigo;
    private javax.swing.JLabel lblClienteEmail;
    private javax.swing.JLabel lblClienteNome;
    private javax.swing.JLabel lblClienteNotificacoes;
    private javax.swing.JLabel lblClienteSexo;
    private javax.swing.JLabel lblClienteStatus;
    private javax.swing.JRadioButton rdoClienteFeminino;
    private javax.swing.JRadioButton rdoClienteMasculino;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtClienteCodigo;
    private javax.swing.JTextField txtClienteEmail;
    private javax.swing.JTextField txtClienteNome;
    // End of variables declaration//GEN-END:variables
}
