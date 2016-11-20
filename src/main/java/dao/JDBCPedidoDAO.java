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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pedido;

/**
 *
 * @author Norb7492
 */
public class JDBCPedidoDAO implements PedidoDAO {

    //Método que insere o pedido
    @Override
    public void inserirPedido(Pedido p, long idCliente) {
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
            insereAparelho.setString(2, p.getObervacao());
            insereAparelho.setLong(3, p.getNumeroSerie());

            insereAparelho.executeUpdate();
            idAparelho = queryHelper.getLastId(insereAparelho);

            String inserirPedidoQuery = "INSERT INTO pedido (cliente_idCliente, aparelho_idAparelhos) VALUES "
                    + "(?,?)";

            inserePedido = connection.prepareStatement(inserirPedidoQuery, Statement.RETURN_GENERATED_KEYS);
            inserePedido.setLong(1, idCliente);
            inserePedido.setInt(2, idAparelho);

            inserePedido.executeUpdate();

            connection.commit();

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {

            }

        } finally {

            try {
                insereAparelho.close();
                inserePedido.close();
            } catch (SQLException ex) {

            }
        }

    }

}
