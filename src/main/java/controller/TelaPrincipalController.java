/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCClienteDAO;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import sqlite.SqliteUsuariosAdapter;

/**
 *
 * @author Norb7492
 */
public class TelaPrincipalController {

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
    
    public void listaClientes(JTable jTable1){
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();
        ArrayList<Cliente> clienteArray;
        clienteArray = clienteDAO.listarClientes();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        
        for(int i = 0; i <clienteArray.size(); i++){
            
            rowData[0] = clienteArray.get(i).getIdCliente();
            rowData[1] = clienteArray.get(i).getNome();
            rowData[2] = clienteArray.get(i).getTipo();
            rowData[3] = clienteArray.get(i).getCelular();
            model.addRow(rowData);
            
        }
        
        
        
        
    }

}
