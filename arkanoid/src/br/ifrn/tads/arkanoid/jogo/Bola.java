package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bola extends ElementoDaTela {

    private int velocidade;
    private int direcaoX;
    private int direcaoY;

    public Bola(int i, int i1) {
        super(i, i1, 15, 15);
        velocidade = 0;
        direcaoX = 1;
        direcaoY = -1;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getDirecaoX() {
        return direcaoX;
    }

    public void setDirecaoX(int direcaoX) {
        this.direcaoX = direcaoX;
    }

    public int getDirecaoY() {
        return direcaoY;
    }

    public void setDirecaoY(int direcaoY) {
        this.direcaoY = direcaoY;
    }

    public void Mover() {
        x += velocidade * direcaoX;
        y += velocidade * direcaoY;
    }

    public boolean Movendo() {
        if (velocidade > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
}