/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.Pedido;

/**
 *
 * @author Norb7492
 */
public interface PedidoDAO {
    
    
    public void inserirPedido(Pedido p);
    public void mostrarPedido(String id, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane);
}
