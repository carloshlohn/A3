package model;

import dao.AmigoDAOimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Representa um amigo com nome, telefone e identificador único.
 */
public class Amigo {
    private int id; // Identificador único do amigo
    private String nome; // Nome do amigo
    private String fone; // Telefone do amigo

    private static List<Amigo> listaAmigos = new ArrayList<>(); // Lista estática de amigos

    /**
     * Construtor da classe Amigo.
     *
     * @param id   Identificador único do amigo.
     * @param nome Nome do amigo.
     * @param fone Telefone do amigo.
     */
    public Amigo(int id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    /**
     * Obtém a lista de amigos.
     *
     * @return A lista de amigos.
     */
    public static List<Amigo> getListaAmigos() {
        return listaAmigos;
    }

    public Amigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Obtém o identificador único do amigo.
     *
     * @return O identificador único do amigo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do amigo.
     *
     * @param id O identificador único do amigo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do amigo.
     *
     * @return O nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     *
     * @param nome O nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone do amigo.
     *
     * @return O telefone do amigo.
     */
    public String getFone() {
        return fone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param fone O telefone do amigo.
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * Realiza a leitura do nome e telefone do amigo a partir de diálogos.
     */
    public void leitura() {
        setNome(JOptionPane.showInputDialog("Digite seu nome: "));
        setFone(JOptionPane.showInputDialog("Digite seu telefone: "));
    }

    /**
     * Retorna uma representação em string do objeto Amigo.
     *
     * @return Uma representação em string do objeto Amigo.
     */
    @Override
    public String toString() {
        return "ID: " + getId() + "\nNome: " + getNome() + "\nTelefone: " + getFone();
    }

    /**
     * Insere um novo amigo na lista de amigos.
     *
     * @param id  o id do amigo.
     * @param nome O nome do amigo.
     * @param fone O telefone do amigo.
     * @return true se a operação for bem-sucedida, false caso contrário.
     * @throws java.sql.SQLException
     */
    // Na classe Amigo, ajuste o método insertAmigoBD para aceitar um ID como parâmetro e incluí-lo na inserção no banco de dados
    public boolean insertAmigoBD(int id, String nome, String fone) throws SQLException {
        try {
            Amigo novoAmigo = new Amigo(id, nome, fone);
            listaAmigos.add(novoAmigo);
            salvar(); // Salva o amigo no banco de dados
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O ID deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Salva o amigo no banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao salvar no banco de dados.
     */
    public void salvar() throws SQLException {
        String sql = "INSERT INTO amigo (nome, fone) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, getNome());
            stmt.setString(2, getFone());
            stmt.executeUpdate();

            // Obtendo o ID gerado pelo banco de dados
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    /**
     * Lista todos os amigos do banco de dados.
     *
     * @return Lista de amigos.
     * @throws SQLException se ocorrer um erro ao listar do banco de dados.
     */
    public static List<Amigo> listar() throws SQLException {
        List<Amigo> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigo";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Amigo amigo = new Amigo(rs.getInt("id"), rs.getString("nome"), rs.getString("fone"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    /**
     * Atualiza um amigo existente no banco de dados.
     *
     * @param nome O novo nome do amigo.
     * @param telefone O novo telefone do amigo.
     * @param id O identificador único do amigo.
     * @return true se a operação for bem-sucedida, false caso contrário.
     * @throws SQLException se ocorrer um erro ao atualizar no banco de dados.
     */
    public boolean atualizarAmigo(String nome, String telefone, int id) throws SQLException {
        Amigo amigo = new Amigo(id, nome, telefone); // Criar objeto Amigo com os parâmetros fornecidos
        AmigoDAOimpl dao = new AmigoDAOimpl();
        dao.atualizarAmigo(amigo); // Chamar método atualizar da classe AmigoDAOimpl
        return true;
    }

    /**
     * Deleta o amigo do banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao deletar do banco de dados.
     */
    public void deleteAmigoBD() throws SQLException {
        String sql = "DELETE FROM amigo WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getId());
            stmt.executeUpdate();
        }
    }

    public static void imprimirListaAmigos() {
        for (Amigo amigo : listaAmigos) {
            System.out.println(amigo);
        }
    }

    public Object getMinhaLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Classe estática para gerenciar a conexão com o banco de dados.
     */
    public static class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/db_a3?zeroDateTimeBehavior=CONVERT_TO_NULL";
        private static final String USER = "root";
        private static final String PASSWORD = "lohnaldoN9!";

        /**
         * Obtém uma conexão com o banco de dados.
         *
         * @return A conexão com o banco de dados.
         * @throws SQLException se ocorrer um erro ao conectar ao banco de dados.
         */
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}
