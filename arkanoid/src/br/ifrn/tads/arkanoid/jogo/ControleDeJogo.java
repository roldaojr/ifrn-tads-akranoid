package br.ifrn.tads.arkanoid.jogo;

import java.util.List;

public class ControleDeJogo {

    private int vidas;
    private int pontos;
    private int tempo;
    private int nivel;
    private CenaDeJogo cena;
    private List<Pontuacao> pontuacoes;

    public ControleDeJogo(CenaDeJogo c) {
        cena = c;
    }

    public void IniciarJogo() {
    }

    public void TerminarJogo() {
      
    }

    public void PausarJogo() {
        if(cena.m_timer.isRunning()) {
            cena.m_timer.stop();
        } else {
            cena.m_timer.start();
        }
    }

    public void ContinuarJogo() {
        cena.m_timer.start();
    }

    public void SalvarJogo() {
    }

    public void CarregarJogo() {
    }

    public void LerPontuacoes() {
    }

    public void AdicionarPontuacao() {
    }
}