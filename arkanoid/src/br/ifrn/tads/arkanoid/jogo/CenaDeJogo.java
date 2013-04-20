package br.ifrn.tads.arkanoid.jogo;

import br.ifrn.tads.arkanoid.jogo.eventos.ColisionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
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
    private Rectangle paredeEsquerda;
    private Rectangle paredeDireita;
    private Rectangle paredeSuperior;
    private Rectangle paredeInferior;

    public CenaDeJogo() {
        super();
        raquete = new Raquete(-100, -100);
        bola = new Bola(400, 400);
        tijolos = new ArrayList<>();
        tijolosRemovidos = new ArrayList<>();
        colisionListeners = new ArrayList<>();
        addMouseListener(new MouseEventos());
        addMouseMotionListener(new MouseEventos());
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

    public Rectangle getParedeEsquerda() {
        return paredeEsquerda;
    }

    public Rectangle getParedeDireita() {
        return paredeDireita;
    }

    public Rectangle getParedeSuperior() {
        return paredeSuperior;
    }

    public Rectangle getParedeInferior() {
        return paredeInferior;
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

    private void RedefinirRaquete() {
        raquete.x = 0;
    }

    void RedefinirBola() {
        bola.setVelocidade(0);
        bola.x = (int) (raquete.x + (raquete.getWidth() / 2) - (bola.getWidth() / 2));
        bola.y = raquete.y - bola.height;
    }

    public void RedefinirEstado() {
        RedefinirTijolos();
        RedefinirRaquete();
        RedefinirBola();
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
        if (e2 instanceof Tijolo) {
            Tijolo t = (Tijolo) e2;
            if (t.getTipo() == 1) {
                tijolosRemovidos.add(t);
            } else if (t.getTipo() > 1) {
                t.setTipo(t.getTipo() - 1);
            }
        }
        if (e1 == bola) {
            Rectangle2D irect = bola.intersection(e2);
            if(irect.getWidth() < irect.getHeight()) {
                bola.setDirecaoX(-bola.getDirecaoX());
                bola.x += irect.getWidth()*bola.getDirecaoX();
            } else {
                bola.setDirecaoY(-bola.getDirecaoY());
                bola.y += irect.getHeight()*bola.getDirecaoY();
            }
        }
    }

    private void TesteColisao() {
        if (paredeEsquerda == null) {
            paredeEsquerda = new Rectangle(-20, 0, 20, getHeight());
        }
        if (paredeDireita == null) {
            paredeDireita = new Rectangle(getWidth(), 0, 20, getHeight());
        }
        if (paredeSuperior == null) {
            paredeSuperior = new Rectangle(0, -20, getWidth(), 20);
        }
        if (paredeInferior == null) {
            paredeInferior = new Rectangle(0, getHeight(), getWidth(), 20);
        }
        // Paredes da tela
        if (bola.intersects(paredeEsquerda)) {
            chamarEventoColisao(bola, paredeEsquerda);
        }
        if (bola.intersects(paredeDireita)) {
            chamarEventoColisao(bola, paredeDireita);
        }
        if (bola.intersects(paredeSuperior)) {
            chamarEventoColisao(bola, paredeSuperior);
        }
        if (bola.intersects(paredeInferior)) {
            chamarEventoColisao(bola, paredeInferior);
        }
        // Tijolos
        for (Tijolo t : tijolos) {
            if (bola.intersects(t)) {
                chamarEventoColisao(bola, t);
            }
        }
        // Bola
        if (bola.intersects(raquete)) {
            chamarEventoColisao(bola, raquete);
        }
    }

    private void chamarEventoColisao(Rectangle e1, Rectangle e2) {
        ColisionDetected(e1, e2);
        synchronized (this) {
            List<ColisionListener> targets = new ArrayList<>(colisionListeners);
            for (ColisionListener l : targets) {
                l.ColisionDetected(e1, e2);
            }
        }
    }

    void atualizarJogo() {
        tijolos.removeAll(tijolosRemovidos);
        tijolosRemovidos.clear();
        if (bola.getVelocidade() > 0) {
            bola.Mover();
            TesteColisao();
        } else {
            RedefinirBola();
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
