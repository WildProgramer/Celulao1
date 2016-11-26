/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import helper.CalcularValoresOrcamentoHelper;
import helper.JDBCQueryHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Orcamento;
import model.Strings;

/**
 *
 * @author Norb7492
 */
public class JDBCOrcamentoDAO implements OrcamentoDAO {

    @Override
    public void cadastrarOrcamento(String idPedido, Orcamento o) {
        int idAutorizacao;
        int idPago;

        PreparedStatement insereOrcamento = null;
        PreparedStatement insereAutorizacao = null;
        PreparedStatement inserePago = null;
        JDBCQueryHelper queryHelper = new JDBCQueryHelper();
        Connection connection = ConnectionFactory.getConnection();

        try {
            connection.setAutoCommit(false);

            idAutorizacao = queryHelper.verificaSeExiste(connection, "idAutorizacao", "autorizacao", "autoriza", "2");

            if (idAutorizacao == 0) {

                String inserirAutorizacaoQuery = "INSERT INTO autorizacao (autoriza) VALUES "
                        + "(?)";

                insereAutorizacao = connection.prepareStatement(inserirAutorizacaoQuery, Statement.RETURN_GENERATED_KEYS);
                insereAutorizacao.setString(1, "2");
                insereAutorizacao.executeUpdate();
                idAutorizacao = queryHelper.getLastId(insereAutorizacao);

            }

            idPago = queryHelper.verificaSeExiste(connection, "idPago", "pago", "statusPagamento", "2");

            if (idPago == 0) {

                String inserirPagoQuery = "INSERT INTO pago (statusPagamento) VALUES "
                        + "(?)";

                inserePago = connection.prepareStatement(inserirPagoQuery, Statement.RETURN_GENERATED_KEYS);
                inserePago.setString(1, "2");
                inserePago.executeUpdate();
                idPago = queryHelper.getLastId(inserePago);

            }

            //Inserir Cliente
            String inserirOrcamentoQuery = "INSERT INTO orcamento (autorizacao_idAutorizacao, pago_idPago,"
                    + "pedido_idPedido, valorPeca, valorServico) VALUES "
                    + "(?,?,?,?,?)";
            insereOrcamento = connection.prepareStatement(inserirOrcamentoQuery, Statement.RETURN_GENERATED_KEYS);
            insereOrcamento.setInt(1, idAutorizacao);
            insereOrcamento.setInt(2, idPago);
            insereOrcamento.setInt(3, Integer.valueOf(idPedido));
            insereOrcamento.setDouble(4, o.getValorPeca());
            insereOrcamento.setDouble(5, o.getValorServico());
            insereOrcamento.executeUpdate();

            connection.commit();
            JOptionPane.showMessageDialog(null, Strings.cadastrado);

        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException ex) {

            }
        } finally {

            try {
                insereAutorizacao.close();
                inserePago.close();
                insereOrcamento.close();
            } catch (SQLException ex) {
            } catch (NullPointerException ex) {

            }
        }

    }

    @Override
    public ArrayList listarOrcamento(String idPedido) {

        PreparedStatement listarOrcamentos = null;
        Connection connection = ConnectionFactory.getConnection();
        ResultSet rs;
        ArrayList<Orcamento> orcamentoArray = new ArrayList();
        orcamentoArray.clear();

        String listarOrcamentoQuery = "SELECT orcamento.idOrcamento, orcamento.valorPeca, orcamento.valorServico, autorizacao.autoriza, pago.statusPagamento\n"
                + "FROM orcamento\n"
                + "INNER JOIN autorizacao\n"
                + "ON orcamento.autorizacao_idAutorizacao = autorizacao.idAutorizacao\n"
                + "INNER JOIN pago\n"
                + "ON orcamento.pago_idPago = pago.idPago\n"
                + "WHERE orcamento.pedido_idPedido = ?";

        try {
            listarOrcamentos = connection.prepareStatement(listarOrcamentoQuery);
            listarOrcamentos.setString(1, idPedido);
            rs = listarOrcamentos.executeQuery();
            while (rs.next()) {

                Orcamento o = new Orcamento();

                o.setIdOrcamento(rs.getInt("idOrcamento"));
                double precoTotal = CalcularValoresOrcamentoHelper.somarOrcamento(rs.getDouble("valorPeca"), rs.getDouble("valorServico"));
                o.setPrecoTotal(precoTotal);
                o.setAutoriza(rs.getInt("autoriza"));
                o.setStatusPagamento(rs.getInt("statusPagamento"));

                orcamentoArray.add(o);
                
                System.out.println(precoTotal);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                listarOrcamentos.close();
            } catch (SQLException ex) {

            }
        }

        return orcamentoArray;

    }

}


