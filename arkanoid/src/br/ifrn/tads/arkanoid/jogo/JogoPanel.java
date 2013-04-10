package br.ifrn.tads.arkanoid.jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class JogoPanel extends JPanel {
    private CenaDeJogo cena;

    public JogoPanel() {
        super();
        cena = new CenaDeJogo();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        // Desenhar elementos
        Graphics2D g2 = (Graphics2D) grphcs;
        //cena.Paint(g2);
    }
}