package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;


public class EmprestimoDAOimpl implements EmprestimoDAO {

    // URL de conexão com o banco de dados MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    // Nome de usuário do banco de dados
    private static final String USER = "seuusuario";
    // Senha do banco de dados
    private static final String PASSWORD = "suasenha";

    @Override
    public void salvarEmprestimo(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos (data_emprestimo, data_devolucao, id_amigo, id_ferramenta) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os parâmetros da instrução SQL
            stmt.setDate(1, (Date) emprestimo.getDataEmprestimo());
            stmt.setDate(2, (Date) emprestimo.getDataDevolucao());
            stmt.setInt(3, emprestimo.getIdAmigo());
            stmt.setInt(4, emprestimo.getIdFerramenta());

            // Executa a instrução SQL para inserir o empréstimo no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar o empréstimo: " + e.getMessage());
        }
    }

    @Override
    public void atualizarEmprestimo(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimos SET data_emprestimo = ?, data_devolucao = ?, id_amigo = ?, id_ferramenta = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os parâmetros da instrução SQL
            stmt.setDate(1, (Date) emprestimo.getDataEmprestimo());
            stmt.setDate(2, (Date) emprestimo.getDataDevolucao());
            stmt.setInt(3, emprestimo.getIdAmigo());
            stmt.setInt(4, emprestimo.getIdFerramenta());
            stmt.setInt(5, emprestimo.getId());

            // Executa a instrução SQL para atualizar o empréstimo no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o empréstimo: " + e.getMessage());
        }
    }

    @Override
    public void excluirEmprestimo(int id) {
        String sql = "DELETE FROM emprestimos WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o parâmetro da instrução SQL
            stmt.setInt(1, id);

            // Executa a instrução SQL para excluir o empréstimo do banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o empréstimo: " + e.getMessage());
        }
    }

    @Override
    public Emprestimo buscarEmprestimoPorId(int id) {
        String sql = "SELECT * FROM emprestimos WHERE id = ?";
        Emprestimo emprestimo = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o parâmetro da instrução SQL
            stmt.setInt(1, id);

            // Executa a consulta SQL e armazena o resultado
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Cria um objeto Emprestimo com os dados retornados do banco de dados
                emprestimo = new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("id_ferramenta"),
                        rs.getInt("id_amigo"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("data_devolucao")
                        
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o empréstimo: " + e.getMessage());
        }
        return emprestimo;
    }

    @Override
    public List<Emprestimo> listarTodosEmprestimos() {
        String sql = "SELECT * FROM emprestimos";
        List<Emprestimo> listaEmprestimos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Executa a consulta SQL e armazena o resultado
            while (rs.next()) {
                // Cria um objeto Emprestimo para cada linha do resultado e adiciona à lista
                Emprestimo emprestimo = new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("id_ferramenta"),
                        rs.getInt("id_amigo"),
                        rs.getDate("data_emprestimo"),
                        rs.getDate("data_devolucao")
                );
                listaEmprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os empréstimos: " + e.getMessage());
        }
        return listaEmprestimos;
    }
}