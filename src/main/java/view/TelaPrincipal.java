/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TelaPrincipalController;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Strings;

/**
 *
 * @author PC
 */
public class TelaPrincipal extends javax.swing.JFrame implements AtualizarClienteTabela{

  
   private TelaPrincipalController controller = new TelaPrincipalController();
   private String idDoJTableCliente = "";
   private String idDoLTablePedido = "";
    
    
    
    public TelaPrincipal() {
        initComponents();
        CardLayout cl = (CardLayout) jPanel1.getLayout();
        cl.show(jPanel1, "bemvindo");
        
        



       
    }
    
    public void atualizarTabela(){
        
        DefaultTableModel model = (DefaultTableModel) jClienteTable.getModel();
        model.setRowCount(0);
        controller.listaClientes(jClienteTable);
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTecnico = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPedidoTecnicoTable = new javax.swing.JTable();
        jAtendente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCadastrarUs = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jClienteTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jCadastrarPedidoButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jBemOk = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuSairItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel2.setText("Técnico");

        jPedidoTecnicoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPedido", "Cliente", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jPedidoTecnicoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPedidoTecnicoTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jPedidoTecnicoTable);

        javax.swing.GroupLayout jTecnicoLayout = new javax.swing.GroupLayout(jTecnico);
        jTecnico.setLayout(jTecnicoLayout);
        jTecnicoLayout.setHorizontalGroup(
            jTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTecnicoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jTecnicoLayout.setVerticalGroup(
            jTecnicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTecnicoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jPanel1.add(jTecnico, "tecnico");
        jTecnico.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("Atendente");

        jCadastrarUs.setText("Cadastrar Cliente");
        jCadastrarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarUsActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Físico", "Jurídico" }));

        jClienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tipo", "Celular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jClienteTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClienteTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jClienteTable);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCadastrarPedidoButton.setText("Cadastrar Pedido");
        jCadastrarPedidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarPedidoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jAtendenteLayout = new javax.swing.GroupLayout(jAtendente);
        jAtendente.setLayout(jAtendenteLayout);
        jAtendenteLayout.setHorizontalGroup(
            jAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAtendenteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jAtendenteLayout.createSequentialGroup()
                            .addComponent(jCadastrarUs)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCadastrarPedidoButton))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jAtendenteLayout.setVerticalGroup(
            jAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAtendenteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jAtendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCadastrarUs)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jCadastrarPedidoButton))
                .addGap(83, 83, 83))
        );

        jPanel1.add(jAtendente, "atendente");

        jLabel3.setText("Bem Vindos");

        jBemOk.setText("Ok");
        jBemOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBemOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBemOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(440, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel3)
                .addGap(68, 68, 68)
                .addComponent(jBemOk)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, "bemvindo");

        jMenu.setText("Arquivo");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });

        jMenuSairItem.setText("Sair");
        jMenuSairItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairItemActionPerformed(evt);
            }
        });
        jMenu.add(jMenuSairItem);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairItemActionPerformed
        controller.deletarUsuarioSqlite();
        Login login = new Login();
        
        new TelaPrincipal().setVisible(false);
        login.setVisible(true);        
        
    }//GEN-LAST:event_jMenuSairItemActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void jCadastrarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarUsActionPerformed
        CadastrarClienteFisico cadastrarClienteF = new CadastrarClienteFisico();
        CadastrarClienteJuridico cadastrarClienteJ = new CadastrarClienteJuridico();
        String tipo = String.valueOf(jComboBox1.getSelectedItem());
        
        if(tipo.equals("Físico")){
            cadastrarClienteF.setVisible(true);
           
            
        }else{
            cadastrarClienteJ.setVisible(true);
            
        }
        
    }//GEN-LAST:event_jCadastrarUsActionPerformed

    private void jBemOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBemOkActionPerformed
        controller.escolherTela(jPanel1);
        controller.listaClientes(jClienteTable);
        controller.listarPedidos(jPedidoTecnicoTable);
    }//GEN-LAST:event_jBemOkActionPerformed

    private void jClienteTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClienteTableMouseClicked
       
        
       idDoJTableCliente = controller.retornarIdJTable(jClienteTable);
       
       System.out.println(idDoJTableCliente);
        
    }//GEN-LAST:event_jClienteTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jClienteTable.getModel();
        model.setRowCount(0);
        controller.listaClientes(jClienteTable);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuActionPerformed

    private void jPedidoTecnicoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPedidoTecnicoTableMouseClicked
//        idDaLinhaSelecionada = jPedidoTecnicoTable.getSelectedRow();
//        String idPedido = (jClienteTable.getModel().getValueAt(idDaLinhaSelecionada, 0).toString());
       
           idDoLTablePedido = controller.retornarIdJTable(jPedidoTecnicoTable);
        
        System.out.println(idDoLTablePedido);
        
    }//GEN-LAST:event_jPedidoTecnicoTableMouseClicked

    private void jCadastrarPedidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarPedidoButtonActionPerformed
        if(idDoJTableCliente.isEmpty()){
            
           JOptionPane.showMessageDialog(null, Strings.selecionaCliente);
    }else{
            CadastrarPedido cadastrarPedido = new CadastrarPedido();
            cadastrarPedido.idDoCliente = this.idDoJTableCliente;
            cadastrarPedido.setVisible(true);
            
        }
    }//GEN-LAST:event_jCadastrarPedidoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
                new TelaPrincipal().setVisible(true);
            
                System.out.println("second started too");
                   
                
                
            }
        });
    }

 
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAtendente;
    private javax.swing.JButton jBemOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jCadastrarPedidoButton;
    private javax.swing.JButton jCadastrarUs;
    private javax.swing.JTable jClienteTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuSairItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jPedidoTecnicoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jTecnico;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizarClienteCadastradoTabela() {
       atualizarTabela();
    }
}
