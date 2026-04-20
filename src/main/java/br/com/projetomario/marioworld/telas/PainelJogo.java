package br.com.projetomario.marioworld.telas;

import br.com.projetomario.marioworld.controle.GerenciadorAudio;
import br.com.projetomario.marioworld.modelo.*;
import br.com.projetomario.marioworld.persistencia.GerenciadorArquivos;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class PainelJogo extends JPanel {

    private Mario mario;
    private ArrayList<Bloco> blocos;
    private Camera camera;
    private ArrayList<Inimigo> inimigos;
    private ArrayList<Entidade> itens;
    public int score = 0;
    public int vidas = 1;
    public int recorde;
    public boolean jogoRodando = true;
    public UI ui;
    public Bandeira bandeira;
    public boolean vitoria = false;

    public PainelJogo(Mario mario) {
        this.mario = mario;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(100, 149, 237));
        this.setDoubleBuffered(true);
        this.camera = new Camera(mario);
        this.ui = new UI(this);
        this.recorde = GerenciadorArquivos.carregarRecorde();

        criarFase();

        GerenciadorAudio musicaFundo = new GerenciadorAudio();
        musicaFundo.tocar("Tema.wav", true);
    }

    private void criarChao(int inicio, int fim, int y) {
        for (int i = inicio; i < fim; i++) {
            blocos.add(new Bloco(i * 32, y));
        }
    }

    private void criarPlataforma(int x, int y, int larguraEmBlocos) {
        for (int i = 0; i < larguraEmBlocos; i++) {
            blocos.add(new Bloco(x + (i * 32), y));
        }
    }

    private void criarParede(int x, int yChao, int alturaEmBlocos) {
        Color corVerdeTubo = new Color(0, 180, 0);

        for (int i = 0; i < alturaEmBlocos; i++) {
            blocos.add(new Bloco(x, yChao - (i * 32), corVerdeTubo));
            blocos.add(new Bloco(x + 32, yChao - (i * 32), corVerdeTubo));
        }
    }

    private void criarEscada(int xInicial, int numeroDegraus) {
        int tamanhoBloco = 32;
        int chaoY = 500;

        for (int i = 0; i < numeroDegraus; i++) {
            for (int j = 0; j <= i; j++) {
                int x = xInicial + (i * tamanhoBloco);
                int y = chaoY - tamanhoBloco - (j * tamanhoBloco);
                blocos.add(new Bloco(x, y));
            }
        }
    }

    private void criarTuboComAba(int xCentro, int yChao, int altura, int yAba) {
        criarParede(xCentro, yChao, altura);
        criarParede(xCentro - 32, yAba, 1);
        criarParede(xCentro + 32, yAba, 1);
    }

    private void criarLinhaMoedas(int xInicial, int y, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            itens.add(new Moeda(xInicial + (i * 32), y));
        }
    }

    private void criarFase() {
        blocos = new ArrayList<>();
        inimigos = new ArrayList<>();
        itens = new ArrayList<>();
        int yChao = 500;

        criarChao(0, 21, yChao);
        criarChao(32, 80, yChao);
        criarChao(85, 130, yChao);

        criarParede(0, 500, 20);

        criarEscada(700, 3);
        criarPlataforma(796, yChao - (3 * 32), 5);
        criarPlataforma(2000, 300, 4);

        criarTuboComAba(1400, yChao, 3, 410);
        criarTuboComAba(1800, yChao, 4, 380);
        criarTuboComAba(3800, yChao, 4, 380);

        itens.add(new Moeda(700, 430));
        itens.add(new Moeda(740, 400));
        itens.add(new Moeda(780, 370));

        criarLinhaMoedas(1368, 350, 4);
        criarLinhaMoedas(2000, 225, 4);
        criarLinhaMoedas(3300, 400, 5);

        itens.add(new Cogumelo(2000, 260));

        inimigos.add(new Goomba(500, 450));
        inimigos.add(new Goomba(800, 400));
        inimigos.add(new Goomba(1600, 450));
        inimigos.add(new Goomba(2200, 318));
        inimigos.add(new Goomba(2600, 400));
        inimigos.add(new Goomba(3000, 200));
        inimigos.add(new Goomba(3600, 400));

        criarEscada(3000, 8);

        this.bandeira = new Bandeira(3700, 200);
    }

    public ArrayList<Bloco> getBlocos() {
        return blocos;
    }
    public ArrayList<Entidade> getItens() {
        return itens;
    }
    public ArrayList<Inimigo> getInimigos() {
        return inimigos;
    }
    public void atualizarCamera() {
        camera.atualizar();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.translate(-camera.getX(), -camera.getY());

        if(mario != null) mario.desenhar(g2);
        if(bandeira != null) bandeira.desenhar(g2);

        for(Entidade e : itens) {
            e.desenhar(g2);
        }
        for(Bloco b : blocos) {
            b.desenhar(g2);
        }
        for(Inimigo ini : inimigos) {
            ini.desenhar(g2);
        }

        g2.translate(camera.getX(), camera.getY());

        ui.desenhar(g2);
        g2.dispose();
    }


    public void reiniciarJogo() {
        score = 0;
        vidas = 1;
        jogoRodando = true;

        criarFase();

        mario.setX(100);
        mario.setY(380);
        mario.vivo = true;
        if(mario.isGrande()) mario.ficarPequeno();

        vitoria = false;
    }
}