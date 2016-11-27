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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.Pedido;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CRISTIAN CARLOS ARANIBAR MONTANO - RA 20745554
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
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

            JOptionPane.showMessageDialog(null, Strings.cadastrado);

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

            }catch (NullPointerException ex){
                
              
                
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

            if (rs.next()) {

                jMarcaTextField.setText(rs.getString("marca"));
                jobservacaoTextPane.setText(rs.getString("observacao"));
                jSerieFormatedText.setText(String.valueOf(rs.getLong("serie")));

            } else {
                jMarcaTextField.setText("");
                jobservacaoTextPane.setText("");
                jSerieFormatedText.setText("");

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ArrayList listarPedidos() {
        PreparedStatement listarPedidos = null;
        Connection connection = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Pedido> pedidoArray = new ArrayList();
        pedidoArray.clear();

        String listarPedidoQuery = "SELECT pedido.idPedido, pessoa.nome, cliente.celular\n"
                + "FROM pedido\n"
                + "INNER JOIN cliente\n"
                + "ON pedido.cliente_idCliente = cliente.idCliente\n"
                + "INNER JOIN pessoa\n"
                + "ON cliente.pessoa_idPessoa = pessoa.idPessoa";
        
        
          try {
            listarPedidos = connection.prepareStatement(listarPedidoQuery);

            rs = listarPedidos.executeQuery();
            while (rs.next()) {
                
                Pedido p = new Pedido();
                
                p.setIdPedido(rs.getInt("idPedido"));
                p.setNome(rs.getString("nome"));
                p.setCelular(rs.getLong("celular"));
                
                pedidoArray.add(p);
                


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
              
            try {
                listarPedidos.close();
            } catch (SQLException ex) {
             
            }
          }

        return pedidoArray;
        

    }

}
