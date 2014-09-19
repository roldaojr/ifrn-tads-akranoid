package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

/**
 * Raquete que é usada para rebater a bola.
 * @author Roldão
 */
public class Raquete extends TelaComponent {
    /**
     * Criar uma nova raquete.
     * @param i Posição horizontal
     * @param i1 Posição vertial
     */
    public Raquete(int i, int i1) {
        super(i, i1, 100, 15);
    }

    /**
     * Desenha o elemento na tela.
     * @param g
     */
    @Override
    public void Paint(Graphics2D g) {
        final int margem = 8;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Pintar laterais
        g2.setColor(Color.cyan);
        g2.fill(new RoundRectangle2D.Double(x, y, width, height, 15, 15));
        // Pintar meio
        GradientPaint gradient = new GradientPaint(x, y, Color.gray,
                                x, y+5, Color.white, false);
        g.setPaint(gradient);
        g2.fillRect(x+margem, y, width-margem*2, 5);
        //g.setColor(Color.white);
        //g2.drawLine(x, y+5, x+width, y+5);
        gradient = new GradientPaint(x, y+5, Color.white,
                                x, y+height, Color.darkGray, false);
        g.setPaint(gradient);
        g2.fillRect(x+margem, y+5, width-margem*2, height-5);
        
        gradient = new GradientPaint(x, y, Color.red,
                x, height, Color.red.darker().darker(), true);
        g.setPaint(gradient);
        g2.fill(new RoundRectangle2D.Double(x+4, y, 8, height, 5, 5));
        g2.fill(new RoundRectangle2D.Double(x+width-12, y, 8, height, 5, 5));
    }
}