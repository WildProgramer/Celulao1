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
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Strings;
import model.Usuario;
import sqlite.SqliteUsuariosAdapter;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class JDBCFuncionarioDAO implements FuncionarioDAO{

    private Connection connection;
    
    //Variaveis para salvar os id das insert
    private int idPessoa;
    private int idData;
    private int idCargo;
    private int idFuncionario;

    public JDBCFuncionarioDAO() {
        connection = ConnectionFactory.getConnection();
    }
    
  
    
    
        //Query helper é uma classe que ajuda a verificar dados já existentes e os ids gerados
    private JDBCQueryHelper queryHelper = new JDBCQueryHelper();
        
  
    
    @Override
    public synchronized void inserirFuncionario(Usuario f) {
        
       
            
            PreparedStatement insertPessoa = null;
            PreparedStatement insertDataAdmissao = null;
            PreparedStatement inserirCargo = null;
            PreparedStatement insertFuncionario = null;
            PreparedStatement insertUsuario = null;
       
  
       
    
     
         try{
             connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);
            if(queryHelper.verificaSeExiste(connection, "idUsuario", "usuario", "usuario", f.getUsuario()) ==0 ){
         //Inserir dados do funcionario na tabela pessoa   
        String inserirPessoaQuery = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                + "(?,?,?,?)";
            
          
            
            insertPessoa = connection.prepareStatement(inserirPessoaQuery,Statement.RETURN_GENERATED_KEYS);
            insertPessoa.setString(1, f.getNome());
            insertPessoa.setLong(2, f.getCpf());
            insertPessoa.setInt(3, 0);
            insertPessoa.setString(4, f.getEndereco());
            
        
            insertPessoa.executeUpdate();
            idPessoa = queryHelper.getLastId(insertPessoa);
            
            
            
             //Inserir data de admissão do funcionário na tabela data----------------------
        idData = queryHelper.verificaSeExiste(connection, "idData", "data", "date", f.getDataAdmissao());
        System.out.println(idData);
        
        if(idData == 0){
        String inserirDataAdmissaoQuery = "INSERT INTO data (date) VALUES "
                + "(?)";  
     
        
        insertDataAdmissao = connection.prepareStatement(inserirDataAdmissaoQuery, Statement.RETURN_GENERATED_KEYS);
        insertDataAdmissao.setDate(1, Date.valueOf(f.getDataAdmissao()));
        insertDataAdmissao.executeUpdate();
        
        idData = queryHelper.getLastId(insertDataAdmissao);
       
            
        }
           //Inserir Cargo---------------------------------------------
  
        idCargo = queryHelper.verificaSeExiste(connection,"idCargo", "cargo", "cargo", f.getCargo());
        
        
        if(idCargo == 0){
        
             String inserirCargoQuery = "INSERT INTO cargo (cargo) VALUES "
                + "(?)";
         
              inserirCargo = connection.prepareStatement(inserirCargoQuery, Statement.RETURN_GENERATED_KEYS);
              inserirCargo.setString(1, f.getCargo());
              inserirCargo.executeUpdate();
              idCargo = queryHelper.getLastId(inserirCargo);
              System.out.println(idCargo);
              
              
             
        }
        
         
        //Inserir Funcionário--------------------------------
      
            
            String inserirFuncionarioQuery = "INSERT INTO funcionario (data_idData, pessoa_idPessoa, cargo_idCargo, matricula) VALUES "
                + "(?,?,?,?)";
            
            insertFuncionario = connection.prepareStatement(inserirFuncionarioQuery,Statement.RETURN_GENERATED_KEYS);
            insertFuncionario.setInt(1, idData);
            insertFuncionario.setInt(2, idPessoa);
            insertFuncionario.setInt(3, idCargo);
            insertFuncionario.setInt(4, f.getMatricula());
            
        
            insertFuncionario.executeUpdate();
          
            
            idFuncionario = queryHelper.getLastId(insertFuncionario);
            
    
            //Inserir Usuario----------------------
            
               String inserirUsuarioQuery = "INSERT INTO usuario (funcionario_idFuncionario,usuario,senha) VALUES "
                + "(?,?,?)";
            
            insertUsuario = connection.prepareStatement(inserirUsuarioQuery,Statement.RETURN_GENERATED_KEYS);
            insertUsuario.setInt(1, idFuncionario);
            insertUsuario.setString(2, f.getUsuario());
            insertUsuario.setString(3, f.getSenha());
            insertUsuario.executeUpdate();
          
            

            
            
            connection.commit();
            JOptionPane.showMessageDialog(null, Strings.cadastrado);
        
            
            }else{
            
            JOptionPane.showMessageDialog(null, Strings.usuarioExistente);
        }
        
        }catch (SQLException ex) {
            
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    JOptionPane.showMessageDialog(null, Strings.erroExecutar);
                }
            System.out.println(ex.getMessage());
        
         
           
        }finally{
            try{
            
            insertPessoa.close();
            insertDataAdmissao.close();
            inserirCargo.close();
            insertFuncionario.close();
            insertUsuario.close();
             
            }catch(SQLException ex){
                
            }catch(NullPointerException ex){
                
                
            }
       }
       
         
     
       
       
   
        
     
    }
    @Override
    public boolean selecionarFuncionario(Usuario u) {
        
        PreparedStatement getUsuario = null;
        ResultSet rs;
        
         String buscarUsuarioQuery = "SELECT usuario.usuario, cargo.cargo\n"
                + "FROM usuario\n"
                + "INNER JOIN funcionario\n"
                + "ON usuario.funcionario_idFuncionario = funcionario.idFuncionario\n"
                + "INNER JOIN cargo\n"
                + "ON funcionario.cargo_idCargo = cargo.idCargo\n"
                + "WHERE usuario.usuario = ? and usuario.senha = ?";
        
        try{
            
            getUsuario = connection.prepareStatement(buscarUsuarioQuery);
            getUsuario.setString(1, u.getUsuario());
            getUsuario.setString(2, u.getSenha());
            rs = getUsuario.executeQuery();
            if(rs.next()){
                SqliteUsuariosAdapter  adapter = new SqliteUsuariosAdapter();
                        
                       adapter.inserirUsuario(rs.getString("usuario"), rs.getString("cargo")); 
                    
                       return true;
                
            }else{
                
                JOptionPane.showMessageDialog(null, Strings.naoExiste);
                return false;
                
            }
            
            
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, Strings.erroExecutar);
             return false;
        }finally{
            try {
                
                getUsuario.close();
            } catch (SQLException ex) {
               
            }
            
        }
        
        
    }
    
    
 
    
    
    
    
    
        }
