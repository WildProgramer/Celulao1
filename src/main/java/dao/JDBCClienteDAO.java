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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Strings;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
//Esta classe insere o cliente na base de dados
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
        PreparedStatement insertCliente = null;

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false);

            if (c.getTipo().equals("Físico")) {
                String inserirPessoaFisicaQuery = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                        + "(?,?,?,?)";

                insertPessoa = connection.prepareStatement(inserirPessoaFisicaQuery, Statement.RETURN_GENERATED_KEYS);
                insertPessoa.setString(1, c.getNome());
                insertPessoa.setLong(2, c.getCpf());
                insertPessoa.setLong(3, 0);
                insertPessoa.setString(4, c.getEndereco());

                insertPessoa.executeUpdate();
                idPessoa = queryHelper.getLastId(insertPessoa);

            } else {
                // Inserir Pessoa Jurídica
                String inserirPessoaJurificaQuery = "INSERT INTO pessoa (nome, cpf, cnpj, endereco) VALUES "
                        + "(?,?,?,?)";

                insertPessoa = connection.prepareStatement(inserirPessoaJurificaQuery, Statement.RETURN_GENERATED_KEYS);
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

                String inserirTipoQuery = "INSERT INTO tipocliente (tipocliente) VALUES "
                        + "(?)";

                insertTipoCliente = connection.prepareStatement(inserirTipoQuery, Statement.RETURN_GENERATED_KEYS);
                insertTipoCliente.setString(1, c.getTipo());
                insertTipoCliente.executeUpdate();
                idTipo = queryHelper.getLastId(insertTipoCliente);

            }

            //Inserir Cliente
            String inserirClienteQuery = "INSERT INTO cliente (pessoa_idPessoa, tipoCliente_idTipoCliente,celular) VALUES "
                    + "(?,?,?)";
            insertCliente = connection.prepareStatement(inserirClienteQuery, Statement.RETURN_GENERATED_KEYS);
            insertCliente.setInt(1, idPessoa);
            insertCliente.setInt(2, idTipo);
            insertCliente.setLong(3, c.getCelular());
            insertCliente.executeUpdate();

            connection.commit();
            JOptionPane.showMessageDialog(null, Strings.cadastrado);

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

            }catch (NullPointerException ex){
                
              
                
            }

        }
    }

    @Override
    public ArrayList listarClientes() {

        PreparedStatement listarCliente = null;
        ResultSet rs;
        ArrayList<Cliente> clienteArray = new ArrayList();

        clienteArray.clear();
        String listarClienteQuery = "SELECT cliente.idCliente, cliente.celular, pessoa.nome, tipocliente.tipoCliente\n"
                + "FROM cliente\n"
                + "INNER JOIN pessoa\n"
                + "ON cliente.pessoa_idPessoa = pessoa.idPessoa\n"
                + "INNER JOIN tipocliente\n"
                + "ON cliente.tipoCliente_idTipoCliente = tipocliente.idTipoCliente";

        try {
            listarCliente = connection.prepareStatement(listarClienteQuery);

            rs = listarCliente.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setCelular(rs.getLong("celular"));
                c.setNome(rs.getString("nome"));
                c.setTipo(rs.getString("tipoCliente"));

                clienteArray.add(c);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
              
            try {
                listarCliente.close();
            } catch (SQLException ex) {
             
            }
          }

        return clienteArray;
    }

    @Override
    public void mostrarClienteParaCadastrarPedido(String id, JLabel idLabel, JLabel nomeLabel) {

        PreparedStatement ps;
        String mostrarClienteLabelQuery = "SELECT cliente.idCliente, pessoa.nome \n"
                + "FROM cliente\n"
                + "INNER JOIN pessoa\n"
                + "ON cliente.pessoa_idPessoa = pessoa.idPessoa\n"
                + "WHERE cliente.idCliente = ?";
        try {
            ps = connection.prepareStatement(mostrarClienteLabelQuery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
             
                
                
                idLabel.setText(String.valueOf(rs.getInt("idCliente")));
                nomeLabel.setText(rs.getString("nome"));
                
            }
            
            
        } catch (SQLException ex) {
         
                System.out.println(ex.getMessage());
        }
        
        
        
    }
}
