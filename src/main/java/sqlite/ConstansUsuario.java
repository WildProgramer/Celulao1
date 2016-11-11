/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

/**
 *
 * @author Norb7492
 */
public class ConstansUsuario {

    private static String ID = "idUsuario";
    private static String USUARIO = "usuario";
    private static String SENHA = "senha";
    private static String TABELA = "usuario";

    public static String criarTablea() {

        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE IF NOT EXISTS ");
        builder.append(TABELA);
        builder.append(" (");
        builder.append("id");
        builder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builder.append(USUARIO);
        builder.append(" TEXT NOT NULL);");

        return builder.toString();

    }

    public static String getID() {
        return ID;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getTABELA() {
        return TABELA;
    }


    
    

}
