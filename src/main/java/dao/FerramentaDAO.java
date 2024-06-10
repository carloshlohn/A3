package dao;

import java.util.List;
import model.Ferramenta;

/**
 * Interface FerramentaDAO define as operações de persistência para a entidade Ferramenta.
 */
public interface FerramentaDAO {

    /**
     * Salva uma nova ferramenta no repositório.
     * 
     * @param ferramenta A ferramenta a ser salva.
     */
    void salvarFerramenta(Ferramenta ferramenta);

    /**
     * Atualiza uma ferramenta existente no repositório.
     * 
     * @param ferramenta A ferramenta com os dados atualizados.
     */
    void atualizarFerramenta(Ferramenta ferramenta);

    /**
     * Exclui uma ferramenta do repositório com base no ID.
     * 
     * @param id O identificador único da ferramenta a ser excluída.
     */
    void excluirFerramenta(int id);

    /**
     * Busca uma ferramenta no repositório com base no ID.
     * 
     * @param id O identificador único da ferramenta a ser buscada.
     * @return A ferramenta correspondente ao ID fornecido, ou null se não encontrada.
     */
    Ferramenta buscarFerramentaPorId(int id);

    /**
     * Lista todas as ferramentas disponíveis no repositório.
     * 
     * @return Uma lista de todas as ferramentas.
     */
    List<Ferramenta> listarTodasFerramentas();
}
