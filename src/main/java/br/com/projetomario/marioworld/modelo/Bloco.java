package br.com.projetomario.marioworld.modelo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Bloco extends Entidade {

    private Color corBase;
    private Color corBrilho;

    public Bloco(int x, int y) {
        super(x, y, 32, 32);
        this.corBase = new Color(204, 102, 0);
        this.corBrilho = new Color(255, 200, 150, 100);
    }

    public Bloco(int x, int y, Color corDesejada) {
        super(x, y, 32, 32);
        this.corBase = corDesejada;
        this.corBrilho = corDesejada.brighter();
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void desenhar(Graphics2D g2) {

        g2.setColor(this.corBase);
        g2.fillRect(x, y, largura, altura);

        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, largura, altura);

        g2.drawLine(x, y + altura/2, x + largura, y + altura/2);
        g2.drawLine(x + largura/2, y, x + largura/2, y + altura/2);
        g2.drawLine(x + largura/4, y + altura/2, x + largura/4, y + altura);

        g2.setColor(this.corBrilho);
        g2.drawLine(x, y, x + largura, y);
        g2.drawLine(x, y, x, y + altura);
    }
}