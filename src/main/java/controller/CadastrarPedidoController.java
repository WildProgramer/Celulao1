/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCPedidoDAO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.Pedido;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class CadastrarPedidoController {
    
     //Este método cadastra o pedido
    public void cadastrarPedido(String idCliente, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane) {
            Pedido pedido = new Pedido();
            ConversorDeDadosController dadosController = new ConversorDeDadosController();
            JDBCPedidoDAO jDBCPedidoDAO = new JDBCPedidoDAO();
            
            
            try{
            if(jMarcaTextField.getText().isEmpty() ||  
                    jobservacaoTextPane.getText().isEmpty()){
                
                
                JOptionPane.showMessageDialog(null, Strings.preecherCampos);
                
            }else{
                
                  pedido.setIdCliente(Long.valueOf(idCliente));
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
    
    
}
