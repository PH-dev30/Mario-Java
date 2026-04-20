package br.com.projetomario.marioworld.modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bandeira extends Entidade {

    public Bandeira(int x, int y) {
        super(x, y, 10, 300);
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void desenhar(Graphics2D g2) {
        g2.setColor(Color.GRAY);
        g2.fillRect(x, y, largura, altura);

        g2.setColor(Color.YELLOW);
        g2.fillOval(x - 5, y - 10, 20, 20);

        g2.setColor(Color.GREEN);
        g2.fillRect(x + 10, y + 20, 60, 40);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }
}