package br.ifrn.tads.arkanoid.jogo;

import java.io.Serializable;
import java.sql.Time;

public class EstadoDeJogo implements Serializable {
    private int pontos;
    private int vidas;
    private int nivel;
    private Time tempo;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Time getTempo() {
        return tempo;
    }

    public void setTempo(Time tempo) {
        this.tempo = tempo;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

}
