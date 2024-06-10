package dao;

import conexao.Conexao;
import model.Amigo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável pelas operações de CRUD com a tabela "amigos" no banco de
 * dados.
 */
public class AmigoDAOimpl {

    private final Conexao connectionBD;
    private static final Logger LOGGER = Logger.getLogger(AmigoDAOimpl.class.getName());

    public AmigoDAOimpl() {
        this.connectionBD = new Conexao();
    }

    /**
     * Obtém o maior ID presente na tabela "amigos".
     *
     * @return o maior ID encontrado ou 0 se ocorrer um erro
     */
    public int pegaMaiorID() {
        int maior = 0;
        String sql = "SELECT MAX(id) as id FROM amigos";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            if (res.next()) {
                maior = res.getInt("id");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao pegar maior ID", ex);
        }
        return maior;
    }

    /**
     * Obtém uma lista de todos os amigos na tabela "amigos".
     *
     * @return uma lista de objetos {@link Amigo}
     */
    public ArrayList<Amigo> getMinhaLista() {
        ArrayList<Amigo> lista = new ArrayList<>();
        String sql = "SELECT * FROM amigos";
        try (Connection conexaoBD = Conexao.getConnection(); Statement stmt = conexaoBD.createStatement(); ResultSet resposta = stmt.executeQuery(sql)) {
            while (resposta.next()) {
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                String telefone = resposta.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);
                lista.add(objeto);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Erro ao obter lista de amigos", ex);
        }
        return lista;
    }

    /**
     * Insere um novo amigo na tabela "amigos".
     *
     * @param objeto o objeto {@link Amigo} a ser inserido
     * @return {@code true} se a inserção for bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean inserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO amigos(nome, telefone) VALUES(?, ?)";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao inserir amigo", erro);
        }
        return false;
    }

    /**
     * Deleta um amigo da tabela "amigos" pelo ID.
     *
     * @param id o ID do amigo a ser deletado
     * @return {@code true} se a deleção for bem-sucedida, {@code false} caso
     * contrário
     */
    public boolean deletaAmigoBD(int id) {
        String sql = "DELETE FROM amigos WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar amigo", erro);
        }
        return false;
    }

    /**
     * Atualiza um amigo existente na tabela "amigos".
     *
     * @param objeto o objeto {@link Amigo} a ser atualizado
     * @return {@code true} se a atualização for bem-sucedida, {@code false}
     * caso contrário
     */
    public boolean atualizarAmigoBD(Amigo objeto) {
        String sql = "UPDATE amigos SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getId());
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar amigo", erro);
        }
        return false;
    }

    /**
     * Carrega um amigo da tabela "amigos" pelo ID.
     *
     * @param id o ID do amigo a ser carregado
     * @return um objeto {@link Amigo} se o amigo for encontrado, {@code null}
     * caso contrário
     */
    public Amigo carregaAmigoBD(int id) {
        String sql = "SELECT * FROM amigos WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resposta = stmt.executeQuery()) {
                if (resposta.next()) {
                    int amigoId = resposta.getInt("id");
                    String nome = resposta.getString("nome");
                    String telefone = resposta.getString("telefone");
                    return new Amigo(amigoId, nome, telefone);
                }
            }
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao carregar amigo", erro);
        }
        return null;
    }

    /**
     * Busca um amigo na tabela "amigos" pelo ID.
     *
     * @param id o ID do amigo a ser buscado
     * @return um objeto {@link Amigo} se o amigo for encontrado, {@code null}
     * caso contrário
     */
    public Amigo buscarAmigoPorId(int id) {
        String sql = "SELECT * FROM amigos WHERE id = ?";
        try (Connection conexaoBD = Conexao.getConnection(); PreparedStatement stmt = conexaoBD.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resposta = stmt.executeQuery()) {
                if (resposta.next()) {
                    int amigoId = resposta.getInt("id");
                    String nome = resposta.getString("nome");
                    String telefone = resposta.getString("telefone");
                    return new Amigo(amigoId, nome, telefone);
                }
            }
        } catch (SQLException erro) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar amigo por ID", erro);
        }
        return null;
    }
}
