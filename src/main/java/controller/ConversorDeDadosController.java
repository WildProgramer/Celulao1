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
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
//Classe que convert os cpf, cnpj, números de série em números inteiros sem carácteres
public class ConversorDeDadosController {
    
    
       public long converterCpf(JTextField cpfContainer){
           
                  String cpf1 = cpfContainer.getText().replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("\\/", "").replaceAll("\\(", "")
                          .replaceAll("\\)", "");
                  String cpf2 = cpf1.replaceAll("\\s+","");
                  
                  return Long.valueOf(cpf2);
           
       }
    
       
     public String converterData(JDateChooser dateChooser){
         
       
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String date = sdf.format(dateChooser.getDate().getTime());
         return date;
       
     }  
     
}
