package model;

import java.util.Date;

/**
 * Classe que representa um Empréstimo no sistema.
 */
public class Emprestimo {
    private int id;
    private int idFerramenta;
    private int idAmigo;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String status;

    /**
     * Construtor padrão.
     */
    public Emprestimo() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param id O ID do empréstimo.
     * @param idFerramenta O ID da ferramenta emprestada.
     * @param idAmigo O ID do amigo que fez o empréstimo.
     * @param dataEmprestimo A data do empréstimo.
     * @param dataDevolucao A data de devolução do empréstimo.
     * @param status O status do empréstimo (por exemplo, "emprestado", "devolvido").
     */
    public Emprestimo(int id, int idFerramenta, int idAmigo, Date dataEmprestimo, Date dataDevolucao, String status) {
        this.id = id;
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public Emprestimo(int aInt, int aInt0, int aInt1, java.sql.Date date, java.sql.Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    // Getters e Setters

    /**
     * Obtém o ID do empréstimo.
     *
     * @return O ID do empréstimo.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do empréstimo.
     *
     * @param id O novo ID do empréstimo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o ID da ferramenta emprestada.
     *
     * @return O ID da ferramenta emprestada.
     */
    public int getIdFerramenta() {
        return idFerramenta;
    }

    /**
     * Define o ID da ferramenta emprestada.
     *
     * @param idFerramenta O novo ID da ferramenta emprestada.
     */
    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    /**
     * Obtém o ID do amigo que fez o empréstimo.
     *
     * @return O ID do amigo que fez o empréstimo.
     */
    public int getIdAmigo() {
        return idAmigo;
    }

    /**
     * Define o ID do amigo que fez o empréstimo.
     *
     * @param idAmigo O novo ID do amigo que fez o empréstimo.
     */
    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    /**
     * Obtém a data do empréstimo.
     *
     * @return A data do empréstimo.
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param dataEmprestimo A nova data do empréstimo.
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Obtém a data de devolução do empréstimo.
     *
     * @return A data de devolução do empréstimo.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data de devolução do empréstimo.
     *
     * @param dataDevolucao A nova data de devolução do empréstimo.
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Obtém o status do empréstimo.
     *
     * @return O status do empréstimo.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do empréstimo.
     *
     * @param status O novo status do empréstimo.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método toString para facilitar a visualização dos dados de um empréstimo.
     *
     * @return Uma representação em string do empréstimo.
     */
    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", idFerramenta=" + idFerramenta +
                ", idAmigo=" + idAmigo +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", status='" + status + '\'' +
                '}';
    }

}
