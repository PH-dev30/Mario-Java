package br.com.projetomario.marioworld.modelo;

import br.com.projetomario.marioworld.controle.GerenciadorDeInput;
import br.com.projetomario.marioworld.controle.CarregadorImagem;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Mario extends Entidade {

    public GerenciadorDeInput input;
    private BufferedImage spritePequeno;
    private BufferedImage spriteGrande;
    private boolean grande = false;
    private boolean viradoParaDireita = true;
    private double velocidadeY = 0;
    private final double gravidade = 0.5;
    private final double forcaPulo = -12;
    private boolean noChao = false;
    public boolean vivo = true;

    public Mario(int x, int y, GerenciadorDeInput input) {
        super(x, y, 32, 32);
        this.input = input;
        this.velocidade = 4;

        try {
            this.spritePequeno = CarregadorImagem.carregar("/imagens/Mario_1.png");
            this.spriteGrande = CarregadorImagem.carregar("/imagens/Mario_3.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ficarGrande() {
        if (!grande) {
            this.grande = true;
            this.altura = 64;
            this.y -= 32;
        }
    }

    public void ficarPequeno() {
        if (grande) {
            this.grande = false;
            this.altura = 32;
            this.y += 32;
        }
    }

    public boolean isGrande() {
        return grande;
    }

    public void atualizar(ArrayList<Bloco> blocos) {

        if (input.left) {
            x -= velocidade;
            viradoParaDireita = false;
        }
        if (input.right) {
            x += velocidade;
            viradoParaDireita = true;
        }

        if (input.devMode) {
            setX(3600);
            setY(200);
        }

        if (y > 700) {
            this.vivo = false;
        }

        checarColisaoHorizontal(blocos);

        velocidadeY += gravidade;
        y += (int) velocidadeY;

        if (input.up && noChao) {
            velocidadeY = forcaPulo;
            noChao = false;
        }

        checarColisaoVertical(blocos);

        if (y > 800) {
            x = 100; y = 100; velocidadeY = 0;
            if(grande) {
                ficarPequeno();
            }
        }
    }

    @Override
    public void atualizar() {
    }


    private void checarColisaoHorizontal(ArrayList<Bloco> blocos) {
        for (Bloco b : blocos) {
            if (this.getBounds().intersects(b.getBounds())) {
                if (x + largura / 2 < b.getX()) {
                    x = b.getX() - largura;
                }
                else if (x + largura / 2 > b.getX() + b.getLargura()) {
                    x = b.getX() + b.getLargura();
                }
            }
        }
    }

    private void checarColisaoVertical(ArrayList<Bloco> blocos) {
        noChao = false;

        for (Bloco b : blocos) {
            if (this.getBounds().intersects(b.getBounds())) {
                if (velocidadeY > 0) {
                    if (y + altura - velocidadeY < b.getY() + 15) {
                        y = b.getY() - altura;
                        velocidadeY = 0;
                        noChao = true;
                    }
                }
                else {
                    if (velocidadeY < 0) {
                        if (y - velocidadeY > b.getY() + b.getAltura() - 15) {
                            y = b.getY() + b.getAltura();
                            velocidadeY = 0;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void desenhar(Graphics2D g2) {
        BufferedImage spriteAtual = grande ? spriteGrande : spritePequeno;

        if (spriteAtual != null) {
            if (viradoParaDireita) {
                g2.drawImage(spriteAtual, x, y, largura, altura, null);
            } else {
                g2.drawImage(spriteAtual, x + largura, y, -largura, altura, null);
            }
        } else {
            g2.setColor(new Color(139, 19, 19));
            g2.fillRect(x, y, largura, altura);
        }
    }

    public GerenciadorDeInput getInput() {
        return input;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}