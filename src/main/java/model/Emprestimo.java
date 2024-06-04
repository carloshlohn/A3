package model;

import javax.swing.JOptionPane;

public class Emprestimo {
    
    private String dataAquisicao;
    private String dataDevolucao;
    
    public Emprestimo() {
        this("","");
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(String dataAquisicao, String dataDevolucao) {
        this.dataAquisicao = dataAquisicao;
        this.dataDevolucao = dataDevolucao;
    }
    public void leitura() {
        setDataAquisicao(JOptionPane.showInputDialog("Digite a data de aquisicao (no formato XX/XX/XXXX): "));
        setDataDevolucao(JOptionPane.showInputDialog("Digite a data de devolucao (no formato XX/XX/XXXX): "));
    }
    public void imprimir() {
        JOptionPane.showMessageDialog(null, "Aquisição: " + getDataAquisicao() + "\nDevolução: " + getDataDevolucao());
    }
}
