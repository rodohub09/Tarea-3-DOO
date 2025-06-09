package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import Modelos.*;

import static Modelos.Expendedor.getExpendedor;
import static Modelos.Comprador.getComprador;


public class BotonVuelto extends JButton {
    private PanelBilletera panelBilletera;

    public BotonVuelto(URL rutaImagen, PanelBilletera panelBilletera) {
        super(new ImageIcon(rutaImagen));
        this.panelBilletera = panelBilletera;
        this.addActionListener(new oyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    private class oyenteBoton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (getExpendedor().getMonVu().isEmpty()) {
                new Excepciones("No hay vuelto que recoger en el deposito, espero no te esten estafando.");
            } else {
                getComprador().tomarVuelto(getExpendedor());
                Ventana.getInstance().repaint();
                panelBilletera.repintarMonedas();
            }
        }
    }
}