/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Júnior Lucena
 */
public class ImgPrincipal extends javax.swing.JPanel {
    private final Image backgroundImage;

    /**
     * Recebendo a Imagem Background
     */
    
    public ImgPrincipal() {
        initComponents();
        backgroundImage = new ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/papel-de-parede.jpg")).getImage();
    }

    @Override
    
    //Método de Pintar a Imagem;
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(backgroundImage, 0, 0, null);
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
