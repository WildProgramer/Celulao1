/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;

/**
 *
 * @author Norb7492
 */
public class ConversorDeDadosController {
    
    
       public long converterCpf(JTextField cpfContainer){
           
                  String cpf1 = cpfContainer.getText().replaceAll("\\.", "").replaceAll("\\-", "");
                  String cpf2 = cpf1.trim();
                  
                  return Long.valueOf(cpf2);
           
       }
    
       
     public String converterData(JDateChooser dateChooser){
         
       
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date = sdf.format(dateChooser.getDate().getTime());
         return date;
       
     }  
     
}