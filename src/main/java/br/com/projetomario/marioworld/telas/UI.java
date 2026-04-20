package br.com.projetomario.marioworld.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    private PainelJogo painel;
    private Font fontePadrao;

    public UI(PainelJogo painel) {
        this.painel = painel;
        this.fontePadrao = new Font("Arial", Font.BOLD, 30);
    }

    public void desenhar(Graphics2D g2) {

        g2.setFont(fontePadrao);
        g2.setColor(Color.WHITE);

        if (painel.jogoRodando) {
            g2.drawString("Score: " + painel.score, 50, 50);
            g2.drawString("Vidas: " + painel.vidas, 50, 90);

            g2.setColor(Color.YELLOW);
            g2.drawString("High Score: " + painel.recorde, 500, 50);

        } else {

            if (painel.vitoria) {
                g2.setColor(Color.GREEN);
                g2.setFont(new Font("Arial", Font.BOLD, 50));
                g2.drawString("VOCÊ VENCEU!", 200, 300);

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 20));
                g2.drawString("Score Final: " + painel.score, 250, 350);
                if (painel.score >= painel.recorde && painel.score > 0) {
                    g2.setColor(Color.YELLOW);
                    g2.drawString("NOVO RECORDE!", 500, 600);
                }
                g2.drawString("Pressione R para Jogar de Novo", 220, 400);

            } else {
                g2.setColor(Color.RED);
                g2.setFont(new Font("Arial", Font.BOLD, 50));
                g2.drawString("GAMER OVER!", 200, 300);

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Arial", Font.BOLD, 20));
                g2.drawString("Score Final: " + painel.score, 250, 350);
                if (painel.score >= painel.recorde && painel.score > 0) {
                    g2.setColor(Color.YELLOW);
                    g2.drawString("NOVO RECORDE!", 500, 600);
                }
                g2.drawString("Pressione R para Jogar de Novo", 220, 400);
            }
        }
    }
}