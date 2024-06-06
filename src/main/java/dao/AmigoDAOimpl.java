package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Amigo;

/**
 * Implementação da interface AmigoDAO utilizando JDBC para interação com um banco de dados SQL.
 */
public class AmigoDAOimpl implements AmigoDAO {

    // URL de conexão com o banco de dados MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    // Nome de usuário do banco de dados
    private static final String USER = "seuusuario";
    // Senha do banco de dados
    private static final String PASSWORD = "suasenha";

    /**
     * Salva um novo amigo no banco de dados.
     *
     * @param amigo O amigo a ser salvo.
     */
    @Override
    public void salvarAmigo(Amigo amigo) {
        String sql = "INSERT INTO amigos (id, nome, telefone) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os parâmetros da instrução SQL
            stmt.setInt(1, amigo.getId());
            stmt.setString(2, amigo.getNome());
            stmt.setString(3, amigo.getFone());

            // Executa a instrução SQL para inserir o amigo no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar o amigo: " + e.getMessage());
        }
    }

    /**
     * Atualiza um amigo existente no banco de dados.
     *
     * @param amigo O amigo com os novos dados a serem atualizados.
     */
    @Override
    public void atualizarAmigo(Amigo amigo) {
        String sql = "UPDATE amigos SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os parâmetros da instrução SQL
            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getFone());
            stmt.setInt(3, amigo.getId());

            // Executa a instrução SQL para atualizar o amigo no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o amigo: " + e.getMessage());
        }
    }

    /**
     * Exclui um amigo do banco de dados.
     *
     * @param id O ID do amigo a ser excluído.
     */
    @Override
    public void excluirAmigo(int id) {
        String sql = "DELETE FROM amigos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o parâmetro da instrução SQL
            stmt.setInt(1, id);

            // Executa a instrução SQL para excluir o amigo do banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o amigo: " + e.getMessage());
        }
    }

    /**
     * Busca um amigo no banco de dados pelo seu ID.
     *
     * @param id O ID do amigo a ser buscado.
     * @return O amigo encontrado ou null se não for encontrado.
     */
    @Override
    public Amigo buscarAmigoPorId(int id) {
        String sql = "SELECT * FROM amigos WHERE id = ?";
        Amigo amigo = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o parâmetro da instrução SQL
            stmt.setInt(1, id);

            // Executa a consulta SQL e armazena o resultado
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Cria um objeto Amigo com os dados retornados do banco de dados
                amigo = new Amigo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o amigo: " + e.getMessage());
        }
        return amigo;
    }

    /**
     * Lista todos os amigos armazenados no banco de dados.
     *
     * @return Uma lista de todos os amigos.
     */
    @Override
    public List<Amigo> listarTodosAmigos() {
        String sql = "SELECT * FROM amigos";
        List<Amigo> listaAmigos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Executa a consulta SQL e armazena o resultado
            while (rs.next()) {
                // Cria um objeto Amigo para cada linha do resultado e adiciona à lista
                Amigo amigo = new Amigo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone")
                );
                listaAmigos.add(amigo);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os amigos: " + e.getMessage());
        }
        return listaAmigos;
    }
}