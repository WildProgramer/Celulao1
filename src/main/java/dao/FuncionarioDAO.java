/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Norb7492
 */
public interface FuncionarioDAO {
    public void inserirFuncionario(Usuario u);
    public void selecionarFuncionario(String nome);
    
    
}
