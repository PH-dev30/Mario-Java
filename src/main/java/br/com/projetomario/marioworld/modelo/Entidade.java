package br.com.projetomario.marioworld.modelo;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Entidade {
    protected int x;
    protected int y;
    protected int largura;
    protected int altura;
    protected int velocidade;

    public Entidade(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public abstract void atualizar();

    public abstract void desenhar(Graphics2D g2);

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}