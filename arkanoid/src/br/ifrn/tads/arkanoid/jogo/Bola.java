package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bola extends ElementoDaTela {

    private CenaDeJogo cena;
    private int velocidadeX;
    private int velocidadeY;
    protected int direcao;
    protected int velocidade;

    public Bola(CenaDeJogo c, int i, int i1) {
        super(i, i1, 16, 16);
        cena = c;
        velocidadeX = 10;
        velocidadeY = -10;
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

    public void Mover() {
        x += velocidadeX;
        y += velocidadeY;
        if(x < 0) {
            x = 0;
            velocidadeX = -velocidadeX;
        } else if(x > (cena.getWidth() - width)) {
            x = cena.getWidth() - width;
            velocidadeX = -velocidadeX;
        }
        if(y < 0) {
            y = 0;
            velocidadeY = -velocidadeY;
        } else if(y > (cena.getHeight() - height)) {
            y = cena.getHeight() - height;
            velocidadeY = -velocidadeY;
        }
    }
    
    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, this.width, this.height);
    }
    
}