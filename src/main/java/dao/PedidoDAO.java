/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Pedido;

/**
 *
 * @author Norb7492
 */
public interface PedidoDAO {
    
    
    public void inserirPedido(Pedido p, long idCliente);
    
}
