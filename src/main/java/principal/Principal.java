package principal;

import model.Amigos;
import model.Ferramenta;
import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
           
    Amigos amigos = new Amigos();
    Ferramenta cadastro = new Ferramenta();
    
    amigos.leitura();
    cadastro.leitura();
    
    amigos.imprimir();
    cadastro.imprimir();
}
}
