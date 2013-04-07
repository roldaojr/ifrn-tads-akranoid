package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bola extends ElementoDaTela {

    protected int direcao;
    protected int velocidade;

    public Bola(int i, int i1) {
        super(i, i1, 16, 16);
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
    
}