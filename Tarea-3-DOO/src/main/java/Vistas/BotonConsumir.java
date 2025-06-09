package Vistas;

import Modelos.NoHayProductoException;
import Modelos.PagoInsuficienteException;
import Modelos.Productos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import static Modelos.Comprador.getComprador;
import static Modelos.Expendedor.getExpendedor;

public class BotonConsumir extends JButton {
    public BotonConsumir(int i, String s){
        super(new ImageIcon());
        this.addActionListener(new oyenteBoton(i,s));
        /*setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false)*/
    }
    private class oyenteBoton implements ActionListener {
        int i;
        String s;

        public oyenteBoton(int i, String s){
            this.i = i;
            this.s = s;
        }

        public void actionPerformed(ActionEvent ae){
            try {
                getComprador().inventario.consumirProducto(i);
            }
            catch(IndexOutOfBoundsException e){

            }finally {
                reproducirSonido(s);
                Ventana.getInstance().repaint();
            }
        }
    }

    private void reproducirSonido(String s){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(s));
            Clip c = AudioSystem.getClip();
            c.open(ais);
            c.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            new Excepciones("Consumiste el producto, por alguna razon no haces ruido al consumirlo (Falta archivo de audio).");
        }
    }
}
