package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import model.Emprestimo;
/**
 *
 * @author Asus
 */
public class frmGerenciaEmprestimo extends javax.swing.JFrame {

    /**
     * Creates new form frmGerenciaEmprestimo
     */
    public frmGerenciaEmprestimo() {
        initComponents();
        carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableEmprestimos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        JTFAmigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFFerramenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendarEmprestimo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jCalendarDevolucao = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        JTFStatus = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("Gerenciamento de Empréstimo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, -10, 410, 80);

        JTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ferrameta", "Amigo", "Data Empréstimo", "Data Devolução", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableEmprestimos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 510, 330);

        jLabel6.setText("Data Empréstimo:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 470, 100, 16);
        getContentPane().add(JTFAmigo);
        JTFAmigo.setBounds(170, 490, 130, 26);

        jLabel4.setText("Amigo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 470, 50, 16);
        getContentPane().add(JTFFerramenta);
        JTFFerramenta.setBounds(20, 490, 130, 26);

        jLabel5.setText("Ferramenta:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 470, 70, 20);

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(JBAlterar);
        JBAlterar.setBounds(560, 60, 80, 27);

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });
        getContentPane().add(JBApagar);
        JBApagar.setBounds(560, 100, 80, 27);
        getContentPane().add(jCalendar1);
        jCalendar1.setBounds(680, 60, 170, 110);
        getContentPane().add(jCalendarEmprestimo);
        jCalendarEmprestimo.setBounds(320, 490, 137, 26);

        jLabel1.setText("Data Devolução:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 470, 90, 16);
        getContentPane().add(jCalendarDevolucao);
        jCalendarDevolucao.setBounds(480, 490, 137, 26);

        jLabel7.setText("Status:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(650, 470, 34, 16);
        getContentPane().add(JTFStatus);
        JTFStatus.setBounds(650, 490, 130, 26);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JBCancelar);
        JBCancelar.setBounds(560, 140, 80, 27);

        pack();
    }// </editor-fold>                        

    private void JTableEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {                                               

         if (this.JTableEmprestimos.getSelectedRow() != -1) {
            String ferramenta = this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 0).toString();
            String amigo = this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 1).toString();
            Date dataEmprestimo = (Date) this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 2);
            Date dataDevolucao = (Date) this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 3);
            String status = this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 4).toString();

            this.JTFFerramenta.setText(ferramenta);
            this.JTFAmigo.setText(amigo);
            this.jCalendarEmprestimo.setDate(dataEmprestimo);
            this.jCalendarDevolucao.setDate(dataDevolucao);
            this.JTFStatus.setText(status);
        }
        
    }                                              

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            String ferramenta = this.JTFFerramenta.getText();
            String amigo = this.JTFAmigo.getText();
            Date dataEmprestimo = this.jCalendarEmprestimo.getDate();
            Date dataDevolucao = this.jCalendarDevolucao.getDate();
            String status = this.JTFStatus.getText();

            if (ferramenta.isEmpty() || amigo.isEmpty() || dataEmprestimo == null || dataDevolucao == null || status.isEmpty()) {
                throw new Mensagem("Todos os campos devem ser preenchidos.");
            }

            if (this.JTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro selecione um empréstimo para alterar.");
            }

            int id = Integer.parseInt(this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 0).toString());

            // Lógica para alterar o empréstimo no banco de dados.
            if (updateEmprestimoBD(id, ferramenta, amigo, dataEmprestimo, dataDevolucao, status)) {
                JOptionPane.showMessageDialog(null, "Empréstimo alterado com sucesso!");
                limpaCampos();
                carregaTabela();
            }

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
    }                                         

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {                                         
            
        
        
            try {
            if (this.JTableEmprestimos.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro selecione um empréstimo para apagar.");
            }

            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este empréstimo?");

            if (respostaUsuario == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(this.JTableEmprestimos.getValueAt(this.JTableEmprestimos.getSelectedRow(), 0).toString());

                // Lógica para deletar o empréstimo do banco de dados.
                if (deleteEmprestimoBD(id)) {
                     JOptionPane.showMessageDialog(rootPane, "Empréstimo apagado com sucesso!");
                    limpaCampos();
                    carregaTabela();
                }
            }
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }                                        

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       this.dispose();
    }                                          
        private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTableEmprestimos.getModel();
        modelo.setRowCount(0);

        ArrayList<Emprestimo> listaEmprestimos = obterEmprestimos();

        for (Emprestimo e : listaEmprestimos) {
            modelo.addRow(new Object[]{e.getFerramenta(), e.getAmigo(), e.getDataEmprestimo(), e.getDataDevolucao(), e.getStatus()});
        }
    }
        private void limpaCampos() {
        this.JTFFerramenta.setText("");
        this.JTFAmigo.setText("");
        this.jCalendarEmprestimo.setDate(null);
        this.jCalendarDevolucao.setDate(null);
        this.JTFStatus.setText("");
        }
        
        private ArrayList<Emprestimo> obterEmprestimos() {
        // Simulando a obtenção de dados de um banco de dados.
        ArrayList<Emprestimo> listaEmprestimos = new ArrayList<>();
        listaEmprestimos.add(new Emprestimo("", "", new Date(), new Date(), "Em andamento"));
        listaEmprestimos.add(new Emprestimo("", "", new Date(), new Date(), "Concluído"));
        return listaEmprestimos;
    }

    private boolean updateEmprestimoBD(int id, String ferramenta, String amigo, Date dataEmprestimo, Date dataDevolucao, String status) {
        // Implemente aqui a lógica para atualizar o empréstimo no banco de dados.
        return true;
    }

    private boolean deleteEmprestimoBD(int id) {
        // Implemente aqui a lógica para deletar o empréstimo do banco de dados.
        return true;
    }

    private class Mensagem extends Exception {
        public Mensagem(String message) {
            super(message);
        }
    }   

        /* Create and display the form */
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmGerenciaEmprestimo().setVisible(true));
            }
        
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFAmigo;
    private javax.swing.JTextField JTFFerramenta;
    private javax.swing.JTextField JTFStatus;
    private javax.swing.JTable JTableEmprestimos;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jCalendarDevolucao;
    private com.toedter.calendar.JDateChooser jCalendarEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
        }
