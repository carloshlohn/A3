package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Ferramenta {

     private List<Ferramenta> listaFerramentas;

    public Ferramenta() {
        this.listaFerramentas = new ArrayList<>();
    }
    
    public boolean insertFerramentaBD(String nome, String fone, Double custo) {
        // Simulating database insert operation
        try {
            Ferramenta novoFerramenta = new Ferramenta(nome, marca, custo);
            listaFerramentas.add(novoFerramenta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
            
    private String ferramenta;
    private String marca;
    private Double custo;
    
    public Ferramenta(int par, String martelo, String marcaA, double par1) {
        this("","",0.0);
    }
  public List<Ferramenta> getMinhaLista() {
        return listaFerramentas;
  }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setNome(String ferramenta) {
        this.ferramenta = ferramenta;
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
    public Ferramenta(String ferramenta, String marca, Double custo) {
        this.ferramenta = ferramenta;
        this.marca = marca;
        this.custo = custo;
    }
    public void leitura() {
       setNome(JOptionPane.showInputDialog("Digite o nome da ferramenta: "));
       setMarca(JOptionPane.showInputDialog("Digite a marca do equipamento: "));
       setCusto(Double.parseDouble(JOptionPane.showInputDialog("Digite o custo da ferramenta: ")));  
    }
    public void imprimir() {
        JOptionPane.showMessageDialog(null,"Ferramenta: " + getFerramenta() + "\nMarca: " + getMarca() + "\nCusto: " + getCusto());
    }

 public Integer getId() {
    // Retornar o ID da ferramenta
    return null;
}

public boolean updateFerramentaBD(int id, String ferramenta, String marca, double custo) {
    // Atualizar a ferramenta no banco de dados com base no ID
    return false;
}

public boolean deleteFerramentaBD(int id) {
    // Deletar a ferramenta do banco de dados com base no ID
    return false;
}

public boolean updateFerramentaBD(String ferramenta, String marca, double custo) {
    // Atualizar todas as ferramentas no banco de dados com os novos valores
    return false;
}
    }
