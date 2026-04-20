package br.com.projetomario.marioworld.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GerenciadorDeInput implements KeyListener {
    public boolean up;
    public boolean left;
    public boolean right;
    public boolean restart;
    public boolean devMode;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            left = true;
        }
        if (code == KeyEvent.VK_D) {
            right = true;
        }
        if (code == KeyEvent.VK_SPACE) {
            up = true;
        }
        if (code == KeyEvent.VK_R) {
            restart = true;
        }
        if (code == KeyEvent.VK_T) {
            devMode = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A){
            left = false;
        }
        if (code == KeyEvent.VK_D) {
            right = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            up = false;
        }
        if (code == KeyEvent.VK_R) {
            restart = false;
        }
        if (code == KeyEvent.VK_T) {
            devMode = false;
        }
    }
}