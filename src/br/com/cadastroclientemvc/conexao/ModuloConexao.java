package br.com.cadastroclientemvc.conexao;

import java.sql.*;

/**
 *
 * @author Gabriel Lavor
 */
/**
 * Metodo para conexão com o Banco de Dados
 */
public class ModuloConexao {
    public static Connection conectar(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cadastro_clientes";
        String usuario = "root";
        String senha = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            return conexao;
        } catch (Exception e) {
            return null;
        }
        
    }
}
