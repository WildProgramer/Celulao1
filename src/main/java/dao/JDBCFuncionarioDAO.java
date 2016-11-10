/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;

/**
 *
 * @author Norb7492
 */
public class JDBCFuncionarioDAO implements FuncionarioDAO{

    Connection connection;
    
    public JDBCFuncionarioDAO(){
        connection = ConnectionFactory.getConnection();
        
    }
    
    
    @Override
    public synchronized void inserirFuncionario(Funcionario f) {
        try {
        String Pessoa = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                + "(?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(Pessoa);
            ps.setString(1, f.getNome());
            ps.setInt(2, f.getCpf());
            ps.setInt(3, 0);
            ps.setString(4, f.getEndereco());
            
        
            ps.executeUpdate();
            ps.close();
            
            
            
            
            
            
        String DataAdmissao = "INSERT INTO data (date) VALUES "
                + "(?)";  
        ps = connection.prepareStatement(DataAdmissao);
        ps.setDate(1, Date.valueOf(f.getDataAdmissao()));
        ps.executeUpdate();
        ps.close();
            
            

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void selecionarFuncionario(String nome) {
    }
    
}
