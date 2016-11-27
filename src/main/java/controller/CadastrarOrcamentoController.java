/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCOrcamentoDAO;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Orcamento;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */

public class CadastrarOrcamentoController {
    
    
    
    
    
    
    public void cadastrarOrcamento(String idPedido,JTextField jValorPecaTextField, JTextField jValorServicoTextField){
        
        JDBCOrcamentoDAO orcamentoDAO = new JDBCOrcamentoDAO();
        
        
        try {
             Orcamento orcamento = new Orcamento();

            double valorPeca = Double.valueOf(jValorPecaTextField.getText());
            double valorServico = Double.valueOf(jValorServicoTextField.getText());
            
            orcamento.setValorPeca(valorPeca);
            orcamento.setValorServico(valorServico);
            orcamentoDAO.cadastrarOrcamento(idPedido,orcamento);
            
        } catch (NullPointerException e) {
            
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, Strings.preecherCampos);
            
        }catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, Strings.valoresCorretos);
            
        }
        
        
    }
    
    
    
}
