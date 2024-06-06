package dao;


import model.Amigo;
import java.util.List;

/**
 * Interface para operações de acesso a dados para a entidade Ferramenta.
 */
public interface AmigoDAO {
    /**
     * Salva um novo amigo no repositório de dados.
     * 
     * @param amigo O amigo a ser salvo.
     */
    void salvarAmigo(Amigo amigo);
    /**
     * Atualiza um  amigo existente no repositório de dados.
     * 
     * @param amigo O amigo a ser atualizado.
     */
    void atualizarAmigo(Amigo amigo);
    /**
     * Exclui um amigo do repositório de dados pelo id.
     * 
     * @param id O id do amigo a ser excluido.
     */
    void excluirAmigo(int id);
    /**
     * Busca um amigo no banco de dados pelo ID.
     * @param id o ID do amigo a ser buscado.
     * @return o objeto Amigo correspondente ao ID, ou null se não encontrado.
     */
    Amigo buscarAmigoPorId(int id);
    /**
     * Lista todos os amigos do banco de dados.
     * @return uma lista de todos os objetos Amigo.
     */
    List<Amigo> listarTodosAmigos();
}
