package model;

import javax.swing.JOptionPane;

public class Cadastro {
    private String nome;
    private String marca;
    private Double custo;
    
    public Cadastro() {
        this("","",0.0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
    public Cadastro(String nome, String marca, Double custo) {
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
    }
    public void leitura() {
       setNome(JOptionPane.showInputDialog("Digite o nome da ferramenta: "));
       setMarca(JOptionPane.showInputDialog("Digite a marca do equipamento: "));
       setCusto(Double.parseDouble(JOptionPane.showInputDialog("Digite o custo da ferramenta: ")));  
    }    
    public void imprimir() {
        JOptionPane.showMessageDialog(null,"Ferramenta: " + getNome() + "\nMarca: " + getMarca() + "\nCusto: " + getCusto());
    }
}

