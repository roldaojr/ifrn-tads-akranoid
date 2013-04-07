package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class CenaDeJogo extends ElementoDaTela {

    private List<Tijolo> tijolos;
    private Raquete raquete;
    private Bola bola;
    
    public CenaDeJogo() {
        super(0, 0, 600, 500);
        raquete = new Raquete(0, 0);
        bola = new Bola(0, 0);
        tijolos = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 10; j++) {
                tijolos.add(new Tijolo(1, Tijolo.largura*j, Tijolo.altura*i));
            }
        }
        raquete.y = this.height - raquete.height - 10;
        bola.x = raquete.x + (raquete.width - bola.width) / 2;
        bola.y = raquete.y - bola.height;
    }

    public List<Tijolo> getTijolos() {
        return tijolos;
    }

    public Raquete getRaquete() {
        return raquete;
    }

    public Bola getBola() {
        return bola;
    }
    
    @Override
    public void Paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fill(this);
        for(Tijolo t: tijolos) {
            t.Paint(g);
        }
        raquete.Paint(g);
        bola.Paint(g);
    }
    
}
