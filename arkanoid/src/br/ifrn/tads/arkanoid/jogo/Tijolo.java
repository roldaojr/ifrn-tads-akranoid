package br.ifrn.tads.arkanoid.jogo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represemta um tijolo no jogo.
 * @author Roldão
 */
public class Tijolo extends TelaComponent {
    final private Color[] cores = {
        new Color(156,156,156),
        new Color(97,224,0),
        new Color(191,65,160),
        new Color(95,126,158),
        new Color(226,230,0),
        new Color(191,0,0),
    };
    private int tipo;
    static final int largura = 60;
    static final int altura = 25;

    /**
     * Criar um novo tijolo
     * @param tipo Tipo do tijolo
     * @param i Posição horizontal
     * @param i1 Posição vertical
     */
    public Tijolo(int tipo, int i, int i1) {
        super(i, i1, largura, altura);
        this.tipo = tipo;
    }

    /**
     * Retorna o tipo de um tijolo
     * @return Tipo do tijolo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Definir o tipo do tijolo
     * @param tipo Tipo do tijolo
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Desenhar elemento na tela
     * @param g
     */
    @Override
    public void Paint(Graphics2D g) {
        g.setColor(cores[tipo]);
        g.fill(this);
        g.setStroke(new BasicStroke(2, BasicStroke.JOIN_BEVEL, BasicStroke.JOIN_BEVEL));
        // x+2, y+2, x+width-3, y+height-3
        g.setColor(cores[tipo].darker());
        g.drawLine(x+2, y+height-1, x+width-1, y+height-1);
        g.drawLine(x+width-1, y+2, x+width-1, y+height-1);
        g.setColor(cores[tipo].brighter());
        g.drawLine(x+2, y+2, x+width-1, y+2);
        g.drawLine(x+2, y+2, x+2, y+height-1);

        g.setColor(cores[tipo].darker().darker());
        g.drawLine(x+1, y+height, x+width, y+height);
        g.drawLine(x+width, y+1, x+width, y+height);
        g.setColor(cores[tipo].brighter().brighter());
        g.drawLine(x+1, y+1, x+width, y+1);
        g.drawLine(x+1, y+1, x+1, y+height);

        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g.setColor(Color.BLACK);
        g.draw(this);
    }
}