package br.ifrn.tads.arkanoid.jogo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Tijolo extends ElementoDaTela {

    private int tipo;
    static final int largura = 60;
    static final int altura = 25;

    public Tijolo(int tipo, int i, int i1) {
        super(i, i1, largura, altura);
        this.tipo = tipo;
    }

    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fill(this);
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g.setColor(Color.BLACK);
        g.draw(this);
    }
}