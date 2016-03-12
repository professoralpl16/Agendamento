/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controle.C_Especialidade;
import Modelo.M_Especialidade;
import conexao.CarregaTabelas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class Especialidade extends javax.swing.JFrame {
private ResultSet tabela;   
int total = 0;
int linha = 0;

public void preencheTabela()
    {
        C_Especialidade ce = new C_Especialidade();
        tabela = ce.dadosTabela(txtPesquisa.getText());
        
        
        String titulo[] = {"Código","Especialidade"};
        //tabela = ce.consultaDados();
        
        
        
        CarregaTabelas ct = new CarregaTabelas();
        DefaultTableModel model = ct.PreencheTabela(titulo, tabela);
              
        total = 0;
        tabelaEspecialidade.setModel(model);
        try {
            tabela.beforeFirst();
            
            while(tabela.next())
            {
                total++;
            }
            
            tabela.first();
        } catch (SQLException ex) {
            Logger.getLogger(Especialidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public Especialidade() {
        initComponents();
        preencheTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEspecialidade = new javax.swing.JTable();
        txtEspecialidade = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        bntInserir = new javax.swing.JButton();
        bntAlterar = new javax.swing.JButton();
        bntEscluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Especialidade Médica");

        jLabel1.setText("Nome da Especialidade Médica: ");

        jLabel2.setText("Pesquisa: ");

        txtPesquisa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtPesquisaCaretUpdate(evt);
            }
        });
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        tabelaEspecialidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaEspecialidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEspecialidadeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaEspecialidade);

        txtEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadeActionPerformed(evt);
            }
        });
        txtEspecialidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEspecialidadeKeyReleased(evt);
            }
        });

        jToolBar1.setRollover(true);

        bntInserir.setText("Inserir");
        bntInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInserirActionPerformed(evt);
            }
        });
        jToolBar1.add(bntInserir);

        bntAlterar.setText("Alterar");
        bntAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(bntAlterar);

        bntEscluir.setText("Excluir");
        bntEscluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEscluirActionPerformed(evt);
            }
        });
        jToolBar1.add(bntEscluir);

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa))
                    .addComponent(txtEspecialidade)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInserirActionPerformed
        M_Especialidade me = new M_Especialidade();
        me.setNome(txtEspecialidade.getText());
        
        
        C_Especialidade ce = new C_Especialidade();
        ce.inserirSql((Object)me);
        preencheTabela();
        
    }//GEN-LAST:event_bntInserirActionPerformed
    int id_especialidade;
    String nome;
    
    private void tabelaEspecialidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEspecialidadeMouseClicked
        int linha = tabelaEspecialidade.getSelectedRow();
       id_especialidade = Integer.parseInt(tabelaEspecialidade.getValueAt(linha, 0).toString());
       nome = tabelaEspecialidade.getValueAt(linha, 1).toString();
       
       txtEspecialidade.setText(nome);
       
    }//GEN-LAST:event_tabelaEspecialidadeMouseClicked

    private void txtPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisaCaretUpdate
        preencheTabela();
    }//GEN-LAST:event_txtPesquisaCaretUpdate

    private void bntEscluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEscluirActionPerformed
        M_Especialidade me = new M_Especialidade();
       int resposta = JOptionPane.showConfirmDialog(null,"Confirma a exclusão", "Exclusão",JOptionPane.YES_NO_OPTION);
        if(resposta == 0){
        me.setId_especialidade(id_especialidade);       
        C_Especialidade ce = new C_Especialidade();
        ce.excluiSql((Object)me);
        }
        preencheTabela();
        tabelaEspecialidade.setRowSelectionInterval(linha, 0);
    }//GEN-LAST:event_bntEscluirActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
       
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadeActionPerformed
        
    }//GEN-LAST:event_txtEspecialidadeActionPerformed

    private void txtEspecialidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadeKeyReleased
        String temp = txtEspecialidade.getText();
        txtEspecialidade.setText(temp.toUpperCase());
    }//GEN-LAST:event_txtEspecialidadeKeyReleased

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        String temp = txtPesquisa.getText();
        txtPesquisa.setText(temp.toUpperCase());
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Especialidade().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAlterarActionPerformed
        M_Especialidade me = new M_Especialidade();
        me.setId_especialidade(id_especialidade);
        me.setNome(txtEspecialidade.getText());
        
        C_Especialidade ce = new C_Especialidade();
        ce.alterarSql((Object)me);
        
        preencheTabela();
        tabelaEspecialidade.setRowSelectionInterval(linha, 0);
    }//GEN-LAST:event_bntAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(Especialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Especialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Especialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Especialidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Especialidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAlterar;
    private javax.swing.JButton bntEscluir;
    private javax.swing.JButton bntInserir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabelaEspecialidade;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}