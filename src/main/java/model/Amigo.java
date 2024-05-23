package model;

import javax.swing.*;

public class Amigo {
    private int id;
    private String nome;
    private String fone;

    public Amigo() {
        this(0,"","");
    }
    public Amigo(int id, String nome, String fone) {
        this.id= id;
        this.nome = nome;
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return "Nome: " + getNome() + "\nTelefone: " + getFone();
        
    }
}
