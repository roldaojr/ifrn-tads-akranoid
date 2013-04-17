package br.ifrn.tads.arkanoid.jogo;

import br.ifrn.tads.arkanoid.jogo.eventos.ColisionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class CenaDeJogo extends JPanel implements ColisionListener {

    private List<ColisionListener> colisionListeners;
    private List<Tijolo> tijolos;
    private List<Tijolo> tijolosRemovidos;
    private Raquete raquete;
    private Bola bola;
    private boolean ativo = false;

    public CenaDeJogo() {
        super();
        raquete = new Raquete(-100, -100);
        bola = new Bola(400, 400);
        tijolos = new ArrayList<>();
        tijolosRemovidos = new ArrayList<>();
        colisionListeners = new ArrayList<>();
        RedefinirTijolos();
        PosicionarRaquete();
        PosicionarBola();
        addMouseListener(new MouseEventos());
        addMouseMotionListener(new MouseEventos());
        addColisionListener(this);
        addColisionListener(bola);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        repaint();
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

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    public void setRaquete(Raquete raquete) {
        this.raquete = raquete;
    }

    public void setTijolos(List<Tijolo> tijolos) {
        this.tijolos = tijolos;
    }
    
    private void RedefinirTijolos() {
        tijolos.clear();
        int left = (getWidth() - Tijolo.largura * 10) / 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Tijolo t = new Tijolo(5 - i, Tijolo.largura * j, Tijolo.altura * i);
                t.x += left;
                tijolos.add(t);
            }
        }
    }

    private void PosicionarRaquete() {
        raquete.x = 0;
    }

    private void PosicionarBola() {
        bola.setVelocidade(0);
        bola.x = (int) (raquete.x + (raquete.getWidth() / 2) - (bola.getWidth() / 2));
        bola.y = raquete.y - bola.height;
    }

    public void RedefinirEstado() {
        RedefinirTijolos();
        PosicionarRaquete();
        PosicionarBola();
    }
    
    synchronized final public void addColisionListener(ColisionListener evt) {
        if (colisionListeners == null) {
            colisionListeners = new ArrayList<>();
        }
        colisionListeners.add(evt);
    }

    synchronized final public void removeColisionListener(ColisionListener evt) {
        if (colisionListeners != null) {
            colisionListeners.remove(evt);
        }
    }

    @Override
    public void ColisionDetected(Rectangle e1, Rectangle e2) {
        synchronized (this) {
            if (e2 instanceof Tijolo) {
                Tijolo t = (Tijolo) e2;
                if (t.getTipo() == 1) {
                    tijolosRemovidos.add(t);
                } else if (t.getTipo() > 1) {
                    t.setTipo(t.getTipo() - 1);
                }
            }
        }
    }
    
    private void TesteColisao() {
        // Paredes da tela
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
            bola.setVelocidade(0);
            PosicionarBola();
        }
        // Chamar listeners de evento
        List<ColisionListener> targets;
        // Tijolos
        for (Tijolo t : tijolos) {
            if (bola.intersects(t)) {
                synchronized (this) {
                    targets = new ArrayList<>(colisionListeners);
                    for (ColisionListener l : targets) {
                        l.ColisionDetected(bola, t);
                    }
                }
            }
        }
        // Bola
        if (bola.intersects(raquete)) {
            synchronized (this) {
                targets = new ArrayList<>(colisionListeners);
                for (ColisionListener l : targets) {
                    l.ColisionDetected(bola, raquete);
                }
            }
        }
        // Zona de morte
    }

    void Atualizar() {
        tijolos.removeAll(tijolosRemovidos);
        tijolosRemovidos.clear();
        if (bola.getVelocidade() > 0) {
            bola.Mover();
            TesteColisao();
        } else {
            PosicionarBola();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g = (Graphics2D) grphcs;
        if (ativo) {
            for (Tijolo t : tijolos) {
                t.Paint(g);
            }
            raquete.Paint(g);
            bola.Paint(g);
        }
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
}
