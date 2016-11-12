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
 * @author Norb7492
 */
public class CadastrarClienteController {

    public String escolherBosItem(JComboBox<String> jTipoBox) {

        String itemSelecionado = String.valueOf(jTipoBox.getSelectedItem());

        System.out.println(itemSelecionado);

        return itemSelecionado;
    }

    public void cadastrarClienteFisico(JTextField jnomeClienteTexField,
            JFormattedTextField jcpfFormattedTextField, JTextField jEnderecoTextField)  {
        Cliente c = new Cliente();
        ConversorDeDadosController dadosController = new ConversorDeDadosController();
        JDBCClienteDAO clienteDAO = new JDBCClienteDAO();

        try {
            c.setNome(jnomeClienteTexField.getText());
            c.setTipo("Físico");
            c.setCpf(dadosController.converterCpf(jcpfFormattedTextField));
            c.setEndereco(jEnderecoTextField.getText());
          
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);

        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, Strings.preecherCampos);

            
        }
        
   
         if (c.getNome().isEmpty() || c.getTipo().isEmpty() ||  c.getEndereco().isEmpty() || c.getCpf() ==0){
             
             
             JOptionPane.showMessageDialog(null, Strings.preecherCampos);
             
         }else{
             
             clienteDAO.inserirFuncionario(c);
         }
            
            
        }
      
          
    

}
