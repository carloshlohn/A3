package principal;

import model.Amigo;
import model.Ferramenta;
import javax.swing.*;
import visual.frmCadastroAmigo;
import visual.frmCadastroFerramenta;
import visual.frmMenuPrincipal;

public class Principal {
    public static void main(String[] args) {
    
    frmMenuPrincipal objetoTela0 = new frmMenuPrincipal();
    objetoTela0.setVisible(true);
        
    frmCadastroFerramenta objetoTela = new frmCadastroFerramenta();
    objetoTela.setVisible(true);
        
    frmCadastroAmigo objetoTela1 = new frmCadastroAmigo();
    objetoTela1.setVisible(true);
        
    //Amigo amigos = new Amigo();
    //Ferramenta cadastro = new Ferramenta();
    
    //amigos.leitura();
    //cadastro.leitura();
    
    //amigos.imprimir();
    //cadastro.imprimir();
}
}
