/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import javax.swing.JPanel;
import sqlite.SqliteUsuariosAdapter;

/**
 *
 * @author Norb7492
 */
public class TelaPrincipalController {
    
    
      public  void escolherTela(JPanel jPanel1){
        SqliteUsuariosAdapter usuariosAdapter = new SqliteUsuariosAdapter();
        String cargo;
        cargo = usuariosAdapter.buscarUsuario();
        String cargoLower = cargo.toLowerCase();
        if(cargoLower.equals("atendente")){
            
           CardLayout cl = (CardLayout) jPanel1.getLayout();
            cl.show(jPanel1, "atendente");
        }else{
            
            CardLayout cl = (CardLayout) jPanel1.getLayout();
            cl.show(jPanel1, "tecnico");
        }
    }
}
