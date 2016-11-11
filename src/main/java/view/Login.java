/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConversorDeDadosController;
import dao.JDBCFuncionarioDAO;
import factory.ConnectionFactory;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import model.Strings;
import model.Usuario;
import sqlite.SqliteHelper;
import sqlite.SqliteUsuariosAdapter;

/**
 *
 * @author Norb7492
 */
public class Login extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal = new TelaPrincipal();
    private Usuario funcionario = new Usuario();
    private Usuario funcionario2 = new Usuario();
    private ConversorDeDadosController dadosController = new ConversorDeDadosController();
    private JDBCFuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO();
    private SqliteUsuariosAdapter sqliteUsuariosAdapter = new SqliteUsuariosAdapter();

    /**
     * Creates new form Login
     */
    public Login() {
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLoginPanel = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        usuarioLoginTextField = new javax.swing.JTextField();
        entrarBtn = new javax.swing.JButton();
        cadastrarBtn = new javax.swing.JButton();
        nomeLabel1 = new javax.swing.JLabel();
        senhaLoginTextField = new javax.swing.JPasswordField();
        jCadastrarPanel = new javax.swing.JPanel();
        voltarBtn = new javax.swing.JButton();
        cadastroNomeLabel = new javax.swing.JLabel();
        cadastraCpfLabel = new javax.swing.JLabel();
        cadastraEnderecoLabel = new javax.swing.JLabel();
        cadastraCargoBox = new javax.swing.JComboBox<>();
        cadastraCargoLabel = new javax.swing.JLabel();
        cadastraMatriculaLabel = new javax.swing.JLabel();
        cadastraDataAdmissaoLabel = new javax.swing.JLabel();
        cadastraNomeTextField = new javax.swing.JTextField();
        cadastraEnderecoTextField = new javax.swing.JTextField();
        cadastraMatriculaTextField = new javax.swing.JTextField();
        cadastrarFBtn = new javax.swing.JButton();
        cadastraUsuarioLabe = new javax.swing.JLabel();
        cadastraSenhaLabel = new javax.swing.JLabel();
        cadastraUsuarioTextField = new javax.swing.JTextField();
        cadastraSenhaTextField = new javax.swing.JTextField();
        cadastraCpfTextField = new javax.swing.JFormattedTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        nomeLabel.setText("Usuário:");

        entrarBtn.setText("Entrar");
        entrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarBtnActionPerformed(evt);
            }
        });

        cadastrarBtn.setText("Cadastrar");
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });

        nomeLabel1.setText("Senha:");

        senhaLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaLoginTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLoginPanelLayout = new javax.swing.GroupLayout(jLoginPanel);
        jLoginPanel.setLayout(jLoginPanelLayout);
        jLoginPanelLayout.setHorizontalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeLabel)
                    .addComponent(nomeLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLoginPanelLayout.createSequentialGroup()
                        .addComponent(entrarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrarBtn))
                    .addComponent(usuarioLoginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(senhaLoginTextField))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jLoginPanelLayout.setVerticalGroup(
            jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(usuarioLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel1)
                    .addComponent(senhaLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrarBtn)
                    .addComponent(cadastrarBtn))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jPanel1.add(jLoginPanel, "login");

        voltarBtn.setText("Voltar");
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
            }
        });

        cadastroNomeLabel.setText("Nome:");

        cadastraCpfLabel.setText("Cpf:");

        cadastraEnderecoLabel.setText("Endereco:");

        cadastraCargoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Técnico" }));
        cadastraCargoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraCargoBoxActionPerformed(evt);
            }
        });

        cadastraCargoLabel.setText("Cargo:");

        cadastraMatriculaLabel.setText("Matrícula:");

        cadastraDataAdmissaoLabel.setText("Data Admissão:");

        cadastraMatriculaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraMatriculaTextFieldActionPerformed(evt);
            }
        });
        cadastraMatriculaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cadastraMatriculaTextFieldKeyTyped(evt);
            }
        });

        cadastrarFBtn.setText("Cadastrar");
        cadastrarFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFBtnActionPerformed(evt);
            }
        });

        cadastraUsuarioLabe.setText("Usuário:");

        cadastraSenhaLabel.setText("Senha:");

        cadastraUsuarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraUsuarioTextFieldActionPerformed(evt);
            }
        });

        cadastraSenhaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraSenhaTextFieldActionPerformed(evt);
            }
        });

        try {
            cadastraCpfTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cadastraCpfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastraCpfTextFieldActionPerformed(evt);
            }
        });

        dateChooser.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jCadastrarPanelLayout = new javax.swing.GroupLayout(jCadastrarPanel);
        jCadastrarPanel.setLayout(jCadastrarPanelLayout);
        jCadastrarPanelLayout.setHorizontalGroup(
            jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCadastrarPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCadastrarPanelLayout.createSequentialGroup()
                        .addComponent(cadastrarFBtn)
                        .addGap(18, 18, 18)
                        .addComponent(voltarBtn)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCadastrarPanelLayout.createSequentialGroup()
                        .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastraDataAdmissaoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraMatriculaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraEnderecoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraCpfLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastroNomeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraCargoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraUsuarioLabe, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cadastraSenhaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(29, 29, 29)
                        .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadastraNomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cadastraEnderecoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cadastraMatriculaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cadastraUsuarioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cadastraSenhaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(cadastraCargoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastraCpfTextField)
                            .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78))))
        );
        jCadastrarPanelLayout.setVerticalGroup(
            jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCadastrarPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroNomeLabel)
                    .addComponent(cadastraNomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraCpfLabel)
                    .addComponent(cadastraCpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraEnderecoLabel)
                    .addComponent(cadastraEnderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraCargoLabel)
                    .addComponent(cadastraCargoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraMatriculaLabel)
                    .addComponent(cadastraMatriculaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastraDataAdmissaoLabel)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraUsuarioLabe)
                    .addComponent(cadastraUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastraSenhaLabel)
                    .addComponent(cadastraSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jCadastrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarFBtn)
                    .addComponent(voltarBtn))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jCadastrarPanel, "cadastrar");

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

    private void entrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarBtnActionPerformed
        
        boolean validado = false;
        if(usuarioLoginTextField.getText().isEmpty() || senhaLoginTextField.getText().isEmpty()){
                    
                    
                    JOptionPane.showMessageDialog(null, Strings.inserir);
                }else{
                    
                
                funcionario2.setUsuario(usuarioLoginTextField.getText());
                funcionario2.setSenha(senhaLoginTextField.getText());
               validado =  funcionarioDAO.selecionarFuncionario(funcionario2);
                
                if(validado == true){
                    
                    telaPrincipal.setVisible(true);
                    this.setVisible(false);
                }
                    
                    
                }

    
