 package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Ferramenta;

/**
 * Implementação da interface FerramentaDAO utilizando JDBC para interação com um banco de dados SQL.
 */
public class FerramentaDAOimpl implements FerramentaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    private static final String USER = "seuusuario";
    private static final String PASSWORD = "suasenha";

    /**
     * Salva uma nova ferramenta no banco de dados.
     *
     * @param ferramenta A ferramenta a ser salva.
     */
    @Override
    public void salvarFerramenta(Ferramenta ferramenta) {
        String sql = "INSERT INTO ferramentas (id, nome, marca, custo) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ferramenta.getId());
            stmt.setString(2, ferramenta.getNome());
            stmt.setString(3, ferramenta.getMarca());
            stmt.setDouble(4, ferramenta.getCusto());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualiza uma ferramenta existente no banco de dados.
     *
     * @param ferramenta A ferramenta com os novos dados a serem atualizados.
     */
    @Override
    public void atualizarFerramenta(Ferramenta ferramenta) {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getCusto());
            stmt.setInt(4, ferramenta.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exclui uma ferramenta do banco de dados.
     *
     * @param id O ID da ferramenta a ser excluída.
     */
    @Override
    public void excluirFerramenta(int id) {
        String sql = "DELETE FROM ferramentas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca uma ferramenta no banco de dados pelo seu ID.
     *
     * @param id O ID da ferramenta a ser buscada.
     * @return A ferramenta encontrada ou null se não for encontrada.
     */
    @Override
    public Ferramenta buscarFerramentaPorId(int id) {
        String sql = "SELECT * FROM ferramentas WHERE id = ?";
        Ferramenta ferramenta = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ferramenta = new Ferramenta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("custo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ferramenta;
    }

    /**
     * Lista todas as ferramentas armazenadas no banco de dados.
     *
     * @return Uma lista de todas as ferramentas.
     */
    @Override
    public List<Ferramenta> listarTodasFerramentas() {
        String sql = "SELECT * FROM ferramentas";
        List<Ferramenta> listaFerramentas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("marca"),
                    rs.getDouble("custo")
                );
                listaFerramentas.add(ferramenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFerramentas;
    }
}

