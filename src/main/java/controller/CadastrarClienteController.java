/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JDBCClienteDAO;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */

//Controller cliente, que une as classes do model com as classes do view
public class CadastrarClienteController {

    
    //Retorna o item que foi selecionado pela comboBox, se o cliente que vai ser inserido e jurídico ou físico
    public String escolherBosItem(JComboBox<String> jTipoBox) {

        String itemSelecionado = String.valueOf(jTipoBox.getSelectedItem());

        System.out.println(itemSelecionado);

        return itemSelecionado;
    }

    //Método que cadastra o cliente físico
    public void cadastrarClienteFisico(JTextField jnomeClienteTexField,
            JFormattedTextField jcpfFormattedTextField, JTextField jEnderecoTextField, JFormattedTextField jCelularTextField)  {
        Cliente c = new Cliente();
        ConversorDeDadosController dadosController = new ConversorDeDadosController();
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();

        try {
            c.setNome(jnomeClienteTexField.getText());
            c.setTipo("Físico");
            c.setCpf(dadosController.converterCpf(jcpfFormattedTextField));
            c.setCelular(dadosController.converterCpf(jCelularTextField));
            c.setEndereco(jEnderecoTextField.getText());
          
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);


        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, Strings.preecherCampos);

            
        }
        
   
         if (c.getNome().isEmpty() || c.getTipo().isEmpty() ||  c.getEndereco().isEmpty() || c.getCpf() ==0 || c.getCelular()==0){
             
             
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);
             
         }else{
             
             clienteDAO.inserirFuncionario(c);
             
             
             
         }
            
            
        }
      
        //Método que cadastra o cliente jurídico
      public void cadastrarClienteJuridico(JTextField jnomeClienteTexField,
            JFormattedTextField jcnpjFormattedTextField, JTextField jEnderecoTextField, JFormattedTextField jCelularTextField)  {
        Cliente c = new Cliente();
        ConversorDeDadosController dadosController = new ConversorDeDadosController();
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();

        try {
            c.setNome(jnomeClienteTexField.getText());
            c.setTipo("Jurídico");
            c.setCnpj(dadosController.converterCpf(jcnpjFormattedTextField));
            c.setCelular(dadosController.converterCpf(jCelularTextField));
            c.setEndereco(jEnderecoTextField.getText());
          
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);


        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, Strings.preecherCampos);

            
        }
        
   
         if (c.getNome().isEmpty() || c.getTipo().isEmpty() ||  c.getEndereco().isEmpty() || c.getCnpj()==0 || c.getCelular()==0){
             
             
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);
             
         }else{
             
             clienteDAO.inserirFuncionario(c);
             
             
             
         }
            
            
        }
          
    

}
