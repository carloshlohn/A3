package principal;

import model.Amigos;
import model.Cadastro;
import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
           
    Amigos amigos = new Amigos();
    Cadastro cadastro = new Cadastro();
    
    amigos.leitura();
    cadastro.leitura();
    
    amigos.imprimir();
    cadastro.imprimir();
}
}
