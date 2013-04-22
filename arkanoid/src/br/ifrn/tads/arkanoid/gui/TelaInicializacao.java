/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

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

        imgAnimacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/gif.gif"))); // NOI18N
        imgAnimacao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        imgAnimacao.setOpaque(true);
        ApoioAnimacao.add(imgAnimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 478));

        getContentPane().add(ApoioAnimacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final TelaInicializacao tela;
                tela = new TelaInicializacao();
                tela.setVisible(true);
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        new JanelaPrincipal().setVisible(true);
                        tela.dispose();
                        ((Timer) ae.getSource()).stop();
                    }
                });
                timer.start();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgAnimacao;
    // End of variables declaration//GEN-END:variables
}
