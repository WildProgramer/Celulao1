/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Norb7492
 */
public class SqliteUsuariosAdapter{
    
    public PreparedStatement stmt = null;
    public Connection connection = SqliteHelper.Connector();
    
    public void inserirUsuario(String usuario){
        
        try {
            
             String sql = "INSERT INTO usuario (usuario) " +
            "VALUES (?);"; 
              stmt = connection.prepareStatement(sql);
              
       
              stmt.setString(1, usuario);
           
              
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
    
}
