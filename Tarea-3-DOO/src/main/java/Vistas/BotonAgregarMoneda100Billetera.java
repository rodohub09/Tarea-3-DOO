package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.MonedaGen.getMonedaGen;

public class BotonAgregarMoneda100Billetera extends JButton {
    private PanelBilletera panelBilletera;

    public BotonAgregarMoneda100Billetera(URL rutaImagen, PanelBilletera panelBilletera) {
        super(new ImageIcon(rutaImagen));
        this.panelBilletera = panelBilletera;

        addActionListener(new oyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    private class oyenteBoton implements ActionListener {
        static int i = 0;

        public void actionPerformed(ActionEvent ae) {
            getComprador().getBilletera().agregarMoneda(getMonedaGen().genMoneda100());

            ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource("Mini100.png"));
            panelBilletera.agregarMoneda(icono, 90, 30 + (i * 10));
            i++;
        }
    }
}