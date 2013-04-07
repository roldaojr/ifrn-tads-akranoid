package br.ifrn.tads.arkanoid.jogo;

public class Pontuacao {
    private String nome;
    private int pontos;

    public Pontuacao(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }
}