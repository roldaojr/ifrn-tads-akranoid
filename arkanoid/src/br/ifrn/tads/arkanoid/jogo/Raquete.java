package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Raquete extends ElementoDaTela {

    public Raquete(int i, int i1) {
        super(i, i1, 90, 15);
    }

    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRoundRect(this.x, this.y, this.width, this.height, 15, 15);
    }
}