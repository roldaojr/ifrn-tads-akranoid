package br.ifrn.tads.arkanoid.jogo;

import br.ifrn.tads.arkanoid.jogo.eventos.ColisionListener;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class ControleDeJogo implements Serializable, ColisionListener {

    final private int atualiza_ms = 20; // Milliseconds entre atualizações.
    private EstadoDeJogo estado;
    private boolean jogoAtivo;
    private CenaDeJogo cena;
    private List<Pontuacao> pontuacoes;
    private Timer atualizaTimer;
    private List<ActionListener> estadoListeners;

    public ControleDeJogo(CenaDeJogo c) {
        cena = c;
        cena.addColisionListener(this);
        estado = new EstadoDeJogo();
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
        //
        cena.RedefinirEstado();
        cena.setAtivo(false);
        jogoAtivo = false;
    }

    public boolean EmPausa() {
        return !atualizaTimer.isRunning();
    }

    public void PausarJogo() {
        atualizaTimer.stop();
    }

    public void ContinuarJogo() {
        atualizaTimer.start();
    }
    
    public void SalvarJogo(String arquivo) {
        PausarJogo();
        estado.setTijolos(cena.getTijolos());
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
            ex.printStackTrace();
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        ContinuarJogo();
    }

    public void CarregarJogo(String arquivo) {
        PausarJogo();
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
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        ContinuarJogo();
    }

    public void LerPontuacoes() {
    }

    public void AdicionarPontuacao() {
    }

    @Override
    public void ColisionDetected(Rectangle e1, Rectangle e2) {
        if(e1 instanceof Bola && e2 instanceof Tijolo) {
            estado.setPontos(estado.getPontos()+1);
            //chamrEventoAtualizarEstado();
        }
    }
    
    /*private void chamrEventoAtualizarEstado() {
        synchronized (this) {
            List<ActionListener> targets = new ArrayList<>(estadoListeners);
            for (ActionListener l : targets) {
                l.actionPerformed(new ActionEvent(this.estado, 0,""));
            }
        }
    }*/
    
    synchronized final public void addAtualizarEstadoListener(ActionListener evt) {
        if (estadoListeners == null) {
            estadoListeners = new ArrayList<>();
        }
        estadoListeners.add(evt);
    }

    synchronized final public void removeAtualizarEstadoListener(ActionListener evt) {
        if (estadoListeners != null) {
            estadoListeners.remove(evt);
        }
    }
    
    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            cena.Atualizar();
        }
    }
}