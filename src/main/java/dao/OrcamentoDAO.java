/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Orcamento;

/**
 *
 * @author Norb7492
 */
public interface OrcamentoDAO {
 
    
    public void cadastrarOrcamento(String idPedido, Orcamento o);
    
    public ArrayList listarOrcamento(String idPedido);
    
}
