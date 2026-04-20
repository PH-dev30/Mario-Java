package br.com.projetomario.marioworld.controle;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class CarregadorImagem {

    public static BufferedImage carregar(String caminho) {

        InputStream is = CarregadorImagem.class.getResourceAsStream(caminho);

        if (is == null) {
            return null;
        }

        try {
            return ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
