package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe que representa uma ferramenta com atributos como nome, marca e custo.
 */
public class Ferramenta {

    private List<Ferramenta> listaFerramentas;
    private String ferramenta;
    private String marca;
    private Double custo;

    /**
     * Construtor padrão que inicializa a lista de ferramentas.
     */
    public Ferramenta() {
        this.listaFerramentas = new ArrayList<>();
    }

    /**
     * Construtor que inicializa os atributos da ferramenta.
     *
     * @param ferramenta Nome da ferramenta.
     * @param marca Marca da ferramenta.
     * @param custo Custo da ferramenta.
     */
    public Ferramenta(String ferramenta, String marca, Double custo) {
        this.ferramenta = ferramenta;
        this.marca = marca;
        this.custo = custo;
    }

    /**
     * Método que insere uma ferramenta na lista de ferramentas (simulando um banco de dados).
     *
     * @param nome Nome da ferramenta.
     * @param marca Marca da ferramenta.
     * @param custo Custo da ferramenta.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean insertFerramentaBD(String nome, String marca, Double custo) {
        try {
            Ferramenta novoFerramenta = new Ferramenta(nome, marca, custo);
            listaFerramentas.add(novoFerramenta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna a lista de ferramentas.
     *
     * @return Lista de ferramentas.
     */
    public List<Ferramenta> getMinhaLista() {
        return listaFerramentas;
    }

    /**
     * Retorna o nome da ferramenta.
     *
     * @return Nome da ferramenta.
     */
    public String getFerramenta() {
        return ferramenta;
    }

    /**
     * Define o nome da ferramenta.
     *
     * @param ferramenta Nome da ferramenta.
     */
    public void setNome(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    /**
     * Retorna a marca da ferramenta.
     *
     * @return Marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca da ferramenta.
     *
     * @param marca Marca da ferramenta.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna o custo da ferramenta.
     *
     * @return Custo da ferramenta.
     */
    public Double getCusto() {
        return custo;
    }

    /**
     * Define o custo da ferramenta.
     *
     * @param custo Custo da ferramenta.
     */
    public void setCusto(Double custo) {
        this.custo = custo;
    }

    /**
     * Construtor que inicializa a ferramenta com valores padrão.
     *
     * @param par Valor não utilizado.
     * @param martelo Nome da ferramenta.
     * @param marcaA Marca da ferramenta.
     * @param par1 Custo da ferramenta.
     */
    public Ferramenta(int par, String martelo, String marcaA, double par1) {
        this("", "", 0.0);
    }

    /**
     * Realiza a leitura dos atributos da ferramenta a partir de diálogos.
     */
    public void leitura() {
        setNome(JOptionPane.showInputDialog("Digite o nome da ferramenta: "));
        setMarca(JOptionPane.showInputDialog("Digite a marca do equipamento: "));
        setCusto(Double.parseDouble(JOptionPane.showInputDialog("Digite o custo da ferramenta: ")));
    }

    /**
     * Imprime os detalhes da ferramenta em um diálogo.
     */
    public void imprimir() {
        JOptionPane.showMessageDialog(null, "Ferramenta: " + getFerramenta() + "\nMarca: " + getMarca() + "\nCusto: " + getCusto());
    }

    /**
     * Retorna o ID da ferramenta (simulado).
     *
     * @return ID da ferramenta.
     */
    public Integer getId() {
        return null;
    }

    /**
     * Atualiza a ferramenta no banco de dados com base no ID.
     *
     * @param id ID da ferramenta.
     * @param ferramenta Novo nome da ferramenta.
     * @param marca Nova marca da ferramenta.
     * @param custo Novo custo da ferramenta.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean updateFerramentaBD(int id, String ferramenta, String marca, double custo) {
        // Atualizar a ferramenta no banco de dados com base no ID (simulado)
        return false;
    }

    /**
     * Deleta a ferramenta do banco de dados com base no ID.
     *
     * @param id ID da ferramenta.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean deleteFerramentaBD(int id) {
        // Deletar a ferramenta do banco de dados com base no ID (simulado)
        return false;
    }

    /**
     * Atualiza todas as ferramentas no banco de dados com os novos valores.
     *
     * @param ferramenta Novo nome da ferramenta.
     * @param marca Nova marca da ferramenta.
     * @param custo Novo custo da ferramenta.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean updateFerramentaBD(String ferramenta, String marca, double custo) {
        // Atualizar todas as ferramentas no banco de dados com os novos valores (simulado)
        return false;
    }
}

