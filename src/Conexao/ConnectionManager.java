package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String urlDeConexao = "jdbc:h2:file:./Banco/ChalengerBanco;AUTO_SERVER=TRUE";
    private static final String login = "sa";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(urlDeConexao, login, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}