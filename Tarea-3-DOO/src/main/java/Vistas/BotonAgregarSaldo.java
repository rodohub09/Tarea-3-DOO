package Vistas;

import javax.swing.*;

public class BotonAgregarSaldo extends JButton {

    public BotonAgregarSaldo(PanelBilletera panelBilletera) {
        super();
        setFocusPainted(false);
        panelBilletera.repintarMonedas();
    }
}