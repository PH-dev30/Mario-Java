package br.com.projetomario.marioworld.controle;


import br.com.projetomario.marioworld.modelo.Cogumelo;
import br.com.projetomario.marioworld.modelo.Coletavel;
import br.com.projetomario.marioworld.modelo.Inimigo;
import br.com.projetomario.marioworld.modelo.Entidade;
import br.com.projetomario.marioworld.modelo.Mario;
import br.com.projetomario.marioworld.persistencia.GerenciadorArquivos;
import br.com.projetomario.marioworld.telas.PainelJogo;


public class LoopDoJogo implements Runnable {

    private PainelJogo painel;
    private Mario mario;
    private Thread gameThread;
    private final int FPS = 60;
    private boolean rodando = false;

    public LoopDoJogo(PainelJogo painel, Mario mario) {
        this.painel = painel;
        this.mario = mario;
    }

    public void iniciar() {
        rodando = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (rodando) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                atualizarJogo();
                painel.repaint();
                delta--;
            }
        }
    }

    private void atualizarJogo() {
        if (painel.jogoRodando && !painel.vitoria) {

            mario.atualizar(painel.getBlocos());

            if (!mario.vivo) {

                painel.vidas = 0;
                painel.jogoRodando = false;

                if (painel.score > painel.recorde) {
                    painel.recorde = painel.score;
                    GerenciadorArquivos.salvarRecorde(painel.recorde);
                }
                return;
            }

            painel.atualizarCamera();

            for(Inimigo ini : painel.getInimigos()) {
                ini.moverSozinho(painel.getBlocos());
            }

            if (mario.getBounds().intersects(painel.bandeira.getBounds())) {
                painel.vitoria = true;
                painel.jogoRodando = false;

                painel.score += 1000;

                if (painel.score > painel.recorde) {
                    painel.recorde = painel.score;
                    GerenciadorArquivos.salvarRecorde(painel.recorde);
                }
            }

            var listaItens = painel.getItens();

            for(int i = 0; i < listaItens.size(); i++) {
                Entidade item = listaItens.get(i);

                if (item instanceof Cogumelo) {
                    ((Cogumelo) item).moverSozinho(painel.getBlocos());
                }

                if (mario.getBounds().intersects(item.getBounds())) {

                    if (item instanceof Coletavel) {

                        int pontosGanhos = ((Coletavel) item).aoSerColetado(mario);

                        painel.score += pontosGanhos;
                    }

                    listaItens.remove(i);
                    i--;
                }
            }

            checarColisaoInimigos();

        } else {

            if (mario.getInput().restart) {
                painel.reiniciarJogo();
            }
        }
    }

    private void checarColisaoInimigos() {
        var listaInimigos = painel.getInimigos();

        for (int i = 0; i < listaInimigos.size(); i++) {
            Inimigo inimigo = listaInimigos.get(i);

            if (mario.getBounds().intersects(inimigo.getBounds())) {
                if (mario.getY() + mario.getAltura() < inimigo.getY() + 20) {
                    listaInimigos.remove(i);
                    i--;
                    painel.score += 100;
                } else {

                    if (mario.isGrande()) {
                        mario.ficarPequeno();

                        listaInimigos.remove(i);

                    } else {
                        painel.vidas--;

                        listaInimigos.remove(i);

                        if (painel.vidas <= 0) {
                            painel.jogoRodando = false;

                            if (painel.score > painel.recorde) {
                                painel.recorde = painel.score;
                                GerenciadorArquivos.salvarRecorde(painel.recorde);
                            }
                        }
                    }
                }
            }
        }
    }
}