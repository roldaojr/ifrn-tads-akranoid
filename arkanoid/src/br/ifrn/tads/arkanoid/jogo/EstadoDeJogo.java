package br.ifrn.tads.arkanoid.jogo;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Roldão
 */
public class EstadoDeJogo implements Serializable {
    private int pontos;
    private int vidas;
    private int nivel;
    private long tempo;
    private List<Tijolo> tijolos;
    
    /**
     * Criar um novo estado do jogo
     */
    public EstadoDeJogo(List<Tijolo> tj) {
        tijolos = tj;
        pontos = 0;
        vidas = 3;
        nivel = 1;
        tempo = 0;
    }

    /**
     * Ler o nível atual do jogo.
     * @return
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Definir o nível atual do jogo.
     * @param nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Ler a quantidade de pontos acumuloados.
     * @return
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Definir a quantidade de pontos acumuloados.
     * @param pontos
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * Ler quanto tempo se passou durante a partida.
     * @return
     */
    public long getTempo() {
        return tempo;
    }

    /**
     * Definir quanto tempo se passou durante a partida.
     * @param tempo
     */
    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    /**
     * Ler quantas vidas extras ainda restam
     * @return
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Definir quantas vidas extras ainda restam
     * @param vidas
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * Acessar a lista de tijolos que ainda não foram quabrados
     * @return
     */
    public List<Tijolo> getTijolos() {
        return tijolos;
    }

    /**
     * Definir a lista de tijolos que ainda não foram quabrados
     * @param tijolos
     */
    public void setTijolos(List<Tijolo> tijolos) {
        this.tijolos = tijolos;
    }

}
