package br.ifrn.tads.arkanoid.jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CenaDeJogo extends JPanel {

    private List<Tijolo> tijolos;
    private Raquete raquete;
    private Bola bola;
    private int m_interval = 20;    // Milliseconds between updates.
    Timer m_timer;           // Timer fires to anmimate one step.

    public CenaDeJogo() {
        super();
        raquete = new Raquete(-100, -100);
        bola = new Bola(400, 400);
        tijolos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                tijolos.add(new Tijolo(5 - i, Tijolo.largura * j, Tijolo.altura * i));
            }
        }
        addMouseListener(new MouseEventos());
        addMouseMotionListener(new MouseEventos());
        m_timer = new Timer(m_interval, new TimerAction());
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

    private void RedefinirBola() {
        bola.x = (int) (raquete.x + (raquete.getWidth() / 2) - (bola.getWidth() / 2));
        bola.y = raquete.y - bola.height;        
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Tijolo t : tijolos) {
            t.Paint(g);
        }
        raquete.Paint(g);
        bola.Paint(g);
    }

    private class MouseEventos extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent evt) {
            int x = evt.getX() - (raquete.width / 2);
            if (x < 0) {
                x = 0;
            } else if (x > getWidth() - raquete.width) {
                x = getWidth() - raquete.width;
            }
            raquete.setLocation(x, getHeight() - raquete.height - 20);
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            bola.setVelocidade(5);
        }
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (bola.getVelocidade() > 0) {
                bola.setLimites(getWidth(), getHeight());
                bola.Mover();
                if (bola.x < 0) {
                    bola.x = 0;
                    bola.setDirecaoX(-bola.getDirecaoX());
                } else if (bola.x > (getWidth() - bola.width)) {
                    bola.x = getWidth() - bola.width;
                    bola.setDirecaoX(-bola.getDirecaoX());
                }
                if (bola.y < 0) {
                    bola.y = 0;
                    bola.setDirecaoY(-bola.getDirecaoY());
                } else if (bola.y > (getHeight() - bola.height)) {
                    RedefinirBola();
                }
                List<Tijolo> remover = new ArrayList<>();
                for (Tijolo t : tijolos) {
                    if (bola.intersects(t)) {
                        bola.Colisao(t);
                        if (t.getTipo() == 1) {
                            remover.add(t);
                        } else if (t.getTipo() > 1) {
                            t.setTipo(t.getTipo() - 1);
                        }
                    }
                }
                tijolos.removeAll(remover);
                if (bola.intersects(raquete)) {
                    bola.Colisao(raquete);
                }
            } else {
                RedefinirBola();
            }
            repaint();
        }
    }
}
