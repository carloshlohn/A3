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
    public Emprestimo(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }
    public Emprestimo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Emprestimo(int aInt, int aInt0, java.sql.Date date, java.sql.Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }


    public Amigo getAmigo() {
        return this.amigo;
    }

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

    public Ferramenta getFerramenta() {
        return this.ferramenta;
    }
}
