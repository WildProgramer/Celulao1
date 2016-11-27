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
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public interface OrcamentoDAO {
 
    
    public void cadastrarOrcamento(String idPedido, Orcamento o);
    
    public ArrayList listarOrcamento(String idPedido);
            
    public ArrayList listarOrcamentoPeloCliente(String idCliente);
    
    public void autorizarOrcamento(String idOrcamento);
            
    public void pagamentoEfetuado(String idOrcamento);        
    
}
