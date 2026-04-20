package br.com.projetomario.marioworld.persistencia;


import java.io.*;

public class GerenciadorArquivos {

    private static final String NOME_ARQUIVO = "recorde.txt";

    public static int carregarRecorde() {
        try {
            File arquivo = new File(NOME_ARQUIVO);
            if (!arquivo.exists()) {
                return 0;
            }

            BufferedReader ler = new BufferedReader(new FileReader(arquivo));
            String linha = ler.readLine();
            ler.close();

            return Integer.parseInt(linha);

        } catch (IOException | NumberFormatException e) {
            return 0;
        }
    }

    public static void salvarRecorde(int novoRecorde) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(NOME_ARQUIVO));
            escritor.write(String.valueOf(novoRecorde));
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar recorde: " + e.getMessage());
        }
    }
}