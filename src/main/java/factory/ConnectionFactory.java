/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */

//Classe para conexão de banco de dados, tem um método estatico que serve como construtor para abrir a conexão com banco de dados
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
            return null;
            
    }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, Strings.classeJdbc);
            return null;
        
    }
        
     
        
        
        
    }
    
}
