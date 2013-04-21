package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

/**
 * Bola a ser rebatida pela raquete.
 * @author Roldão
 */
public class Bola extends ElementoDaTela {

    private int velocidade;
    private int direcaoX;
    private int direcaoY;

    /**
     * Criar uma nova bola.
     * @param i
     * @param i1
     */
    public Bola(int i, int i1) {
        super(i, i1, 20, 20);
        velocidade = 0;
        direcaoX = 1;
        direcaoY = -1;
    }

    /**
     * Obter a velocidade atual.
     * @return
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Definir a velocidade.
     * @param velocidade
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Obter direção de movimento horizontal.
     * @return
     */
    public int getDirecaoX() {
        return direcaoX;
    }

    /**
     * Definir direção de movimento horizontal.
     * @param direcaoX
     */
    public void setDirecaoX(int direcaoX) {
        this.direcaoX = direcaoX;
    }

    /**
     * Obter direção de movimento vertical.
     * @return
     */
    public int getDirecaoY() {
        return direcaoY;
    }

    /**
     * Definir direção de movimento vertical.
     * @param direcaoY
     */
    public void setDirecaoY(int direcaoY) {
        this.direcaoY = direcaoY;
    }

    /**
     * Atualizar a posição da bola de acordo com sua direção e velocidade.
     */
    public void Mover() {
        x += velocidade * direcaoX;
        y += velocidade * direcaoY;
    }

    /**
     * Verificar se a bola estiver se movendo.
     * @return true se a bola estiver se movendo, false caso contrário
     */
    public boolean Movendo() {
        if (velocidade > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Desenhar o elemento na tela
     * @param g
     */
    @Override
    public void Paint(Graphics2D g) {       
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Retains the previous state
        Paint oldPaint = g2.getPaint();

        // Fills the circle with solid color
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, width - 1, height - 1);
        // Adds shadows at the top
        Paint p;
        p = new GradientPaint(x, y, new Color(0.0f, 0.0f, 0.0f, 0.4f),
                0, height, new Color(0.5f, 0.5f, 0.5f, 0.0f));
        g2.setPaint(p);
        //g2.fillOval(x, y, width - 1, height - 1);
        
        // Adds highlights at the bottom 
        p = new GradientPaint(x, y, new Color(1.0f, 1.0f, 1.0f, 0.0f),
                0, height, new Color(1.0f, 1.0f, 1.0f, 0.4f));
        g2.setPaint(p);
        g2.fillOval(x, y, width - 1, height - 1);
        
        // Creates dark edges for 3D effect
        p = new RadialGradientPaint(new Point2D.Double(x + width / 2.0,
                y + height / 2.0), width / 2.0f,
                new float[] { 0.0f, 1.0f },
                new Color[] { new Color(252, 252, 252, 127),
                    new Color(0.0f, 0.0f, 0.0f, 0.8f) });
        g2.setPaint(p);
        g2.fillOval(x, y, width - 1, height - 1);
        
        // Adds oval specular highlight at the top left
        p = new RadialGradientPaint(new Point2D.Double(x + width / 2.0,
                y + height / 2.0), width / 1.4f,
                new Point2D.Double(45.0, 25.0),
                new float[] { 0.0f, 0.5f },
                new Color[] { new Color(1.0f, 1.0f, 1.0f, 0.4f),
                    new Color(1.0f, 1.0f, 1.0f, 0.0f) },
                RadialGradientPaint.CycleMethod.NO_CYCLE);
        g2.setPaint(p);
        g2.fillOval(x, y, width - 1, height - 1);
        
        // Restores the previous state
        g2.setPaint(oldPaint);
    }
}