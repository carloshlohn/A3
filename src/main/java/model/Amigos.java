package model;

import javax.swing.*;

public class Amigos {
    private String nome;
    private String fone;

    public Amigos() {
        this("","");
    }
    public Amigos(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    public void leitura() {
        setNome(JOptionPane.showInputDialog("Digite seu nome: "));
        setFone(JOptionPane.showInputDialog("Digite seu telefone: "));
    }
    public void imprimir() {
        JOptionPane.showMessageDialog(null, "Nome: " + getNome() + "\nTelefone: " + getFone());
    }
}
