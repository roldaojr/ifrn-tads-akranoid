package br.ifrn.tads.arkanoid.jogo;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class EstadoDeJogo implements Serializable {
    private int pontos;
    private int vidas;
    private int nivel;
    private Time tempo;
    private List<Tijolo> tijolos;
    
    public EstadoDeJogo() {
        tijolos = new ArrayList<>();
        pontos = 0;
        vidas = 3;
        nivel = 1;
        tempo = new Time(0);
    }

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

    public List<Tijolo> getTijolos() {
        return tijolos;
    }

    public void setTijolos(List<Tijolo> tijolos) {
        this.tijolos = tijolos;
    }

}
