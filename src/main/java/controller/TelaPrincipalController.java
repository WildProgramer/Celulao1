/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCClienteDAO;
import dao.JDBCOrcamentoDAO;
import dao.JDBCPedidoDAO;
import helper.ConverterStatusStringHelper;
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
import model.Orcamento;
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
    public void listaClientes(JTable jTableClientes) {
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
        ArrayList<Cliente> clienteArray;
        clienteArray = clienteDAO.listarClientes();
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < clienteArray.size(); i++) {

            rowData[0] = clienteArray.get(i).getIdCliente();
            rowData[1] = clienteArray.get(i).getNome();
            rowData[2] = clienteArray.get(i).getTipo();
            rowData[3] = clienteArray.get(i).getCelular();
            model.addRow(rowData);

        }

    }
    
        //Este método lista todos os pedidos em um Jtable
       public void listarPedidos(JTable jTablePedidos){
        
        
        JDBCPedidoDAO pedidoDAO = new JDBCPedidoDAO();
        ArrayList<Pedido> pedidoArray;
        pedidoArray = pedidoDAO.listarPedidos();
        DefaultTableModel model = (DefaultTableModel) jTablePedidos.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < pedidoArray.size(); i++) {

            rowData[0] = pedidoArray.get(i).getIdPedido();
            rowData[1] = pedidoArray.get(i).getNome();
            rowData[2] = pedidoArray.get(i).getCelular();
            model.addRow(rowData);

        }

    }
       
       
       //Este método lista todos os orçamentos de um pedido em um Jtable
       public void listarOrcamentos(String idPedido, JTable jTableOrcamentos){
        
        
        JDBCOrcamentoDAO orcamentoDAO = new JDBCOrcamentoDAO();
        ArrayList<Orcamento> orcamentoArray;
        orcamentoArray = orcamentoDAO.listarOrcamento(idPedido);
        DefaultTableModel model = (DefaultTableModel) jTableOrcamentos.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < orcamentoArray.size(); i++) {

            rowData[0] = orcamentoArray.get(i).getIdOrcamento();
            rowData[1] = orcamentoArray.get(i).getPrecoTotal();
            
            String autoriza = ConverterStatusStringHelper.converterStatusParaString(orcamentoArray.get(i).getAutoriza());
            String paga = ConverterStatusStringHelper.converterStatusParaString(orcamentoArray.get(i).getStatusPagamento());
            rowData[2] = autoriza;
            rowData[3] = paga;
            model.addRow(rowData);

        }

    }

    //Este método, busca o cliente que foi selecionado no Jpanel, e faz um select do pedido, se não tiver pedido cadastrado, 
    //será possivel fazer o do mesmo
    public void mostrarClienteParaCadastrarPedido(String id, JLabel idLabel, JLabel nomeLabel) {
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
        clienteDAO.mostrarClienteParaCadastrarPedido(id, idLabel, nomeLabel);

    }

  
    
    //Mostrar pedido nos dados se existente
       public void mostrarPedidoQuandoSelecionado(String id, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane) {
           
           JDBCPedidoDAO jDBCPedidoDAO = new JDBCPedidoDAO();
           
           
           jDBCPedidoDAO.mostrarPedido(id, jMarcaTextField, jSerieFormatedText, jobservacaoTextPane);
            
            
        
    }
       
      //Retorna o id da row do jtable 
      public String retornarIdJTable(JTable jTable){
          
        int column = 0;
        int row = jTable.getSelectedRow();
        String value = jTable.getModel().getValueAt(row, column).toString();
        
        return value;
      } 
       
     //Deletar usuario do sqlite
       public void deletarUsuarioSqlite(){
           SqliteUsuariosAdapter sqliteUsuario = new SqliteUsuariosAdapter();
           sqliteUsuario.deletarTudoDaTabela();
          
           
           
       }

}
