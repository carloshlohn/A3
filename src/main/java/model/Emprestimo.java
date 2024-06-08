package model;

import java.util.Date;

/**
 * Classe que representa um Empréstimo no sistema.
 */
public class Emprestimo {
    private String status;
    private String observacao;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String resultado;
    private Ferramenta ferramenta;
    private Amigo amigo;

    /**
     * Construtor com parâmetros.
     *
     * @param status         O status do empréstimo (por exemplo, "emprestado", "devolvido").
     * @param observacao     Observações sobre o empréstimo.
     * @param dataEmprestimo A data do empréstimo.
     * @param dataDevolucao  A data de devolução do empréstimo.
     * @param resultado      O resultado do empréstimo (por exemplo, "aprovado", "reprovado").
     */
    public Emprestimo(String status, String observacao, Date dataEmprestimo, Date dataDevolucao, String resultado) {
        this.status = status;
        this.observacao = observacao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.resultado = resultado;
    }

    /**
     * Construtor que inicializa um empréstimo com uma ferramenta específica.
     *
     * @param ferramenta A ferramenta emprestada.
     */
    public Emprestimo(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    /**
     * Construtor que inicializa um empréstimo com um amigo específico.
     *
     * @param amigo O amigo que emprestou a ferramenta.
     */
    public Emprestimo(Amigo amigo) {
        this.amigo = amigo;
    }

    /**
     * Construtor não suportado.
     *
     * @param aInt   Parâmetro não utilizado.
     * @param aInt0  Parâmetro não utilizado.
     * @param date   Parâmetro não utilizado.
     * @param date0  Parâmetro não utilizado.
     */
    public Emprestimo(int aInt, int aInt0, java.sql.Date date, java.sql.Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); // Método gerado automaticamente
    }

    /**
     * Retorna o status do empréstimo.
     *
     * @return O status do empréstimo.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do empréstimo.
     *
     * @param status O status do empréstimo.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna as observações sobre o empréstimo.
     *
     * @return As observações sobre o empréstimo.
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define as observações sobre o empréstimo.
     *
     * @param observacao As observações sobre o empréstimo.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Retorna a data do empréstimo.
     *
     * @return A data do empréstimo.
     */
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    /**
     * Define a data do empréstimo.
     *
     * @param dataEmprestimo A data do empréstimo.
     */
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    /**
     * Retorna a data de devolução do empréstimo.
     *
     * @return A data de devolução do empréstimo.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data de devolução do empréstimo.
     *
     * @param dataDevolucao A data de devolução do empréstimo.
     */
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Retorna o resultado do empréstimo.
     *
     * @return O resultado do empréstimo.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define o resultado do empréstimo.
     *
     * @param resultado O resultado do empréstimo.
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Retorna o amigo associado ao empréstimo.
     *
     * @return O amigo associado ao empréstimo.
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /**
     * Retorna a ferramenta associada ao empréstimo.
     *
     * @return A ferramenta associada ao empréstimo.
     */
    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    /**
     * Retorna uma representação textual do empréstimo.
     *
     * @return Uma string que representa o empréstimo.
     */
    @Override
    public String toString() {
        return "Emprestimo{" +
                "status='" + status + '\'' +
                ", observacao='" + observacao + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
