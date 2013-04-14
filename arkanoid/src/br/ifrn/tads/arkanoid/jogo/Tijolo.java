package br.ifrn.tads.arkanoid.jogo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tijolo extends ElementoDaTela {

    private int tipo;
    static final int largura = 60;
    static final int altura = 25;

    public Tijolo(int tipo, int i, int i1) {
        super(i, i1, largura, altura);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public void Paint(Graphics2D g) {
        g.setColor(new Color(50, 255-(tipo*20), 50));
        g.fill(this);
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g.setColor(Color.BLACK);
        g.draw(this);
    }
}