/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

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
public class JDBCQueryHelper {
  
    
    
    
      public int getLastId(PreparedStatement ps) throws SQLException{
          
            ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                {
                    return rs.getInt(1);
                    
                }else{
                    
                    return 0;
                }
      
       }
      
      public int verificaSeExiste(Connection connection, String nomeIdCampo, String nomeTabela, String 
              nomeOndeProcurar, String nomeProcurar) throws SQLException{
          
            PreparedStatement ps;
            String query = "SELECT " + nomeIdCampo + " FROM " +nomeTabela+ " WHERE " + nomeOndeProcurar+" = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, nomeProcurar);
        
            ResultSet rs = ps.executeQuery();
        
         while(rs.next()){
            
            return rs.getInt(nomeIdCampo);
            
         
            
        }
        ps.close();
            return 0;
      }
}
