/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import model.Cliente;



/**
 *
 * @author Norb7492
 */
public interface ClienteDAO {
    
    public void inserirFuncionario(Cliente c);
    
    public ArrayList listarClientes();
    
    
}
