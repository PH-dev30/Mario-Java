package br.com.projetomario.marioworld.telas;

import br.com.projetomario.marioworld.modelo.Entidade;

public class Camera {

    private float x;
    private float y;

    private Entidade alvo;

    public Camera(Entidade alvo) {
        this.alvo = alvo;
    }

    public void atualizar() {
        if (alvo != null) {
            this.x = alvo.getX() - 400 + (alvo.getLargura() / 2);

            if (this.x < 0) {
                this.x = 0;
            }

        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}