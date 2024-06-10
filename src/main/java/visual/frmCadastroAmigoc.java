package visual;

import javax.swing.JOptionPane;
import model.Amigo;
import dao.AmigoDAOimpl;

/**
 *
 * @author User
 */
public class frmCadastroAmigoc extends javax.swing.JFrame {

    private Amigo objetoAmigo;
    private AmigoDAOimpl amigoDAO;

    /**
     * Creates new form frmGerenciaAmigos
     */
    public frmCadastroAmigoc() {
        initComponents();
        this.objetoAmigo = new Amigo();
        this.amigoDAO = new AmigoDAOimpl();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JBCancelar = new javax.swing.JButton();
        JTFNome = new javax.swing.JTextField();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCadastrar);
        JBCadastrar.setBounds(30, 70, 100, 27);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Cadastro Amigo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, -10, 330, 80);

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 140, 16);
        getContentPane().add(JTFTelefone);
        JTFTelefone.setBounds(30, 190, 530, 26);

        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 170, 70, 16);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(30, 230, 90, 27);
        getContentPane().add(JTFNome);
        JTFNome.setBounds(30, 130, 530, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed

        try {
            String nome = "";
            String fone = "";
            if (this.JTFNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNome.getText();
            }
            if (this.JTFTelefone.getText().length() < 2) {
                throw new Mensagem("Telefone deve conter ao menos 2 caracteres.");
            } else {
                fone = this.JTFTelefone.getText();
            }
            // envia os dados para o Controlador cadastrar
            Amigo novoAmigo = new Amigo();
            novoAmigo.setNome(nome);
            novoAmigo.setTelefone(fone);

            AmigoDAOimpl amigoDAO = new  AmigoDAOimpl();
            boolean inserido = amigoDAO.inserirAmigoBD(novoAmigo);

            if (inserido) {
                JOptionPane.showMessageDialog(null, "Amigo Cadastrado com Sucesso!");
                // limpa campos da interface
                this.JTFNome.setText("");
                this.JTFTelefone.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar amigo.");
            }
            // Exibindo no console o amigo cadastrado
            System.out.println(this.objetoAmigo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");        
    }//GEN-LAST:event_JBCadastrarActionPerformed
      }
    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

 
    public static void main(String  args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {
            new frmCadastroAmigoc().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
