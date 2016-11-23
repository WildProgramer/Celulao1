/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import helper.JDBCQueryHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.Pedido;

/**
 *
 * @author Norb7492
 */
public class JDBCPedidoDAO implements PedidoDAO {

    //Método que insere o pedido
    @Override
    public void inserirPedido(Pedido p) {
        PreparedStatement inserePedido = null;
        PreparedStatement insereAparelho = null;
        JDBCQueryHelper queryHelper = new JDBCQueryHelper();
        Connection connection;
        int idAparelho;

        connection = ConnectionFactory.getConnection();
        try {
            connection.setAutoCommit(false);
            String inserirAparelhoQuery = "INSERT INTO aparelho (marca, observacao, serie) VALUES "
                    + "(?,?,?)";

            insereAparelho = connection.prepareStatement(inserirAparelhoQuery, Statement.RETURN_GENERATED_KEYS);
            insereAparelho.setString(1, p.getMarca());
            insereAparelho.setString(2, p.getObservacao());
            insereAparelho.setLong(3, p.getSerie());

            insereAparelho.executeUpdate();
            idAparelho = queryHelper.getLastId(insereAparelho);

            String inserirPedidoQuery = "INSERT INTO pedido (cliente_idCliente, aparelho_idAparelho) VALUES "
                    + "(?,?)";

            inserePedido = connection.prepareStatement(inserirPedidoQuery, Statement.RETURN_GENERATED_KEYS);
            inserePedido.setLong(1, p.getIdCliente());
            inserePedido.setInt(2, idAparelho);

            inserePedido.executeUpdate();

            connection.commit();

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {

            }
            System.out.println(ex.getMessage());
        } finally {

            try {
                insereAparelho.close();
                inserePedido.close();
            } catch (SQLException ex) {

            }
        }

    }

    @Override
    public void mostrarPedido(String id, JTextField jMarcaTextField,
            JTextField jSerieFormatedText, JTextPane jobservacaoTextPane) {

        PreparedStatement ps;
        Connection connection = ConnectionFactory.getConnection();
        String mostrarPedidoLabelQuery = "SELECT aparelho.marca, aparelho.observacao, aparelho.serie\n"
                + "FROM pedido\n"
                + "INNER JOIN aparelho\n"
                + "ON pedido.aparelho_idAparelho = aparelho.idAparelho\n"
                + "WHERE pedido.cliente_idCliente = ?";

       
        
                        
        try {
            ps = connection.prepareStatement(mostrarPedidoLabelQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                
                
                
                jMarcaTextField.setText(rs.getString("marca"));
                jobservacaoTextPane.setText(rs.getString("observacao"));
                jSerieFormatedText.setText(String.valueOf(rs.getLong("serie")));
            
                
            }else{
                jMarcaTextField.setText("");
                jobservacaoTextPane.setText("");
                jSerieFormatedText.setText("");
                
                
            }
            
            
        } catch (SQLException ex) {
         
                System.out.println(ex.getMessage());
        }
        
    }

}
