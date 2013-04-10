package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bola extends ElementoDaTela {

    private CenaDeJogo cena;
    private int velocidadeX;
    private int velocidadeY;

    public Bola(CenaDeJogo c, int i, int i1) {
        super(i, i1, 16, 16);
        cena = c;
        velocidadeX = 20;
        velocidadeY = -20;
    }

    public int getVelocidadeX() {
        return velocidadeX;
    }

    public void setVelocidadeX(int velocidadeX) {
        this.velocidadeX = velocidadeX;
    }

    public int getVelocidadeY() {
        return velocidadeY;
    }

    public void setVelocidadeY(int velocidadeY) {
        this.velocidadeY = velocidadeY;
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