/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import helper.JDBCQueryHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Strings;
import model.Usuario;

/**
 *
 * @author Norb7492
 */
public class JDBCFuncionarioDAO implements FuncionarioDAO{

    private Connection connection;
    
    //Variaveis para salvar os id das insert
    private int idPessoa;
    private int idData;
    private int idCargo;
    private int idFuncionario;
    
    public JDBCFuncionarioDAO(){
        connection = ConnectionFactory.getConnection();
        
    }
        //Query helper é uma classe que ajuda a verificar dados já existentes e os ids gerados
    private JDBCQueryHelper queryHelper = new JDBCQueryHelper();
        
  
    
    @Override
    public synchronized void inserirFuncionario(Usuario f) {
        
       //Verifica se nome de usuario já existe
       try{
       if(queryHelper.verificaSeExiste(connection, "idUsuario", "usuario", "usuario", f.getUsuario()) ==0 ){
       
       
       
        try {
         
         //Inserir dados do funcionario na tabela pessoa   
        String Pessoa = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                + "(?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(Pessoa,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, f.getNome());
            ps.setInt(2, f.getCpf());
            ps.setInt(3, 0);
            ps.setString(4, f.getEndereco());
            
        
            ps.executeUpdate();
          
            
            idPessoa = queryHelper.getLastId(ps);
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
            
            
            
       try{     
        //Inserir data de admissão do funcionário na tabela data
        idData = queryHelper.verificaSeExiste(connection, "idData", "data", "date", f.getDataAdmissao());
        System.out.println(idData);
        
        if(idData == 0){
        String DataAdmissao = "INSERT INTO data (date) VALUES "
                + "(?)";  
     
        PreparedStatement ps;
        ps = connection.prepareStatement(DataAdmissao, Statement.RETURN_GENERATED_KEYS);
        ps.setDate(1, Date.valueOf(f.getDataAdmissao()));
        ps.executeUpdate();
        
        idData = queryHelper.getLastId(ps);
        ps.close();
        }
        
       }catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       //Inserir Cargo
        try{
           

        
        idCargo = queryHelper.verificaSeExiste(connection,"idCargo", "cargo", "cargo", f.getCargo());
        
        PreparedStatement ps;
        if(idCargo == 0){
        
             String InsereCargo = "INSERT INTO cargo (cargo) VALUES "
                + "(?)";
         
              ps = connection.prepareStatement(InsereCargo, Statement.RETURN_GENERATED_KEYS);
              ps.setString(1, f.getCargo());
              ps.executeUpdate();
              idCargo = queryHelper.getLastId(ps);
              System.out.println(idCargo);
              ps.close();
             
        }
        

        } catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Inserir Funcionário
        
        try{
            
            String Funcionario = "INSERT INTO funcionario (data_idData, pessoa_idPessoa, cargo_idCargo, matricula) VALUES "
                + "(?,?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(Funcionario,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idData);
            ps.setInt(2, idPessoa);
            ps.setInt(3, idCargo);
            ps.setInt(4, f.getMatricula());
            
        
            ps.executeUpdate();
          
            
            idFuncionario = queryHelper.getLastId(ps);
            ps.close();
            
        }
        
        catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Inserir Usuario
        try{
            
            String Usuario = "INSERT INTO usuario (funcionario_idFuncionario,usuario,senha) VALUES "
                + "(?,?,?)";
            PreparedStatement ps;
            ps = connection.prepareStatement(Usuario,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idFuncionario);
            ps.setString(2, f.getUsuario());
            ps.setString(3, f.getSenha());
       
            
        
            ps.executeUpdate();
          
            

            ps.close();
            
            
        }catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }else{
          
           JOptionPane.showMessageDialog(null, Strings.usuarioExistente);
           
       }}catch (SQLException ex) {
            Logger.getLogger(JDBCFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    @Override
    public void selecionarFuncionario(String nome) {
    
    }
}
