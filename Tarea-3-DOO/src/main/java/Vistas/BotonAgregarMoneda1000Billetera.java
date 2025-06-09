package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.MonedaGen.getMonedaGen;

public class BotonAgregarMoneda1000Billetera extends JButton {
    private PanelBilletera panelBilletera;
    private BotonAgregarSaldo boton;

    public BotonAgregarMoneda1000Billetera(URL rutaImagen, PanelBilletera panelBilletera, BotonAgregarSaldo boton) {
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
            if(getComprador().billetera.getCantMonedas(1000)<21)
                getComprador().getBilletera().agregarMoneda(getMonedaGen().genMoneda1000());
            else{
                new Excepciones("No hay espacio para mas monedas de este tipo.");
            }



            panelBilletera.repintarMonedas();
        }
    }
}