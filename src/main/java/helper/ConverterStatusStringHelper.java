/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class ConverterStatusStringHelper {
    
    
    public static String converterStatusParaString(int autoriza){
        
        if(autoriza == 1){
            
            return "Sim";
            
        }else{
            
            
            return "Não";
        }
        
        
    }
    
    
    
}
