package br.com.projetomario.marioworld.modelo;

import java.util.List;

public abstract class Inimigo extends Entidade {

    public Inimigo(int x, int y, int largura, int altura) {
        super(x, y, largura, altura);
    }

    public abstract void moverSozinho(List<Bloco> blocos);
}