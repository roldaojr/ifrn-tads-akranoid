/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.arkanoid.jogo;

import java.awt.Rectangle;

/**
 *
 * @author Roldão
 */
public interface ColisionListener {
    void ColisionDetected(Rectangle e1, Rectangle e2);
}
