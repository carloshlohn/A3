package principal;


import visual.frmCadastroAmigoc;
import visual.frmCadastroFerramenta;
import visual.frmGerenciaAmigo;
import visual.frmGerenciaEmprestimo;
import visual.frmGerenciaFerramenta;
import visual.frmMenuPrincipal;

public class Principal {
    public static void main(String[] args) {
        
           //Feat menu
           frmMenuPrincipal telaMenu = new frmMenuPrincipal();
           //Torna a janela visível
           telaMenu.setVisible(true);
           
           //Feat cadastro ferramenta
           frmCadastroFerramenta telaCadFerr = new frmCadastroFerramenta();
           //Torna a janela visível
           telaCadFerr.setVisible(true);
           
           //Feat gerenciamento de amigos
           frmGerenciaAmigo telaGerAmg = new frmGerenciaAmigo();
           //Torna a janela visível
           telaGerAmg.setVisible(true);
           
           //Feat gerenciamento de emprestimos
           frmGerenciaEmprestimo telaGerEmp = new frmGerenciaEmprestimo();
           //Torna a janela visível
           telaGerEmp.setVisible(true);
           
           //Feat gerenciamento de ferramentas
           frmGerenciaFerramenta telaGerFerr = new frmGerenciaFerramenta();
           //Torna a janela visível           
           telaGerFerr.setVisible(true);
           
           //Feat cadastro de amigos
           frmCadastroAmigoc telaCadAmg = new frmCadastroAmigoc();
           //Torna a janela visível
           telaCadAmg.setVisible(true);

}
}
