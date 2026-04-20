package br.com.projetomario.marioworld.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField campoNome;
    private JButton btnEntrar;

    public TelaLogin() {
        setTitle("Login - Super Mario POO");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Nome do Jogador:"));
        campoNome = new JTextField(15);
        add(campoNome);

        btnEntrar = new JButton("Entrar");
        add(btnEntrar);
    }

    public void setAcaoBotao(ActionListener acao) {
        btnEntrar.addActionListener(acao);
    }

    public String getNomeJogador() {
        return campoNome.getText();
    }
}
