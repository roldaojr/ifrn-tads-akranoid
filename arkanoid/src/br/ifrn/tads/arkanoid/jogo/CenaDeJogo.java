package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CenaDeJogo extends JPanel {
    private List<Tijolo> tijolos;
    private Raquete raquete;
    private Bola bola;
    private int m_interval  = 35;    // Milliseconds between updates.
    private Timer m_timer;           // Timer fires to anmimate one step.
    
    public CenaDeJogo() {
        super();
        m_timer = new Timer(m_interval, new TimerAction());
        raquete = new Raquete(100, 300);
        bola = new Bola(this, 0, 0);
        tijolos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                tijolos.add(new Tijolo(1, Tijolo.largura * j, Tijolo.altura * i));
            }
        }
        raquete.Mover();
        bola.x = raquete.x + (raquete.width- bola.width) / 2;
        bola.y = raquete.y - bola.height;
        m_timer.start();
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
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Tijolo t : tijolos) {
            t.Paint(g);
        }
        raquete.Mover();
        raquete.Paint(g);
        bola.Paint(g);
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            bola.x += bola.getVelocidadeX();
            bola.y += bola.getVelocidadeY();
            if(bola.x < 0) {
                bola.x = 0;
                bola.setVelocidadeX(-bola.getVelocidadeX());
            } else if(bola.x > (getWidth() - bola.width)) {
                bola.x = getWidth() - bola.width;
                bola.setVelocidadeX(-bola.getVelocidadeX());
            }
            if(bola.y < 0) {
                bola.y = 0;
                bola.setVelocidadeY(-bola.getVelocidadeY());
            } else if(bola.y > (getHeight() - bola.height)) {
                bola.y = getHeight() - bola.height;
                bola.setVelocidadeY(-bola.getVelocidadeY());
            }
            if(bola.intersects(raquete)) {
                if(raquete.contains(bola.x, bola.y+bola.height)) {
                    bola.setVelocidadeY(-bola.getVelocidadeY());
                }
                /*if() {  || raquete.contains(bola.x, bola.y)
                    bola.setVelocidadeY(-bola.getVelocidadeY());
                }*/
            }
            //bola.Mover();
            repaint();
        }
    }
}
