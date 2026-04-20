package br.com.projetomario.marioworld.telas;

import br.com.projetomario.marioworld.persistencia.GerenciadorArquivos;
import br.com.projetomario.marioworld.Main;
import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    public TelaMenu(String nomeJogador) {
        setTitle("Menu Principal - Mario POO");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(null);

        getContentPane().setBackground(Color.BLACK);

        configurarComponentes(nomeJogador);
    }

    private void configurarComponentes(String nome) {
        JLabel titulo = new JLabel("SUPER MARIO POO");
        titulo.setForeground(Color.RED);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setBounds(50, 30, 400, 50);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titulo);

        JLabel lblBemVindo = new JLabel("Bem-vindo, " + nome + "!");
        lblBemVindo.setForeground(Color.WHITE);
        lblBemVindo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblBemVindo.setBounds(50, 100, 400, 30);
        lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblBemVindo);

        int recorde = GerenciadorArquivos.carregarRecorde();
        JLabel lblRecorde = new JLabel("Recorde: " + recorde + "Pontos!");
        lblRecorde.setForeground(Color.YELLOW);
        lblRecorde.setFont(new Font("Arial", Font.BOLD, 20));
        lblRecorde.setBounds(50, 150, 400, 30);
        lblRecorde.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblRecorde);

        JButton btnJogar = new JButton("INICIAR AVENTURA");
        btnJogar.setBounds(150, 220, 200, 50);
        btnJogar.setBackground(Color.GREEN);
        btnJogar.setFont(new Font("Arial", Font.BOLD, 16));
        btnJogar.setFocusable(false);

        btnJogar.addActionListener(e -> {
            this.dispose();
            Main.iniciarJogo(nome);
        });
        add(btnJogar);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(200, 290, 100, 30);
        btnSair.setBackground(Color.LIGHT_GRAY);
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
    }
}