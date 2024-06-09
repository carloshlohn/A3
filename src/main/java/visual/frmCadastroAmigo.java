package visual;

import javax.swing.JOptionPane;
import model.Amigo;
public class frmCadastroAmigo extends javax.swing.JFrame {

    private Amigo objetoAmigo;
    
    public frmCadastroAmigo() {
        initComponents();
           this.objetoAmigo = new Amigo("", ""); // Passe os valores desejados para nome e telefone
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFFone = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JTFId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

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
        getContentPane().add(JTFNome);
        JTFNome.setBounds(30, 190, 530, 26);

        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 170, 70, 16);
        getContentPane().add(JTFFone);
        JTFFone.setBounds(30, 250, 530, 26);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(30, 290, 90, 27);
        getContentPane().add(JTFId);
        JTFId.setBounds(30, 130, 530, 26);

        jLabel5.setText("ID");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 230, 80, 16);

        pack();
    }// </editor-fold>                        

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                            

        try {
            String nome = "";
            String fone = "";
            String id = "";
            if (this.JTFNome.getText().length() < 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNome.getText();
            }
            if (this.JTFFone.getText().length() < 2) {
                throw new Mensagem("Telefone deve conter ao menos 2 caracteres.");
            } else {
                fone = this.JTFFone.getText();
            }
            if (this.JTFId.getText().length() < 2) {
                throw new Mensagem("ID deve conter ao menos 2 caracteres.");
            } else {
                id = this.JTFId.getText();
            }
            // envia os dados para o Controlador cadastrar
            if (this.objetoAmigo.insertAmigoBD(id, nome, fone)) {
                JOptionPane.showMessageDialog(null, "Amigo Cadastrado com Sucesso!");
                // limpa campos da interface
                this.JTFNome.setText("");
                this.JTFFone.setText("");
                this.JTFId.setText("");
            }
            // Exibindo no console o amigo cadastrado
            System.out.println(this.objetoAmigo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");               
    }                                           
      }
    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

 
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFFone;
    private javax.swing.JTextField JTFId;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration                   
}
