/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import javax.swing.JLabel;
import model.Cliente;



/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public interface ClienteDAO {
    
    public void inserirFuncionario(Cliente c);
    
    public ArrayList listarClientes();
    
    public void mostrarClienteParaCadastrarPedido(String id,JLabel idLabel, JLabel nomeLabel);
    
    
}
