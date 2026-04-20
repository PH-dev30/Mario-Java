package br.com.projetomario.marioworld.modelo;

import br.com.projetomario.marioworld.controle.CarregadorImagem;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Goomba extends Inimigo {

    private BufferedImage sprite;
    private int direcao = -1;
    private double velocidadeY = 0;

    public Goomba(int x, int y) {
        super(x, y, 32, 32);
        this.velocidade = 2;
        try {
            this.sprite = CarregadorImagem.carregar("/imagens/Goomba.png");
        } catch (Exception e) {
            this.sprite = null;
        }
    }

    @Override
    public void atualizar() {
    }

    @Override
    public void moverSozinho(java.util.List<Bloco> blocos) {
        velocidadeY += 0.5;
        y += velocidadeY;

        x += (velocidade * direcao);

        boolean chaoAbaixoDoCentro = false;

        for (Bloco b : blocos) {
            if (this.getBounds().intersects(b.getBounds())) {
                if (velocidadeY > 0 && y < b.getY()) {
                    y = b.getY() - altura;
                    velocidadeY = 0;
                }

                if (y + altura > b.getY() + 5) {
                    if (direcao == 1 && x + largura > b.getX()) {
                        direcao = -1;
                        x = b.getX() - largura;
                    } else if (direcao == -1 && x < b.getX() + b.getLargura()) {
                        direcao = 1;
                        x = b.getX() + b.getLargura();
                    }
                }
            }

            if (velocidadeY == 0) {
                int sensorX = x + (largura / 2);
                int sensorY = y + altura + 2;

                if (b.getBounds().contains(sensorX, sensorY)) {
                    chaoAbaixoDoCentro = true;
                }
            }
        }

        if (velocidadeY == 0 && !chaoAbaixoDoCentro) {
            direcao *= -1;
            x += (velocidade * direcao);
        }
    }

    @Override
    public void desenhar(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, largura, altura, null);
        } else {
            g2.setColor(new java.awt.Color(139, 69, 19));
            g2.fillRect(x, y, largura, altura);
        }
    }
}