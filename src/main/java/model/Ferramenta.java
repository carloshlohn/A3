package model;

import javax.swing.JOptionPane;
/**
* A classe ferramenta representa uma ferramenta disponível para empréstimo.
* Ela contém informações sobre o nome, marca e custo de aquisição. 
*/
public class Ferramenta {
    /** 
    * Identificador da Ferramenta.
    */
    private int id;
    /**
    * Nome da Ferramenta.
    */
    private String nome;
     /**
    * Marca da Ferramenta.
    */
    private String marca;
     /**
    * Custo de aquisição da Ferramenta.
    */
    private Double custo;
     /**
    * Construtor padrão da classe Ferramenta.
    */
    public Ferramenta() {
        this("","",0.0);
    }
    /**
    * Obtém o nome da ferramenta
    * @return O nome da ferramenta.
    */
    public String getNome() {
        return nome;
    }
    /**
    * Define o nome da ferramenta
    * @param nome O nome da ferramenta.
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
    * Obtém a marca da ferramenta
    * @return a marca da ferramenta.
    */
    public String getMarca() {
        return marca;
    }
    /**
    * Define a marca da ferramenta
    * @param marca A marca da ferramenta.
    */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
    * Obtém o custo de aquisição da ferramenta
    * @return O custo da ferramenta.
    */
    public Double getCusto() {
        return custo;
    }
    /**
    * Define o custo de aquisição da ferramenta
    * @param custo O custo da ferramenta.
    */
    public void setCusto(Double custo) {
        this.custo = custo;
    }
    /**
    * Construtor com parâmetros da classe Ferramenta.
    * @param id O identificador único da classe Ferramenta.
    * @param nome O nome da ferramenta.
    * @param marca A marca da Ferramenta.
    * @param custo O Custo de aquisição da ferramenta.
    */
    public Ferramenta(String nome, String marca, Double custo) {
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

   
