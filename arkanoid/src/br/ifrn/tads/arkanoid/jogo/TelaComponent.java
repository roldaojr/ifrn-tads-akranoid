package br.ifrn.tads.arkanoid.jogo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

public abstract class TelaComponent extends Rectangle {
    public TelaComponent(int i, int i1, int i2, int i3) {
        super(i, i1, i2, i3);
    }
    public void add(TelaComponent c) throws Exception {
        throw new Exception("Não recebe subitens");
    }
    public void remove(TelaComponent c) throws Exception {
        throw new Exception("Não recebe subitens");
    }
    public TelaComponent get(int index) throws Exception {
        throw new Exception("Não recebe subitens");
    }
    public void clear() throws Exception {
        throw new Exception("Não recebe subitens");
    }
    public void removeAll(List<? extends TelaComponent> itens) throws Exception {
        throw new Exception("Não recebe subitens");
    }
    public abstract void Paint(Graphics2D g);
}
