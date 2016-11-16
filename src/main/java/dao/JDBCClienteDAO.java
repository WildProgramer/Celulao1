/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import helper.JDBCQueryHelper;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author Norb7492
 */
public class JDBCClienteDAO implements ClienteDAO {

    private Connection connection;

    //Variaveis para salvar os id das insert
    private int idPessoa;
    private int idTipo;

    private JDBCQueryHelper queryHelper = new JDBCQueryHelper();

    public JDBCClienteDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserirFuncionario(Cliente c) {

        PreparedStatement insertPessoa = null;
        PreparedStatement insertTipoCliente = null;
        PreparedStatement insertTipoClienteJuridico = null;
        PreparedStatement insertCliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);

            if (c.getTipo().equals("Físico")) {
                String Pessoa = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                        + "(?,?,?,?)";

                insertPessoa = connection.prepareStatement(Pessoa, Statement.RETURN_GENERATED_KEYS);
                insertPessoa.setString(1, c.getNome());
                insertPessoa.setLong(2, c.getCpf());
                insertPessoa.setLong(3, 0);
                insertPessoa.setString(4, c.getEndereco());

                insertPessoa.executeUpdate();
                idPessoa = queryHelper.getLastId(insertPessoa);

            } else {
                // Inserir Pessoa Jurídica
                String Pessoa = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                        + "(?,?,?,?)";

                insertPessoa = connection.prepareStatement(Pessoa, Statement.RETURN_GENERATED_KEYS);
                insertPessoa.setString(1, c.getNome());
                insertPessoa.setLong(2, 0);
                insertPessoa.setLong(3, c.getCnpj());
                insertPessoa.setString(4, c.getEndereco());

                insertPessoa.executeUpdate();
                idPessoa = queryHelper.getLastId(insertPessoa);

            }

            //Inserir Tipo
            idTipo = queryHelper.verificaSeExiste(connection, "idTipoCliente", "tipocliente", "tipocliente", c.getTipo());

            if (idTipo == 0) {

                String InsereTipo = "INSERT INTO tipocliente (tipocliente) VALUES "
                        + "(?)";

                insertTipoCliente = connection.prepareStatement(InsereTipo, Statement.RETURN_GENERATED_KEYS);
                insertTipoCliente.setString(1, c.getTipo());
                insertTipoCliente.executeUpdate();
                idTipo = queryHelper.getLastId(insertTipoCliente);

            }

            //Inserir Cliente
            String Cliente = "INSERT INTO cliente (pessoa_idPessoa, tipoCliente_idTipoCliente,celular) VALUES "
                    + "(?,?,?)";
            insertCliente = connection.prepareStatement(Cliente, Statement.RETURN_GENERATED_KEYS);
            insertCliente.setInt(1, idPessoa);
            insertCliente.setInt(2, idTipo);
            insertCliente.setLong(3, c.getCelular());
            insertCliente.executeUpdate();

            connection.commit();

        } catch (SQLException ex) {

            try {
                connection.rollback();
                System.out.println(ex.getMessage());
            } catch (SQLException ex1) {

            }

        } finally {

            try {
                insertPessoa.close();
                insertTipoCliente.close();
            } catch (SQLException ex) {

            }

        }
    }

    @Override
    public ArrayList listarClientes() {

        PreparedStatement listarCliente = null;
        ResultSet rs;
        ArrayList<Cliente> clienteArray = new ArrayList();

        String Listar = "SELECT cliente.idCliente, cliente.celular, pessoa.nome, tipocliente.tipoCliente\n"
                + "FROM cliente\n"
                + "INNER JOIN pessoa\n"
                + "ON cliente.pessoa_idPessoa = pessoa.idPessoa\n"
                + "INNER JOIN tipocliente\n"
                + "ON cliente.tipoCliente_idTipoCliente = tipocliente.idTipoCliente";
        
        
        try {
            listarCliente = connection.prepareStatement(Listar);
            
            rs = listarCliente.executeQuery();
            while(rs.next()){
               Cliente c = new Cliente();
                   c.setIdCliente(rs.getInt("idCliente"));
                   c.setCelular(rs.getLong("celular"));
                   c.setNome(rs.getString("nome"));
                   c.setTipo(rs.getString("tipoCliente"));
                
                 clienteArray.add(c);
                   
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return clienteArray;
    }

}
