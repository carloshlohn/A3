package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um amigo com nome e telefone.
 */
public class Amigo {
    private String nome;
    private String fone;

    private static List<Amigo> listaAmigos = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Amigo() {}

    /**
     * Construtor que inicializa os atributos nome e fone.
     *
     * @param nome Nome do amigo.
     * @param fone Telefone do amigo.
     */
    public Amigo(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    /**
     * Insere um novo amigo no banco de dados e na lista estática.
     *
     * @param nome Nome do amigo.
     * @param fone Telefone do amigo.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean insertAmigoBD(String nome, String fone) {
        try {
            Amigo novoAmigo = new Amigo(nome, fone);
            listaAmigos.add(novoAmigo);
            novoAmigo.salvar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Retorna a lista de amigos.
     *
     * @return Lista de amigos.
     */
    public List<Amigo> getMinhaLista() {
        return listaAmigos;
    }

    // Getters and setters...
    
    /**
     * Retorna o nome do amigo.
     *
     * @return Nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     *
     * @param nome Nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o telefone do amigo.
     *
     * @return Telefone do amigo.
     */
    public String getFone() {
        return fone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param fone Telefone do amigo.
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

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nTelefone: " + getFone();
    }

    // CRUD methods
    
    /**
     * Salva o amigo no banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao salvar no banco de dados.
     */
    public void salvar() throws SQLException {
        String sql = "INSERT INTO amigo (nome, fone) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, getFone());
            stmt.executeUpdate();
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
                Amigo amigo = new Amigo(rs.getString("nome"), rs.getString("fone"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    /**
     * Atualiza o telefone do amigo no banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao atualizar no banco de dados.
     */
    public void atualizar() throws SQLException {
        String sql = "UPDATE amigo SET fone = ? WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getFone());
            stmt.setString(2, getNome());
            stmt.executeUpdate();
        }
    }

    /**
     * Deleta o amigo do banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao deletar do banco de dados.
     */
    public void deletar() throws SQLException {
        String sql = "DELETE FROM amigo WHERE nome = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.executeUpdate();
        }
    }

    /**
     * Atualiza um amigo no banco de dados.
     *
     * @param nome Nome do amigo.
     * @param telefone Novo telefone do amigo.
     * @param fone1 (Não utilizado) Telefone antigo do amigo.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean updateAmigoBD(String nome, String telefone, String fone1) {
        try {
            setNome(nome);
            setFone(telefone);
            atualizar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Deleta um amigo do banco de dados.
     *
     * @param nome Nome do amigo.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean deleteAmigoBD(String nome) {
        try {
            setNome(nome);
            deletar();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Classe estática para gerenciar a conexão com o banco de dados.
     */
    private static class DatabaseConnection {

        private static final String URL = "jdbc:mysql://localhost:3306/db_a3?zeroDateTimeBehavior=CONVERT_TO_NULL";
        private static final String USER = "root";
        private static final String PASSWORD = "lohnaldoN9!";

        /**
         * Obtém uma conexão com o banco de dados.
         *
         * @return Conexão com o banco de dados.
         * @throws SQLException se ocorrer um erro ao conectar ao banco de dados.
         */
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}
