package Vistas;

import javax.swing.*;

/**
 * Boton encargado de agregar una {@link Modelos.Moneda} al {@link Modelos.Expendedor}.
 * */
public class BotonAgregarSaldo extends JButton {

    /**
     * Contructor
     * */
    public BotonAgregarSaldo(PanelBilletera panelBilletera) {
        super();
        setFocusPainted(false);
        panelBilletera.repintarMonedas();
    }
}