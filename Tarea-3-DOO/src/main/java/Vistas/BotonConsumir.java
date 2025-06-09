package Vistas;

import Modelos.Inventario;
import Modelos.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static Modelos.Comprador.getComprador;

/**
 * Boton que consume un {@link Modelos.Producto} del inventario del {@link Modelos.Comprador}
 * */
public class BotonConsumir extends JButton {
    /**
     * Variable correspondiente al indice del inventario.
     */
    int i;
    /**
     * Variable correspondiente al nombre del sonido al consumir un producto.
     */
    String s;

    public BotonConsumir(int i, String s) {
        super(new ImageIcon());
        this.addActionListener(new oyenteBoton());
        this.i = i;
        this.s = s;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    /**
     * Metodo encargado de ejecutar la accion del boton, que en este caso, es consumir el producto, imprimir en la terminal el numero de serie de este y ademas reproducir un sonido.
     */
    private class oyenteBoton implements ActionListener {
        Inventario inventario = getComprador().inventario;

        public void actionPerformed(ActionEvent ae) {
            try {
                Producto producto = inventario.getProducto(i);
                inventario.consumirProducto(producto);
                System.out.println("Serie: " + producto.getSerie());
                reproducirSonido(s);
                Ventana.actualizar();
            } catch (IndexOutOfBoundsException | NullPointerException e) {

            }
        }
    }

    /**
     * Setter de sonido.
     * @param s Nombre de archivo.
     * */
    public void setSonido(String s){
        this.s = s;
    }

    /**
     * Metodo que reproduce el respectivo sonido.
     * @param s Nombre de archivo.
     * */
    private void reproducirSonido(String s){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(s));
            Clip c = AudioSystem.getClip();
            c.open(ais);
            c.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            new Excepciones("Consumiste el producto, por alguna razon no haces ruido al consumirlo (Falta archivo de audio).");
        }
    }
}