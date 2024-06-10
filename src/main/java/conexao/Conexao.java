package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 */
public class Conexao {

    private static final Logger LOGGER = Logger.getLogger(Conexao.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/db_a3"; // Atualize com o URL do seu banco de dados
    private static final String USER = "root"; // Atualize com seu usuário do banco de dados
    private static final String PASSWORD = "lohnaldoN9!"; // Atualize com sua senha do banco de dados

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return um objeto {@link Connection} se a conexão for bem-sucedida, ou {@code null} se houver um erro
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao estabelecer conexão com o banco de dados", e);
            return null;
        }
    }
}