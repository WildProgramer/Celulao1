/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import model.Strings;

/**
 *
 * @author Norb7492
 */
public class ConnectionFactory {
    
    public static Connection getConnection(){
        try{
//            TimeZone timeZone = TimeZone.getTimeZone("South_America/Brazil"); // 
//            TimeZone.setDefault(timeZone);
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/celulao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, Strings.bancoNaoEncontrado);
            System.out.println(ex);
            
    }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, Strings.classeJdbc);
        
    }
        return null;
     
        
        
        
    }
    
}
