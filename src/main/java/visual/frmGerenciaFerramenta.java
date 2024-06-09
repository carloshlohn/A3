package visual;

import dao.FerramentaDAOimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Ferramenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class frmGerenciaFerramenta extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Ferramenta objetoFerramenta;
    
    public frmGerenciaFerramenta() {
        initComponents();
        this.tableModel = (DefaultTableModel) JTableFerramentas.getModel();  
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents              
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        JTFCusto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableFerramentas = new javax.swing.JTable();
        JBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Gerenciamento Ferramenta");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 330, 80);

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(JBAlterar);
        JBAlterar.setBounds(520, 80, 76, 27);

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });
        getContentPane().add(JBApagar);
        JBApagar.setBounds(610, 80, 76, 27);

        jLabel2.setText("Marca:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 170, 36, 16);
        getContentPane().add(JTFFerramenta);
        JTFFerramenta.setBounds(520, 140, 130, 26);

        jLabel4.setText("Ferramenta:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 110, 70, 20);
        getContentPane().add(JTFMarca);
        JTFMarca.setBounds(520, 190, 130, 26);
        getContentPane().add(JTFCusto);
        JTFCusto.setBounds(520, 240, 130, 26);

        jLabel6.setText("Custo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 220, 34, 16);

        JTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ferramenta", "Marca", "Custo", "ID"
            }
        ));
        JTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableFerramentas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(16, 86, 456, 330);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(520, 340, 80, 27);

        jLabel1.setText("ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 270, 60, 16);
        getContentPane().add(JTFId);
        JTFId.setBounds(520, 290, 130, 26);

        pack();
    }// </editor-fold>//GEN-END:initComponents                         

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            // recebendo e validando dados da interface gráfica.
            String ferramenta = "";
            String marca = "";
            double custo = 0.0;
            int id = 0;

            if (this.JTFFerramenta.getText().length() < 2) {
                throw new Mensagem("Ferramenta deve conter ao menos 2 caracteres.");
            } else {
                ferramenta = this.JTFFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() < 2) {
                throw new Mensagem("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFCusto.getText().length() <= 0) {
                throw new Mensagem("Custo deve ser número e maior que zero.");
            } else {
                custo = Double.parseDouble(this.JTFCusto.getText());
            }
            if (this.JTFId.getText().length() <= 0) {
                throw new Mensagem("Custo deve ser número e maior que zero.");
            } else {
                id = Integer.parseInt(this.JTFId.getText());
            }
            // envia os dados para o Ferramenta processar
            if (this.objetoFerramenta.updateFerramentaBD(id, ferramenta, marca, custo)) {
                // limpa os campos
                this.JTFFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                this.JTFId.setText("");
                JOptionPane.showMessageDialog(rootPane, "Ferramenta Alterada com Sucesso!");
            }
            // Exibe no console a ferramenta cadastrada
            System.out.println(this.objetoFerramenta.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } finally {
            // atualiza a tabela.
            atualizarTabela();
        }
    }                                         

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    FerramentaDAOimpl dao = new FerramentaDAOimpl();
    
    int index = JTableFerramentas.getSelectedRow();
    if (index != -1) { // Verifica se algum item está selecionado na tabela
        Ferramenta f = dao.listarTodasFerramentas().get(index);
        dao.excluirFerramenta(f.getId());
        atualizarTabela();
    } else {
        JOptionPane.showMessageDialog(null, "Selecione uma ferramenta para excluir.");
    }
}     
                                

    private void JTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {                                               

        jScrollPane1.setViewportView(JTableFerramentas);
        JTableFerramentas.getColumnModel().getColumn(0).setPreferredWidth(30);
        JTableFerramentas.getColumnModel().getColumn(1).setPreferredWidth(120);
        JTableFerramentas.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTableFerramentas.getColumnModel().getColumn(3).setPreferredWidth(80);

        JTableFerramentas.getColumnModel().getColumn(0).setMaxWidth(30);
        JTableFerramentas.getColumnModel().getColumn(1).setMaxWidth(120);
        JTableFerramentas.getColumnModel().getColumn(2).setMaxWidth(80);
        JTableFerramentas.getColumnModel().getColumn(3).setMaxWidth(80);

        JTableFerramentas.getColumnModel().getColumn(0).setMinWidth(30);
        JTableFerramentas.getColumnModel().getColumn(1).setMinWidth(100);
        JTableFerramentas.getColumnModel().getColumn(2).setMinWidth(100);
        JTableFerramentas.getColumnModel().getColumn(3).setMinWidth(100);

        int selectedRow = this.JTableFerramentas.getSelectedRow();
        if (selectedRow != -1) {
            String ferramenta = getValueFromSelectedRow(selectedRow, 0);
            String marca = getValueFromSelectedRow(selectedRow, 1);
            String custo = getValueFromSelectedRow(selectedRow, 2);
            String id = getValueFromSelectedRow(selectedRow, 3);
            this.JTFFerramenta.setText(ferramenta);
            this.JTFMarca.setText(marca);
            this.JTFCusto.setText(custo);
            this.JTFId.setText(id);
        }
}

    private String getValueFromSelectedRow(int row, int column) {
        Object value = this.JTableFerramentas.getValueAt(row, column);
        return (value != null) ? value.toString() : "";

    }                                              

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Libera todos os recurso da interface gráfica
        this.dispose();
    }                                          

    /**
     * @param args the command line arguments
     */
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
        java.util.logging.Logger.getLogger(frmGerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(frmGerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(frmGerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(frmGerenciaFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        new frmGerenciaFerramenta().setVisible(true);
    });
}
        public void atualizarTabela() {
    DefaultTableModel modelo = (DefaultTableModel) JTableFerramentas.getModel();
    modelo.setNumRows(0);
   

    FerramentaDAOimpl dao = new FerramentaDAOimpl();

    for (Ferramenta f : dao.listarTodasFerramentas()) {
        modelo.addRow(new Object[]{
            f.getFerramenta(),
            f.getMarca(),
            f.getCusto(),
            f.getId()

        });
    }
}
       
    

    // Método para atualizar a tabela com uma lista de ferramentas
    public void atualizarTabela(List<Ferramenta> listaFerramentas) {
        // Limpa todas as linhas existentes na tabela
        tableModel.setRowCount(0);

        // Adiciona as ferramentas à tabela
        for (Ferramenta ferramenta : listaFerramentas) {
            tableModel.addRow(new Object[]{
                ferramenta.getFerramenta(),
                ferramenta.getMarca(),
                ferramenta.getCusto(),
                ferramenta.getId()
            });
        }
    }
        

        


    // Variables declaration - do not modify                     
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFId;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTable JTableFerramentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   

 
    }
