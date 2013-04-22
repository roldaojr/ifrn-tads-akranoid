/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.gui;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author Júnior Lucena
 */
public class telaInicializacao extends javax.swing.JFrame {

    /**
     * Creates new form telaInicializacao
     */
    public telaInicializacao() {
        
        initComponents();
        setLocationRelativeTo(null);

    }

    private void imgAnimada(){
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chamarJanela = new javax.swing.JButton();
        imgAnimada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setFocusable(false);
        setFocusableWindowState(false);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModalExclusionType(null);
        setName("frameInicializacao"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chamarJanela.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chamarJanela.setText("Jogar");
        chamarJanela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamarJanelaActionPerformed(evt);
            }
        });
        getContentPane().add(chamarJanela, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        imgAnimada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgAnimada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(imgAnimada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chamarJanelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamarJanelaActionPerformed
        new JanelaPrincipal().setVisible(true);
        //setDefaultCloseOperation(telaInicializacao.EXIT_ON_CLOSE);
        setVisible(false);
    }//GEN-LAST:event_chamarJanelaActionPerformed

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
            java.util.logging.Logger.getLogger(telaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicializacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chamarJanela;
    private javax.swing.JLabel imgAnimada;
    // End of variables declaration//GEN-END:variables
}
