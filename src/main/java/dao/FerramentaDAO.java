package dao;

import java.util.List;
import model.Ferramenta;
/**
* (DAO) para a entidade ferramenta.
* Classe responsável por operações de CRUD como o banco de dados. 
*
*/
public interface FerramentaDAO {
    /*
    * salvar uma nova ferramenta no banco de dados.
    *
    */
    void salvarFerramenta(Ferramenta ferramenta);
    /*
    * atualizar= uma ferramenta existente no banco de dados.
    *
    */
    void atualizarFerramenta(Ferramenta ferramenta);
    /*
    * exclui uma ferramenta do banco de dados.
    *
    */
    void excluirFerramenta(int id);
    /*
    * Lista todas as ferramentas no banco de dados.
    *
    */
    List <Ferramenta> 
    listarTodasFerramentas();
}
