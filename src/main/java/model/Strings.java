/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 *  NORBERT HERMANNO STRZYBNY - RA 20751165
 *  CLAUS DE FREITAS LEITÃO - RA 20755234
 *  VANESSA CRISTINA SILVA DE ALMEIDA - RA 20755535
 */
public class Strings {
    
    //Esta classe contém todas as strings de status e erros
    
    public static String inserir = "Por favor inserir o nome e a senha";
    
    //Strings Connection Factory
    public static String bancoNaoEncontrado = "Ocorreu um erro com o banco de dados, por favor entrar em contato com o administrador";
    public static String classeJdbc = "Ocorreu um erro com a classe jdbc, por favor entrar em contato com o administrador";
    
    //Strings Dao
    public static String usuarioExistente = "Este nome de usuário já esta cadastrado no sistema, por favor selecione outro";
    public static String cadastrado = "Cadastrado com sucesso";
    public static Object erroExecutar = "Ocorreu um erro ao executar o processo";
    public static Object naoExiste = "Usuário ou senha inválidos";
    
    
    
    //Erros de formatação
    public static String dataErrada = "Por favor selecionar data certa";
    
    //Faltando texto
    public static String preecherCampos = "Por favor preencher todos os campos";
    public static String selecionaCliente = "Por favor selecionar um cliente";
    public static String selecionaPedido = "Por favor selecionar um pedido";
    public static String valoresCorretos = "Por favor preencher todos os campos com valores corretos";
    
    
}
