package br.ifrn.tads.arkanoid.gui;

import br.ifrn.tads.arkanoid.jogo.CenaDeJogo;
import br.ifrn.tads.arkanoid.jogo.ControleDeJogo;
import br.ifrn.tads.arkanoid.jogo.Pontuacao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * Janela principal de jogo
 *
 * @author Júnior Lucena
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private final ControleDeJogo jogo;
    private final Timer atualizarTempo;

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        ((BackgroundPanel) backPanel).setBackgroundImage(new ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/papel-de-parede.jpg")).getImage());
        jogo = new ControleDeJogo((CenaDeJogo) cenaDeJogo);
        jogo.addAtualizarEstadoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atualizarEstadoActionPerformed(ae);
            }
        });
        jogo.addFimDeJogoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fimDeJogoActionPerformed(ae);
                atualizarTempo.stop();
            }
        });
        atualizarTempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atualizarTempoActionPerformed(ae);
            }
        });
        atualizarTempo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        backPanel = new br.ifrn.tads.arkanoid.gui.BackgroundPanel();
        cenaDeJogo = new br.ifrn.tads.arkanoid.jogo.CenaDeJogo();
        JpanelMenu = new javax.swing.JPanel();
        pontos = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        tempo = new javax.swing.JLabel();
        Vidas = new javax.swing.JLabel();
        Slogan = new javax.swing.JLabel();
        imgNivel = new javax.swing.JLabel();
        imgpontos = new javax.swing.JLabel();
        imgVidas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        creditos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNovoJogo = new javax.swing.JMenuItem();
        miCarregarJogo = new javax.swing.JMenuItem();
        miSalvarJogo = new javax.swing.JMenuItem();
        miPausar = new javax.swing.JMenuItem();
        miTerminarJogo = new javax.swing.JMenuItem();
        miPontuacoes = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jTextField1.setText("jTextField1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arkanoid");
        setName("frame"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        backPanel.setOpaque(false);

        cenaDeJogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        cenaDeJogo.setOpaque(false);

        javax.swing.GroupLayout cenaDeJogoLayout = new javax.swing.GroupLayout(cenaDeJogo);
        cenaDeJogo.setLayout(cenaDeJogoLayout);
        cenaDeJogoLayout.setHorizontalGroup(
            cenaDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        cenaDeJogoLayout.setVerticalGroup(
            cenaDeJogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        JpanelMenu.setBackground(new java.awt.Color(0, 0, 0));
        JpanelMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        JpanelMenu.setOpaque(false);
        JpanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pontos.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        pontos.setForeground(new java.awt.Color(255, 255, 0));
        pontos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pontos.setText("SCORE - ");
        pontos.setToolTipText("");
        JpanelMenu.add(pontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, -1));

        nivel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        nivel.setForeground(new java.awt.Color(255, 255, 0));
        nivel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nivel.setText("LEVEL - ");
        JpanelMenu.add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 170, 30));

        tempo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tempo.setForeground(new java.awt.Color(255, 255, 0));
        tempo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tempo.setText("TEMPO -");
        JpanelMenu.add(tempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 170, 30));

        Vidas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Vidas.setForeground(new java.awt.Color(255, 255, 0));
        Vidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Vidas.setText("LIFE - ");
        JpanelMenu.add(Vidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 313, 170, 30));

        Slogan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/Arkanoid.png"))); // NOI18N
        Slogan.setText("jLabel2");
        Slogan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JpanelMenu.add(Slogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 240, 90));

        imgNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/Butons.jpg"))); // NOI18N
        imgNivel.setText("jLabel1");
        JpanelMenu.add(imgNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 200, -1));

        imgpontos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/Butons.jpg"))); // NOI18N
        JpanelMenu.add(imgpontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, -1));

        imgVidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/Butons.jpg"))); // NOI18N
        imgVidas.setText("jLabel4");
        JpanelMenu.add(imgVidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("By:");
        JpanelMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 30, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Roldão Júnior and Fco Antonio");
        JpanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        creditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifrn/tads/arkanoid/imagens/Butons.jpg"))); // NOI18N
        creditos.setText("jLabel6");
        JpanelMenu.add(creditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 200, 80));

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cenaDeJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JpanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JpanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(cenaDeJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(backPanel, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Jogo");

        miNovoJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miNovoJogo.setText("Novo Jogo");
        miNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovoJogoActionPerformed(evt);
            }
        });
        jMenu1.add(miNovoJogo);

        miCarregarJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        miCarregarJogo.setText("Carregar Jogo");
        miCarregarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCarregarJogoActionPerformed(evt);
            }
        });
        jMenu1.add(miCarregarJogo);

        miSalvarJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSalvarJogo.setText("Salvar Jogo");
        miSalvarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalvarJogoActionPerformed(evt);
            }
        });
        jMenu1.add(miSalvarJogo);

        miPausar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        miPausar.setText("Pausar");
        miPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPausarActionPerformed(evt);
            }
        });
        jMenu1.add(miPausar);

        miTerminarJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        miTerminarJogo.setText("Terminar Jogo");
        miTerminarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTerminarJogoActionPerformed(evt);
            }
        });
        jMenu1.add(miTerminarJogo);

        miPontuacoes.setText("Pontuações");
        miPontuacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPontuacoesActionPerformed(evt);
            }
        });
        jMenu1.add(miPontuacoes);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        jMenu1.add(miSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fimDeJogoActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = JOptionPane.showInputDialog(this, "Digite seu nome", "");
        Pontuacao.AdicionarPontuacao(new Pontuacao(nome, jogo.getEstado().getPontos()));
        String mensagem = "";
        if (jogo.getEstado().getTijolos().isEmpty()) {
            mensagem = "Parabéns, você venceu! ";
        } else if (jogo.getEstado().getVidas() == 0) {
            mensagem = "Que pena, você perdeu! ";
        }
        int result = JOptionPane.showConfirmDialog(this, mensagem + "Deseja jogar novamente?", "Fim de jogo", 0);
        if (result == JOptionPane.YES_OPTION) {
            miNovoJogoActionPerformed(evt);
        } else {
            miTerminarJogoActionPerformed(evt);
        }
    }

    private void atualizarTempoActionPerformed(java.awt.event.ActionEvent evt) {
        if (jogo.getEstado() != null) {
            long segundos = jogo.getEstado().getTempo();
            long horas = segundos/3600;
            segundos = segundos % 3600;
            long minutos = segundos / 60;
            segundos = segundos % 60;
            tempo.setText(String.format("TEMPO - %02d:%02d:%02d", horas, minutos, segundos));
        }
    }

    private void atualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {
        pontos.setText("SCORE - " + jogo.getEstado().getPontos());
        nivel.setText("LEVEL - " + jogo.getEstado().getNivel());
        Vidas.setText("LIFES - " + jogo.getEstado().getVidas());
    }

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        dispose();
    }//GEN-LAST:event_miSairActionPerformed

    private void miCarregarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCarregarJogoActionPerformed
        boolean pausado = jogo.EmPausa();
        if (!pausado) {
            jogo.PausarJogo();
        }
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            jogo.CarregarJogo(fc.getSelectedFile().getAbsolutePath());
        }
        if (!pausado) {
            jogo.ContinuarJogo();
        }
    }//GEN-LAST:event_miCarregarJogoActionPerformed

    private void miNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovoJogoActionPerformed
        jogo.IniciarJogo();
        getContentPane().setCursor(blankCursor());
    }//GEN-LAST:event_miNovoJogoActionPerformed

    private void miTerminarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTerminarJogoActionPerformed
        jogo.TerminarJogo();
        getContentPane().setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_miTerminarJogoActionPerformed

    private void miSalvarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalvarJogoActionPerformed
        boolean pausado = jogo.EmPausa();
        if (!pausado) {
            jogo.PausarJogo();
        }
        JFileChooser fc = new JFileChooser();
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            jogo.SalvarJogo(fc.getSelectedFile().getAbsolutePath());
        }
        if (!pausado) {
            jogo.ContinuarJogo();
        }
    }//GEN-LAST:event_miSalvarJogoActionPerformed

    private void miPontuacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPontuacoesActionPerformed
        String texto = "";
        for(Pontuacao p: Pontuacao.LerPontuacoes()) {
            texto += String.format("%s\t%d\n", p.getNome(), p.getPontos());
        }
        JOptionPane.showMessageDialog(this, texto, "Melhores pontuações", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_miPontuacoesActionPerformed

    private void miPausarActionPerformed(java.awt.event.ActionEvent evt) {
        if (jogo.EmPausa()) {
            getContentPane().setCursor(blankCursor());
            miPausar.setText("Pausar");
            jogo.ContinuarJogo();
        } else {
            getContentPane().setCursor(Cursor.getDefaultCursor());
            miPausar.setText("Continuar");
            jogo.PausarJogo();
        }
    }

    private Cursor blankCursor() {
        // Criar cursor a patir de uma imagem transparente
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        return Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the System look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelMenu;
    private javax.swing.JLabel Slogan;
    private javax.swing.JLabel Vidas;
    private javax.swing.JPanel backPanel;
    private javax.swing.JPanel cenaDeJogo;
    private javax.swing.JLabel creditos;
    private javax.swing.JLabel imgNivel;
    private javax.swing.JLabel imgVidas;
    private javax.swing.JLabel imgpontos;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem miCarregarJogo;
    private javax.swing.JMenuItem miNovoJogo;
    private javax.swing.JMenuItem miPausar;
    private javax.swing.JMenuItem miPontuacoes;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSalvarJogo;
    private javax.swing.JMenuItem miTerminarJogo;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel pontos;
    private javax.swing.JLabel tempo;
    // End of variables declaration//GEN-END:variables
}
