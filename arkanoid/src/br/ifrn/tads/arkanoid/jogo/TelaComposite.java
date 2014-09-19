package br.ifrn.tads.arkanoid.jogo;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class TelaComposite extends TelaComponent {
    ArrayList<TelaComponent> subitens = new ArrayList<>();

    public TelaComposite(int i, int i1, int i2, int i3) {
        super(i, i1, i2, i3);
    }
    public void add(TelaComponent c) throws Exception {
        this.subitens.add(c);
    }
    public void remove(TelaComponent c) throws Exception {
        this.subitens.remove(c);
    }
    public void clear() throws Exception {
        this.subitens.clear();
    }
    public void removeAll(List<? extends TelaComponent> itens) throws Exception {
        this.subitens.removeAll(itens);
    }
    public TelaComponent getElemento(int index) {
        return this.subitens.get(index);
    }
    public void Paint(Graphics2D g) {
        for (TelaComponent subiten : this.subitens) {
            subiten.Paint(g);
        }
    }
}