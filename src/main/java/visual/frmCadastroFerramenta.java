package visual;
import model.Ferramenta;
import dao.FerramentaDAOimpl;
import javax.swing.JOptionPane;
import model.Ferramenta;
import visual.frmGerenciaFerramenta;

public class frmCadastroFerramenta extends javax.swing.JFrame {

    private Ferramenta objetoFerramenta;

    public frmCadastroFerramenta() {
        initComponents();
        this.objetoFerramenta = new Ferramenta("", "", 0.0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents                         
    private void initComponents() {

        JBCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTFCusto = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCadastrar);
        JBCadastrar.setBounds(30, 70, 100, 27);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Cadastro Ferramenta");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, -10, 330, 80);

        jLabel2.setText("Ferramenta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 140, 16);
        getContentPane().add(JTFFerramenta);
        JTFFerramenta.setBounds(30, 140, 530, 26);

        jLabel4.setText("Marca");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 37, 16);

        JTFMarca.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(JTFMarca);
        JTFMarca.setBounds(30, 200, 530, 26);

        jLabel5.setText("Custo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 240, 80, 16);
        getContentPane().add(JTFCusto);
        JTFCusto.setBounds(30, 260, 530, 26);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(30, 390, 80, 27);

        jLabel1.setText("ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 300, 40, 16);
        getContentPane().add(JTFId);
        JTFId.setBounds(30, 320, 530, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents                  

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                            
      Ferramenta f = new Ferramenta();
     FerramentaDAOimpl dao = new FerramentaDAOimpl();
     f.setNome(JTFFerramenta.getText());
     f.setMarca(JTFMarca.getText());
     f.setCusto(Double.parseDouble(JTFCusto.getText()));
     f.setId(Integer.parseInt(JTFId.getText()));
    
    dao.salvarFerramenta(f);
    
     frmGerenciaFerramenta gerenciaFerramenta = new frmGerenciaFerramenta();
    gerenciaFerramenta.atualizarTabela();
}


                                      

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Libera todos os recurso da interface gráfica
        this.dispose();
    }                                          

    private void JTFMarcaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

  
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
        }
        //</editor-fold>

        /* Create and display the form */
          java.awt.EventQueue.invokeLater(() -> {
            new frmCadastroFerramenta().setVisible(true);
            });
        }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFId;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration                   



}
