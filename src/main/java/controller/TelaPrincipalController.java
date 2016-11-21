/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCClienteDAO;
import dao.JDBCPedidoDAO;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pedido;
import model.Strings;
import sqlite.SqliteUsuariosAdapter;

/**
 *
 * @author Norb7492
 */
//Esta classe ajuda nos demais na tela principal, como escolher qual tela entrar, e imprimir listas em um Jpanel
public class TelaPrincipalController {

    //Este método escolhe se vai ser chamada a tela do técnico, ou a tela do antendente
    public void escolherTela(JPanel jPanel1) {
        SqliteUsuariosAdapter usuariosAdapter = new SqliteUsuariosAdapter();
        String cargo;

        cargo = usuariosAdapter.buscarUsuario();
        System.out.println(cargo);

        if (cargo.equals("")) {

            System.out.println("está nulo");
        } else {
            if (cargo.equals("Atendente")) {

                CardLayout cl = (CardLayout) jPanel1.getLayout();
                cl.show(jPanel1, "atendente");
            } else {

                CardLayout cl = (CardLayout) jPanel1.getLayout();
                cl.show(jPanel1, "tecnico");
            }
        }
    }

    //Este método lista todos os clientes em um Jtable
    public void listaClientes(JTable jTable1) {
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
        ArrayList<Cliente> clienteArray;
        clienteArray = clienteDAO.listarClientes();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < clienteArray.size(); i++) {

            rowData[0] = clienteArray.get(i).getIdCliente();
            rowData[1] = clienteArray.get(i).getNome();
            rowData[2] = clienteArray.get(i).getTipo();
            rowData[3] = clienteArray.get(i).getCelular();
            model.addRow(rowData);

        }

    }

    //Este método, busca o cliente que foi selecionado no Jpanel, e faz um select do pedido, se não tiver pedido cadastrado, 
    //será possivel fazer o do mesmo
    public void mostrarClienteParaCadastrarPedido(String id, JLabel idLabel, JLabel nomeLabel) {
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
        clienteDAO.mostrarClienteParaCadastrarPedido(id, idLabel, nomeLabel);

    }

    //Este método cadastra o pedido
    public void cadastrarPedido(JLabel jIdClienteMostrarLabel, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane) {
            Pedido pedido = new Pedido();
            ConversorDeDadosController dadosController = new ConversorDeDadosController();
            JDBCPedidoDAO jDBCPedidoDAO = new JDBCPedidoDAO();
            
            
            try{
            if(jMarcaTextField.getText().isEmpty() ||  
                    jobservacaoTextPane.getText().isEmpty()){
                
                
                JOptionPane.showMessageDialog(null, Strings.preecherCampos);
                
            }else{
                
                  pedido.setIdCliente(Long.valueOf(jIdClienteMostrarLabel.getText()));
                  pedido.setMarca(jMarcaTextField.getText());
                  pedido.setSerie(dadosController.converterCpf(jSerieFormatedText));
                  pedido.setObservacao(jobservacaoTextPane.getText());
                  jDBCPedidoDAO.inserirPedido(pedido);
                 
                
                
            }
            }catch(NumberFormatException e){
                
                JOptionPane.showMessageDialog(null, Strings.preecherCampos);
                
            }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, Strings.preecherCampos);

            
        }
    }
    
    //Mostrar pedido nos dados se existente
       public void mostrarPedidoQuandoSelecionado(String id, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane) {
           
           JDBCPedidoDAO jDBCPedidoDAO = new JDBCPedidoDAO();
           
           
           jDBCPedidoDAO.mostrarPedido(id, jMarcaTextField, jSerieFormatedText, jobservacaoTextPane);
            
            
        
    }

}
