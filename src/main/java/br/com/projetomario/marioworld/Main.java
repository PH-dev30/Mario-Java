package br.com.projetomario.marioworld;

import br.com.projetomario.marioworld.controle.GerenciadorDeInput;
import br.com.projetomario.marioworld.controle.LoopDoJogo;
import br.com.projetomario.marioworld.modelo.Mario;
import br.com.projetomario.marioworld.telas.PainelJogo;
import br.com.projetomario.marioworld.telas.TelaLogin;
import br.com.projetomario.marioworld.telas.TelaMenu;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        TelaLogin login = new TelaLogin();
        login.setVisible(true);

        login.setAcaoBotao(e -> {
            String nome = login.getNomeJogador();
            if(!nome.isEmpty()) {
                login.dispose();
                abrirMenu(nome);
            }
        });
    }

    public static void abrirMenu(String nomeJogador) {
        TelaMenu menu = new TelaMenu(nomeJogador);
        menu.setVisible(true);
    }

    public static void iniciarJogo(String nomeJogador) {

        JFrame janelaJogo = new JFrame("Mario POO");
        janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaJogo.setResizable(false);

        GerenciadorDeInput input = new GerenciadorDeInput();
        Mario mario = new Mario(100, 100, input);
        PainelJogo painel = new PainelJogo(mario);
        LoopDoJogo loop = new LoopDoJogo(painel, mario);

        janelaJogo.add(painel);
        janelaJogo.addKeyListener(input);
        janelaJogo.pack();
        janelaJogo.setLocationRelativeTo(null);
        janelaJogo.setVisible(true);

        loop.iniciar();
    }
}