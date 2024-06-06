/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visual;
import javax.swing.JOptionPane;
import model.Amigo;
public class frmCadastroAmigo extends javax.swing.JFrame {

 
    public frmCadastroAmigo() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JBCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFFone = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\cdferramenta.png")); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCadastrar);
        JBCadastrar.setBounds(30, 70, 100, 23);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Cadastro Amigo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, -10, 330, 80);

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 140, 16);
        getContentPane().add(JTFNome);
        JTFNome.setBounds(30, 140, 530, 22);

        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 70, 16);
        getContentPane().add(JTFFone);
        JTFFone.setBounds(30, 200, 530, 22);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(30, 260, 90, 23);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cdAmigo.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -20, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed

        System.out.println("Action performed: " + evt.getActionCommand());
        Amigo novoAmigo = new Amigo ();
        

        novoAmigo.setNome(JTFNome.getText());
        novoAmigo.setFone(JTFFone.getText());
        
         JOptionPane.showMessageDialog(this, "Amigo cadastrado com sucesso!");
         JTFNome.setText("");
         JTFFone.setText("");
         
          
        
       
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        System.out.println("Action performed: " + evt.getActionCommand());
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

 
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
            java.util.logging.Logger.getLogger(frmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadastroAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmCadastroAmigo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFFone;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
