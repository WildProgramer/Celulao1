/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
//Classe que ajuda a inserir dados, e buscar dados no sqlite
public class SqliteUsuariosAdapter{
    
    public PreparedStatement stmt = null;
    public ResultSet rs = null;  
    public Connection connection = SqliteHelper.Connector();
    
    public void inserirUsuario(String usuario,String cargo){
        
        try {
            
             String sql = "INSERT INTO usuario (usuario,cargo) " +
            "VALUES (?,?);"; 
              stmt = connection.prepareStatement(sql);
              
              
       
              stmt.setString(1, usuario);
              stmt.setString(2, cargo);
           
              
              stmt.executeUpdate();
         
              
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            
            try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
               
            }
        }
        
    }
    
    public boolean  usuarioIsEmpty() {

        boolean flag;
        String quString = "select exists(select 1 from " + ConstantsUsuario.getTABELA()  + ");";

       
       
        int count = 0;
        
        try {
            stmt = connection.prepareStatement(quString);
            rs = stmt.executeQuery();
            
          if (rs.next()) {
                boolean found = rs.getBoolean(1); // "found" column
                if (found) {
                    count = 1;
                } else {
                   count = 0;
                }
            }
        
        } catch (SQLException ex) {
            count = 0;
               
        }finally{
            try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
           
            }
            
            
            
        }
        
        
        if (count ==1) {
            flag =  false;
        } else {
            flag = true;
        }
  
     

        return flag;
    }
    
    public String buscarUsuario(){
        String sql = "SELECT usuario, cargo FROM usuario";
        String cargo = "";
        
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
              while (rs.next()) {
                cargo = rs.getString("cargo");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }catch (NullPointerException ex){

            System.out.println("Esta nulo");
        }finally{
            
              try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
           
            }
            
        }
            
        return cargo;
    }
    
    
    public void deletarTudoDaTabela(){
        PreparedStatement deletarStmt = null;
        PreparedStatement zerarStmt = null;
     
        
        
        
        
            String deletar = "DELETE FROM usuario";
            String zerarId = "DELETE FROM sqlite_sequence where name= '" + ConstantsUsuario.getTABELA() + "';";
            
         try {
//            deletarStmt = connection.prepareStatement(deletar);
            stmt = connection.prepareStatement(deletar);
//            zerarStmt = connection.prepareStatement(zerarId);
              stmt.executeUpdate();
//            zerarStmt.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            
              try {
                   stmt.close();
//                deletarStmt.close();
//                zerarStmt.close();
                connection.close();
            } catch (SQLException ex) {
           
            }
            
        }
        
    }
    
}
