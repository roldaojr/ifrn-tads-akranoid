package br.ifrn.tads.arkanoid.jogo;

import br.ifrn.tads.arkanoid.jogo.eventos.ColisionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Bola extends ElementoDaTela implements ColisionListener {

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
    public void ColisionDetected(Rectangle e1, Rectangle e2) {
        Rectangle2D irect = intersection(e2);
        if (e2.intersectsLine(x, y, x + width, y)) { // parte de cima
            direcaoY = -direcaoY;
            y += irect.getHeight();
        } else if (e2.intersectsLine(x, y + height, x + width, y + height)) { // parte de baixo
            direcaoY = -direcaoY;
            y -= irect.getHeight();
        } else if (e2.intersectsLine(x, y, x, y + height)) { // parte esquerda
            direcaoX = -direcaoX;
            x += irect.getWidth();
        } else if (e2.intersectsLine(x + width, y, x + width, y + height)) { // parte direitra
            direcaoX = -direcaoX;
            x -= irect.getWidth();
        }
    }

    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
}