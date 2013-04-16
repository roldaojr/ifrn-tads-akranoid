package br.ifrn.tads.arkanoid.jogo;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.Timer;

public class ControleDeJogo implements Serializable {

    final private int atualiza_ms = 20; // Milliseconds entre atualizações.
    
    private int vidas;
    private int pontos;
    private int tempo;
    private int nivel;
    private boolean jogoAtivo;
    private CenaDeJogo cena;
    private List<Pontuacao> pontuacoes;
    private Timer atualizaTimer;

    public ControleDeJogo(CenaDeJogo c) {
        cena = c;
        atualizaTimer = new Timer(atualiza_ms, new TimerAction());
    }

    public void IniciarJogo() {
        jogoAtivo = true;
        cena.setAtivo(true);
        cena.RedefinirEstado();
        atualizaTimer.start();
    }

    public void TerminarJogo() {
        atualizaTimer.stop();
        cena.RedefinirEstado();
        cena.setAtivo(false);
        jogoAtivo = false;
    }

    public boolean EmPausa() {
        return !atualizaTimer.isRunning();
    }
    
    public void PausarJogo() {
        if (atualizaTimer.isRunning()) {
            atualizaTimer.stop();
        } else {
            atualizaTimer.start();
        }
    }
    
    public void SalvarJogo() {
    }

    public void CarregarJogo(String arquivo) {
    }

    public void LerPontuacoes() {
    }

    public void AdicionarPontuacao() {
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public int getTempo() {
        return tempo;
    }

    public int getVidas() {
        return vidas;
    }
    
    private class TimerAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            cena.Atualizar();
        }
    }
}