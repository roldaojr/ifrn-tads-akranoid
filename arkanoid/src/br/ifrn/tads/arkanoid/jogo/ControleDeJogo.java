package br.ifrn.tads.arkanoid.jogo;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 * Controle a execução do jogo.
 *
 * @author Roldão
 */
public class ControleDeJogo implements Serializable, ColisionListener {

    final private int atualiza_ms = 20; // Milliseconds entre atualizações.
    private EstadoDeJogo estado;
    private boolean ativo;
    private CenaDeJogo cena;
    private Timer atualizaCena;
    private List<ActionListener> atualizarEstadoListeners;
    private List<ActionListener> fimDeJogoListeners;
    private long tempoInicial;
    
    /**
     * Criar um novo controle de jogo.
     *
     * @param c Objeto CenaDeJogo para mostrar o jogo.
     */
    public ControleDeJogo(CenaDeJogo c) {
        cena = c;
        cena.addColisionListener(this);
        atualizaCena = new Timer(atualiza_ms, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cena.atualizarCena();
                long tempoAtual = System.currentTimeMillis()/1000;
                estado.setTempo(estado.getTempo()+tempoAtual - tempoInicial);
                tempoInicial = tempoAtual;
            }
        });
        atualizarEstadoListeners = new ArrayList<>();
        fimDeJogoListeners = new ArrayList<>();
    }

    /**
     * Acessar o estado do jogo.
     *
     * @return O objeoto EstadoDeJogo com o estado atual do jogo.
     */
    public EstadoDeJogo getEstado() {
        return estado;
    }

    /**
     * Acessar a tela do jogo.
     *
     * @return O objeto CenaDeJogo associado.
     */
    public CenaDeJogo getCena() {
        return cena;
    }

    /**
     * Iniciar um novo jogo.
     *
     * @param pausado true para iniciar o jogo pausado, false caso contrário.
     */
    public void IniciarJogo(boolean pausado) {
        ativo = true;
        cena.setAtivo(true);
        cena.RedefinirEstado();
        estado = new EstadoDeJogo(cena.getTijolos());
        tempoInicial = System.currentTimeMillis()/1000;
        fireAtualizarEstadoEvent();
        if (!pausado) {
            atualizaCena.start();
        }
    }

    /**
     * Iniciar um novo jogo.
     */
    public void IniciarJogo() {
        IniciarJogo(false);
    }

    /**
     * Terminar o jogo em execução.
     */
    public void TerminarJogo() {
        atualizaCena.stop();
        cena.RedefinirEstado();
        cena.setAtivo(false);
        ativo = false;
    }

    /**
     * Verficar se o jogo está em execução
     *
     * @return true se houver um jogo em curso, false caso contrário.
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Verficar se o jogo está em pausa
     *
     * @return true se o jogo estiver em pausa, false caso contrário.
     */
    public boolean EmPausa() {
        return !atualizaCena.isRunning();
    }

    /**
     * Pausar o jogo ativo.
     */
    public void PausarJogo() {
        atualizaCena.stop();
    }

    /**
     * Continuar (despausar) o jogo ativo.
     */
    public void ContinuarJogo() {
        tempoInicial = System.currentTimeMillis()/1000;
        atualizaCena.start();
    }

    /**
     * Salvar o jogo em curso.
     *
     * @param arquivo Nome do arquivo onde o estado do jogo será gravado.
     */
    public void SalvarJogo(String arquivo) {
        PausarJogo();
        //estado.setTijolos(cena.getTijolos());
        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);
            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);
            //escreve todos os dados
            out.writeObject(estado);
        } catch (IOException ex) {
            System.out.println("Erro ao salvar o jogo: "+ex.getMessage());
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
                System.out.println("Erro ao salvar o jogo: "+ex.getMessage());
            }
        }
    }

    /**
     * Carregar um jogo.
     *
     * @param arquivo Nome do arquivo de onde será lido o jogo.
     */
    public void CarregarJogo(String arquivo) {
        if (ativo) {
            TerminarJogo();
        }
        IniciarJogo(true);
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(arquivo);
            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);
            //recupera os dados
            estado = (EstadoDeJogo) in.readObject();
            cena.setTijolos(estado.getTijolos());
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Erro ao carregar o jogo: "+ex.getMessage());
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                System.out.println("Erro ao carregar o jogo: "+ex.getMessage());
            }
        }
        fireAtualizarEstadoEvent();
    }

    /**
     * Método da interface ColisionListener para detecção de colisões
     *
     * @param e1 Retangulo que colidiu
     * @param e2 Retangulo com o qual o e1 colidiu
     */
    @Override
    public void ColisionDetected(Rectangle e1, Rectangle e2) {
        if (e1 instanceof Bola && e2 instanceof Tijolo) {
            estado.setPontos(estado.getPontos() + 1);
            fireAtualizarEstadoEvent();
            if (estado.getTijolos().isEmpty()) {
                TerminarJogo();
                fireFimDeJogoEvent();
            }
        }
        if (e2 == cena.getParedeInferior()) {
            if (estado.getVidas() > 0) {
                estado.setVidas(estado.getVidas() - 1);
                fireAtualizarEstadoEvent();
                cena.RedefinirBola();
            } else {
                TerminarJogo();
                fireFimDeJogoEvent();
            }
        }
    }

    /**
     * Acionar o evento atualizar estado
     */
    private void fireAtualizarEstadoEvent() {
        synchronized (this) {
            List<ActionListener> targets = new ArrayList<>(atualizarEstadoListeners);
            for (ActionListener l : targets) {
                l.actionPerformed(new ActionEvent(this.estado, 0, ""));
            }
        }
    }

    /**
     * Adicionar um listener para o evento atualizar estado.
     *
     * @param listener Listener a ser adicionado
     */
    synchronized final public void addAtualizarEstadoListener(ActionListener listener) {
        if (atualizarEstadoListeners == null) {
            atualizarEstadoListeners = new ArrayList<>();
        }
        atualizarEstadoListeners.add(listener);
    }

    /**
     * Remover um listener para o evento atualizar estado.
     *
     * @param listener Listener a ser removido
     */
    synchronized final public void removeAtualizarEstadoListener(ActionListener listener) {
        if (atualizarEstadoListeners != null) {
            atualizarEstadoListeners.remove(listener);
        }
    }

    /**
     * Acionar o evento fim de jogo
     */    
    private void fireFimDeJogoEvent() {
        synchronized (this) {
            List<ActionListener> targets = new ArrayList<>(fimDeJogoListeners);
            for (ActionListener l : targets) {
                l.actionPerformed(new ActionEvent(this, 0, "Game Over"));
            }
        }
    }
    
    /**
     * Adicionar um listener para o evento fim de jogo.
     *
     * @param listener Listener a ser adicionado
     */
    synchronized final public void addFimDeJogoListener(ActionListener listener) {
        if (fimDeJogoListeners == null) {
            fimDeJogoListeners = new ArrayList<>();
        }
        fimDeJogoListeners.add(listener);
    }

    /**
     * Remover um listener para o evento fim de jogo.
     *
     * @param listener Listener a ser removido
     */
    synchronized final public void removeFimDeJogoListener(ActionListener listener) {
        if (fimDeJogoListeners != null) {
            fimDeJogoListeners.remove(listener);
        }
    }
}