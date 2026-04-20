package br.com.projetomario.marioworld.modelo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Moeda extends Entidade implements Coletavel {

    public Moeda(int x, int y) {
        super(x, y, 20, 20);
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void desenhar(Graphics2D g2) {
        g2.setColor(new Color(255, 215, 0));
        g2.fillOval(x, y, largura, altura);

        g2.setColor(new Color(218, 165, 32));
        g2.drawOval(x, y, largura, altura);

        g2.setColor(new Color(255, 255, 200));
        g2.fillOval(x + 5, y + 5, 5, 10);
    }

    @Override
    public int aoSerColetado(Mario mario) {
        return 200;
    }
}