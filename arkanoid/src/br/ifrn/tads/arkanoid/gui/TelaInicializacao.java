/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.gui;

import javax.swing.JFrame;


/**
 *
 * @author Júnior Lucena
 */
public class TelaInicializacao extends JFrame {
        
    /**
     * Creates new form TelaInicializacao
     */
    public TelaInicializacao() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel ApoioAnimacao = new javax.swing.JPanel();
        chamarJanela = new javax.swing.JButton();
        imgAnimacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AnimacaoJFrame");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setModalExclusionType(null);
        setName("frameInicializacao"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ApoioAnimacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chamarJanela.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chamarJanela.setText("Jogar");
        chamarJanela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chamarJanelaActionPerformed(evt);
            }
        });
        ApoioAnimacao.add(chamarJanela, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, -1, -1));

        imgAnimacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/gif.gif"))); // NOI18N
        imgAnimacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        imgAnimacao.setOpaque(true);
        ApoioAnimacao.add(imgAnimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 478));

        getContentPane().add(ApoioAnimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chamarJanelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chamarJanelaActionPerformed
        new JanelaPrincipal().setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(TelaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicializacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chamarJanela;
    private javax.swing.JLabel imgAnimacao;
    // End of variables declaration//GEN-END:variables
}
