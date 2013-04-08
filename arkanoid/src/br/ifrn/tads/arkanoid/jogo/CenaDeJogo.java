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
        raquete = new Raquete(this, 0, 0);
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
            bola.Mover();
            repaint();
        }
    }
}
