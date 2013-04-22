/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.jogo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Roldão
 */
public class Pontuacao implements Comparable<Pontuacao>, Serializable {

    private String nome;
    private long pontos;
    private static List<Pontuacao> pontuacoes;
    private static final String arquivo = System.getProperty("user.dir")+"/pontos.db";

    public Pontuacao(String nome, long pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public long getPontos() {
        return pontos;
    }

    @Override
    public int compareTo(Pontuacao t) {
        Pontuacao p = (Pontuacao) t;
        if (pontos < p.pontos) {
            return 1;
        } else if(pontos > p.pontos) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public static List<Pontuacao> LerPontuacoes() {
        if (pontuacoes == null) {
            FileInputStream arqLeitura = null;
            ObjectInputStream in = null;
            try {
                //arquivo onde estao os dados serializados
                arqLeitura = new FileInputStream(arquivo);
                //objeto que vai ler os dados do arquivo
                in = new ObjectInputStream(arqLeitura);
                //recupera os dados
                pontuacoes = (ArrayList<Pontuacao>) in.readObject();
            } catch (ClassNotFoundException | IOException ex) {
                System.out.println("Erro ao carregar pontuações: "+ex.getMessage());
                pontuacoes = new ArrayList<>();
            } finally {
                try {
                    if(arqLeitura != null) arqLeitura.close();
                    if(in != null) in.close();
                } catch (IOException ex) {
                    System.out.println("Erro ao carregar pontuações: "+ex.getMessage());
                }
            }
        }
        return pontuacoes;
    }

    public static void AdicionarPontuacao(Pontuacao p) {
        List<Pontuacao> lista = LerPontuacoes();
        lista.add(p);
        Collections.sort(lista);
        if(lista.size() > 10) lista.remove(10);
        
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);
            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);
            //escreve todos os dados
            out.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Erro ao gravar pontuação: " + ex.getMessage());
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
                System.out.println("Erro ao gravar pontuação: " + ex.getMessage());
            }
        }
    }
}
