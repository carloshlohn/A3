package model;

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
        this(0,"","",0.0);
    }
    
    /**
    * Construtor com parâmetros da classe Ferramenta.
    * @param id O identificador único da classe Ferramenta.
    * @param nome O nome da ferramenta.
    * @param marca A marca da Ferramenta.
    * @param custo O Custo de aquisição da ferramenta.
    */
    public Ferramenta(int id, String nome, String marca, Double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
    }
    
    
    /**
    * Obtém o id único da ferramenta
    * @return O id único da ferramenta.
    */
    public int getId() {
        return id;
    }
    /**
    * Define o id da ferramenta
    * @param id O id da ferramenta.
    */
    public void setId(int id) {
        this.id = id;
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
    
    //public void leitura() {
       //setNome(JOptionPane.showInputDialog("Digite o nome da ferramenta: "));
       //setMarca(JOptionPane.showInputDialog("Digite a marca do equipamento: "));
       //setCusto(Double.valueOf(JOptionPane.showInputDialog("Digite o custo da ferramenta: ")));  
    //}    
    
    /**
     * Retorna uma representação em forma de string desta ferramenta.
     * 
     * @return Uma string contendo o nome, a marca e o custo desta ferramenta.
     */
    @Override
    public String toString () {
        return "Ferramenta: " + getNome() + "\nMarca: " + getMarca() + "\nCusto: " + getCusto();
        
    }
}

