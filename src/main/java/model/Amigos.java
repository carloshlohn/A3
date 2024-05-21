package model;

import javax.swing.*;
/**
* A classe amigo representa um amigo que realiza empréstimos.
* Contém atributos que são o nome e o telefone.
*/
public class Amigos {
    private String nome;
    private String fone;
/**
* Construtor padrão da classe Amigo.
*
*/
    public Amigos() {
        this("","");
    }
/**
* Construtor com parâmetros da classe Amigo.
* @param nome O nome do Amigo.
* @param o número de telefone do Amigo.
*/
    public Amigos(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }
/**
* Obtém o nome do amigo.
*
*/
    public String getNome() {
        return nome;
    }
/**
* Define o nome do amigo.
*
*/
    public void setNome(String nome) {
        this.nome = nome;
    }
/**
* Obtém o número de telefone do amigo.
*
*/
    public String getFone() {
        return fone;
    }
/**
* Define o número de telefone do amigo
*
*/
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
