package br.ifrn.tads.arkanoid.jogo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ElementoDaTela extends Rectangle {

    public ElementoDaTela(int i, int i1, int i2, int i3) {
        super(i, i1, i2, i3);
    }
    public abstract void Paint(Graphics2D g);
}