//        funcionario2.setUsuario("norb7492");
//        sqliteUsuariosAdapter.inserirUsuario(funcionario2);
    }//GEN-LAST:event_entrarBtnActionPerformed

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtnActionPerformed
        CardLayout cl = (CardLayout) jPanel1.getLayout();
        cl.show(jPanel1, "cadastrar");

    }//GEN-LAST:event_cadastrarBtnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        CardLayout cl = (CardLayout) jPanel1.getLayout();
        cl.show(jPanel1, "login");
    }//GEN-LAST:event_voltarBtnActionPerformed

    private void cadastraCargoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraCargoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraCargoBoxActionPerformed

    private void cadastrarFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFBtnActionPerformed

        try {

            String nome = cadastraNomeTextField.getText();
            long cpf = dadosController.converterCpf(cadastraCpfTextField);
            String endereco = cadastraEnderecoTextField.getText();
            String data = dadosController.converterData(dateChooser);
            String cargo = String.valueOf(cadastraCargoBox.getSelectedItem());
            int matricula = Integer.valueOf(cadastraMatriculaTextField.getText());
            String usuario = cadastraUsuarioTextField.getText();
            String senha = cadastraSenhaTextField.getText();
            if (nome.trim().isEmpty() || String.valueOf(cpf).isEmpty()
                    || endereco.isEmpty() || data.isEmpty() || cargo.isEmpty()
                    || String.valueOf(matricula).isEmpty() || usuario.isEmpty() || senha.isEmpty()) {

                JOptionPane.showMessageDialog(null, Strings.preecherCampos);

            } else {

                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setEndereco(endereco);
                funcionario.setDataAdmissao(data);
                funcionario.setCargo(cargo);
                funcionario.setMatricula(matricula);
                funcionario.setUsuario(usuario);
                funcionario.setSenha(senha);
                funcionarioDAO.inserirFuncionario(funcionario);
            }
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null, Strings.dataErrada);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, Strings.preecherCampos);
        }


    }//GEN-LAST:event_cadastrarFBtnActionPerformed

    private void cadastraUsuarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraUsuarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraUsuarioTextFieldActionPerformed

    private void cadastraSenhaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraSenhaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraSenhaTextFieldActionPerformed

    private void cadastraMatriculaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraMatriculaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraMatriculaTextFieldActionPerformed

    private void cadastraCpfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastraCpfTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastraCpfTextFieldActionPerformed

    private void cadastraMatriculaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cadastraMatriculaTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();

        }

        if (cadastraMatriculaTextField.getText().length() >= 6) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_cadastraMatriculaTextFieldKeyTyped

    private void senhaLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaLoginTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                System.out.println("Rodou aqui ja");
                SqliteHelper.criarTabelaUsuario();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cadastraCargoBox;
    private javax.swing.JLabel cadastraCargoLabel;
    private javax.swing.JLabel cadastraCpfLabel;
    private javax.swing.JFormattedTextField cadastraCpfTextField;
    private javax.swing.JLabel cadastraDataAdmissaoLabel;
    private javax.swing.JLabel cadastraEnderecoLabel;
    private javax.swing.JTextField cadastraEnderecoTextField;
    private javax.swing.JLabel cadastraMatriculaLabel;
    private javax.swing.JTextField cadastraMatriculaTextField;
    private javax.swing.JTextField cadastraNomeTextField;
    private javax.swing.JLabel cadastraSenhaLabel;
    private javax.swing.JTextField cadastraSenhaTextField;
    private javax.swing.JLabel cadastraUsuarioLabe;
    private javax.swing.JTextField cadastraUsuarioTextField;
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JButton cadastrarFBtn;
    private javax.swing.JLabel cadastroNomeLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton entrarBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jCadastrarPanel;
    private javax.swing.JPanel jLoginPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel nomeLabel1;
    private javax.swing.JPasswordField senhaLoginTextField;
    private javax.swing.JTextField usuarioLoginTextField;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables
}
