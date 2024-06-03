package dao;
import java.util.List;
import model.Emprestimo;

/**
 * Interface para definir as operações de acesso aos dados da entidade Emprestimo.
 * Esta interface declara métodos para operações CRUD (Criar, Ler, Atualizar, Excluir) e
 * listar todos os empréstimos.
 */
public interface EmprestimoDAO {
    
    /**
     * Salva um novo empréstimo no banco de dados.
     *
     * @param emprestimo O empréstimo a ser salvo.
     */
    void salvarEmprestimo(Emprestimo emprestimo);
    
    /**
     * Atualiza um empréstimo existente no banco de dados.
     *
     * @param emprestimo O empréstimo com os novos dados a serem atualizados.
     */
    void atualizarEmprestimo(Emprestimo emprestimo);
    
    /**
     * Exclui um empréstimo do banco de dados.
     *
     * @param id O ID do empréstimo a ser excluído.
     */
    void excluirEmprestimo(int id);
    
    /**
     * Busca um empréstimo no banco de dados pelo seu ID.
     *
     * @param id O ID do empréstimo a ser buscado.
     * @return O empréstimo encontrado ou null se não for encontrado.
     */
    Emprestimo buscarEmprestimoPorId(int id);
    
    /**
     * Lista todos os empréstimos armazenados no banco de dados.
     *
     * @return Uma lista de todos os empréstimos.
     */
    List<Emprestimo> listarTodosEmprestimos();
}

