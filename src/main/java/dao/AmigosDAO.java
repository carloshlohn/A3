
package dao;


import java.util.Date;
public class AmigosDAO {
    private String nome;
    private Date data;
    private String telefone;

    
    public AmigosDAO(String nome, Date data, String telefone) {
        this.nome = nome;
        this.data = data;
        this.telefone = telefone;
    }

   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}


