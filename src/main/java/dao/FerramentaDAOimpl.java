package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ferramenta;

public class FerramentaDAOimpl {

    private final Conexao connectionBD;
    private static final Logger LOGGER = Logger.getLogger(FerramentaDAOimpl.class.getName());

    public FerramentaDAOimpl() {
        this.connectionBD = new Conexao();
    }

    public int pegaMaiorID() {
        int maior = 0;
        String sql = "SELECT MAX(id) as id FROM ferramentas";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            if (res.next()) {
                maior = res.getInt("id");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao pegar maior ID", ex);
        }
        return maior;
    }

    public ArrayList<Ferramenta> getListaFerramenta() {
        ArrayList<Ferramenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ferramentas";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet resposta = stmt.executeQuery(sql)) {
            while (resposta.next()) {
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                String marca = resposta.getString("marca");
                double custo = resposta.getDouble("custo");

                Ferramenta ferramenta = new Ferramenta(id, nome, marca, custo);
                lista.add(ferramenta);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao obter lista de ferramentas", ex);
        }
        return lista;
    }

    public boolean inserirFerramentaBD(Ferramenta ferramenta) {
        String sql = "INSERT INTO ferramentas(nome, marca, custo) VALUES(?, ?, ?)";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getCusto());
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao inserir ferramenta", erro);
        }
        return false;
    }

    public boolean deleteFerramentaBD(int id) {
        String sql = "DELETE FROM ferramentas WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar ferramenta", erro);
        }
        return false;
    }

    public boolean updateFerramentaBD(Ferramenta ferramenta) {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getCusto());
            stmt.setInt(4, ferramenta.getId());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar ferramenta", erro);
        }
        return false;
    }

    public Ferramenta carregarFerramentaBD(int id) {
        String sql = "SELECT * FROM ferramentas WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resposta = stmt.executeQuery()) {
                if (resposta.next()) {
                    int ferramentaId = resposta.getInt("id");
                    String nome = resposta.getString("nome");
                    String marca = resposta.getString("marca");
                    double custo = resposta.getDouble("custo");
                    return new Ferramenta(ferramentaId, nome, marca, custo);
                }
            }
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar ferramentas", erro);
        }
        return null;
    }

    public Ferramenta buscarFerramentaPorId(int id) {
        String sql = "SELECT * FROM ferramentas WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resposta = stmt.executeQuery()) {
                if (resposta.next()) {
                    int ferramentaId = resposta.getInt("id");
                    String nome = resposta.getString("nome");
                    String marca = resposta.getString("marca");
                    double custo = resposta.getDouble("custo");

                    return new Ferramenta(ferramentaId, nome, marca, custo);
                }
            }
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ferramenta por ID", erro);
        }
        return null;
    }

    public int getMaiorID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
