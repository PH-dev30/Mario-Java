package br.com.projetomario.marioworld.controle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class GerenciadorAudio {

    private Clip clip;

    public void tocar(String nomeArquivo, boolean loop) {
        try {
            URL url = getClass().getResource("/music/" + nomeArquivo);

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(audioIn);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}