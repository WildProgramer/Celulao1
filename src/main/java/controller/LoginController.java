/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import dao.JDBCFuncionarioDAO;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Strings;
import model.Usuario;
import sqlite.SqliteHelper;
import sqlite.SqliteUsuariosAdapter;
import view.Login;
import view.TelaPrincipal;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */

//Classe que faz o login do usuário e também cadastra usuário, como Técnico e Atendente
//Também é utilizado as classes do Sqlite onde é salvo o usuário depois de logado, para poder persistir o login
public class LoginController {

    
    //Método que cadastra o usuário no banco de dados, usando as classes do dao e classes do modelo
    public void cadastrarUsuario(JTextField cadastraNomeTextField, JFormattedTextField cadastraCpfTextField, JTextField cadastraEnderecoTextField,
            JDateChooser dateChooser, JComboBox<String> cadastraCargoBox, JTextField cadastraMatriculaTextField, JTextField cadastraUsuarioTextField,
            JTextField cadastraSenhaTextField) {  
        
        
          
        Usuario funcionario = new Usuario();
        ConversorDeDadosController dadosController = new ConversorDeDadosController();
        JDBCFuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO();

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

    }
    
    
    //Método que faz o login do usuário, automáticamente entrando na janela do técnico ou atendende
    public void fazerLoginUsuario(JTextField usuarioLoginTextField, JPasswordField senhaLoginTextField
      ){
        
        
        Usuario funcionario2 = new Usuario();
        JDBCFuncionarioDAO funcionarioDAO = new JDBCFuncionarioDAO();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        Login login = new Login();
        
        boolean validado = false;
        if (usuarioLoginTextField.getText().isEmpty() || senhaLoginTextField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, Strings.inserir);
        } else {

            funcionario2.setUsuario(usuarioLoginTextField.getText());
            funcionario2.setSenha(senhaLoginTextField.getText());
            validado = funcionarioDAO.selecionarFuncionario(funcionario2);

            if (validado == true) {

                telaPrincipal.setVisible(true);
                
                login.setVisible(false);
            }
        
        
    }
    }
    
    
    //Método que verifica se têm um usuário logado no Sqlite, se tiver ele entra com o ultimo usuário que fez login.
    public static void verificarUsuarioLogado(){
        
                SqliteHelper.criarTabelaUsuario();
                SqliteUsuariosAdapter sqliteUsuariosAdapter = new SqliteUsuariosAdapter();
                boolean usuarioIsEmpty = sqliteUsuariosAdapter.usuarioIsEmpty();
                if (usuarioIsEmpty == true) {
                   new Login().setVisible(true);

                } else {

                    TelaPrincipal telaPrincipal = new TelaPrincipal();
                    telaPrincipal.setVisible(true);
                    new Login().setVisible(false);

                }
        
        
    }

}
