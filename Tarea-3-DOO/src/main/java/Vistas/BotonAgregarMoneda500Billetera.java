package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.MonedaGen.getMonedaGen;

public class BotonAgregarMoneda500Billetera extends JButton {
    private PanelBilletera panelBilletera;
    private BotonAgregarSaldo boton;

    public BotonAgregarMoneda500Billetera(URL rutaImagen, PanelBilletera panelBilletera, BotonAgregarSaldo boton) {
        super(new ImageIcon(rutaImagen));
        this.panelBilletera = panelBilletera;
        this.boton = boton;

        addActionListener(new OyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            getComprador().getBilletera().agregarMoneda(getMonedaGen().genMoneda500());

            boton.repintarMonedas();
        }
    }
}