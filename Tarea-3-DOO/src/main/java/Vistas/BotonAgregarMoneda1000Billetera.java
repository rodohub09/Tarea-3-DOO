package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.MonedaGen.getMonedaGen;

public class BotonAgregarMoneda1000Billetera extends JButton {
    public BotonAgregarMoneda1000Billetera(URL rutaImagen){
        super(new ImageIcon(rutaImagen));
        this.addActionListener(new oyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    private class oyenteBoton implements ActionListener {
        public int m;
        static int i = 0;
        public oyenteBoton(){

        }

        public void actionPerformed(ActionEvent ae){
            System.out.println(getComprador().billetera);
            getComprador().agregarDineroEnBilletera(getMonedaGen().genMoneda1000());
            System.out.println(getComprador().billetera + "----------" + getComprador().billetera.get(i).getSerie() + "----------" + i);
            i++;
        }
    }
}
