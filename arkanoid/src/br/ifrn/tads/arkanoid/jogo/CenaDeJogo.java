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

/**
 * Painel onde será desenhado o jogo
 * @author Roldão
 */
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

    /**
     * Construir uma nova cena de jogo
     */
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

    /**
     * Verificar se a cena está ativa
     * @return true de estiver ativo, false caso contrário
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Definir estado de ativo da cena.
     * @param ativo
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
        repaint();
    }

    /**
     * Acessar a lista de tijolos a serem desenhados na tela.
     * @return
     */
    public List<Tijolo> getTijolos() {
        return tijolos;
    }

    /**
     * Acessar a instancia da raquete
     * @return
     */
    public Raquete getRaquete() {
        return raquete;
    }

    /**
     * Acessr a instancia da bola.
     * @return
     */
    public Bola getBola() {
        return bola;
    }

    /**
     * Definir a instancia da bola.
     * @param bola
     */
    public void setBola(Bola bola) {
        this.bola = bola;
    }

    /**
     * Definir a instancia da raquete.
     * @param raquete
     */
    public void setRaquete(Raquete raquete) {
        this.raquete = raquete;
    }

    /**
     * Definir a lista de tijolos.
     * @param tijolos
     */
    public void setTijolos(List<Tijolo> tijolos) {
        this.tijolos = tijolos;
    }

    /**
     * Acessar o retangulo referente ao lado esquerdo da tela.
     * @return
     */
    public final Rectangle getParedeEsquerda() {
        return paredeEsquerda;
    }

    /**
     * Acessar o retangulo referente ao lado direito da tela.
     * @return
     */
    public final Rectangle getParedeDireita() {
        return paredeDireita;
    }

    /**
     * Acessar o retangulo referente ao parte suprior da tela
     * @return
     */
    public Rectangle getParedeSuperior() {
        return paredeSuperior;
    }

    /**
     * Acessar o retangulo referente ao parte inferior da tela
     * @return
     */
    public Rectangle getParedeInferior() {
        return paredeInferior;
    }

    /*
     * Define os tijolos para o estado inicial.
     */
    private void RedefinirTijolos() {
        tijolos.clear();
        int left = (getWidth() - Tijolo.largura * 10) / 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Tijolo t = new Tijolo(5 - i, Tijolo.largura * j, Tijolo.altura * i + 4);
                t.x += left;
                tijolos.add(t);
            }
        }
    }

    /*
     * Define a raqute para o estado inicial
     */
    private void RedefinirRaquete() {
        raquete.x = 0;
    }

    /*
     * Define a bola para o estado inicial
     */
    void RedefinirBola() {
        bola.setVelocidade(0);
        bola.x = (int) (raquete.x + (raquete.getWidth() / 2) - (bola.getWidth() / 2));
        bola.y = raquete.y - bola.height;
    }

    /**
     * Redefine o estado dos elementos da tela.
     */
    public void RedefinirEstado() {
        RedefinirTijolos();
        RedefinirRaquete();
        RedefinirBola();
    }

    /**
     * Adicionar listenar para o evento de colisao
     * @param evt listener
     */
    synchronized final public void addColisionListener(ColisionListener evt) {
        if (colisionListeners == null) {
            colisionListeners = new ArrayList<>();
        }
        colisionListeners.add(evt);
    }

    /**
     * Remover listenar para o evento de colisao
     * @param evt listener
     */
    synchronized final public void removeColisionListener(ColisionListener evt) {
        if (colisionListeners != null) {
            colisionListeners.remove(evt);
        }
    }

    /**
     * Detecção de colisão entre elementos da tela (chamado pelo evento ColisionEvent).
     * @param e1 Elmemto que colidiu
     * @param e2 Elmento com o qual o e1 colidiu
     */
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

    /*
     * Caltula posições do elementos da tela e verifica se houve colisão.
     */
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
            fireColisionEvent(bola, paredeEsquerda);
        }
        if (bola.intersects(paredeDireita)) {
            fireColisionEvent(bola, paredeDireita);
        }
        if (bola.intersects(paredeSuperior)) {
            fireColisionEvent(bola, paredeSuperior);
        }
        if (bola.intersects(paredeInferior)) {
            fireColisionEvent(bola, paredeInferior);
        }
        // Tijolos
        for (Tijolo t : tijolos) {
            if (bola.intersects(t)) {
                fireColisionEvent(bola, t);
            }
        }
        // Bola
        if (bola.intersects(raquete)) {
            fireColisionEvent(bola, raquete);
        }
    }

    /*
     * Chamar o evento Colision
     * @param e1 Elmemto que colidiu
     * @param e2 Elmento com o qual o e1 colidiu
     */
    private void fireColisionEvent(Rectangle e1, Rectangle e2) {
        ColisionDetected(e1, e2);
        synchronized (this) {
            List<ColisionListener> targets = new ArrayList<>(colisionListeners);
            for (ColisionListener l : targets) {
                l.ColisionDetected(e1, e2);
            }
        }
    }

    /*
     * Atualizar elementos da tela de jogo.
     */
    void atualizarCena() {
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

    /**
     * Desenha os elementos da cena de jogo na tela.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (ativo) {
            for (Tijolo t : tijolos) {
                t.Paint(g2);
            }
            raquete.Paint(g2);
            bola.Paint(g2);
        }
    }

    /*
     * Captura eventos do mouse.
     */
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
