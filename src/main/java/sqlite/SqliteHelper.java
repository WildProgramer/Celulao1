/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norb7492
 */
public class SqliteHelper {

    private static Statement stmt = null;
    public static Connection connection = null;

    public static Connection Connector() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:celulao.db");
            System.out.println("Connection maded");
            return connection;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {

//            try {
////                connection.close();
//            } catch (SQLException ex) {
//
//            }
        }

    }
    
    public static void criarTabelaUsuario(){
        
        
        try {
            stmt = Connector().createStatement();
            
            stmt.execute(ConstansUsuario.criarTablea());
            
            System.out.println("Tabela Criada");
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }finally{
            
            try {
                stmt.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqliteHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
}

}