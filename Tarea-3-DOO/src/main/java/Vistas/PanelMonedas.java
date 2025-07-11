package Vistas;

import javax.swing.*;

/**
 * Este panel dibuja una imagen de los botones que generan monedas en el inventario.
 */
public class PanelMonedas extends JPanel {
    public PanelMonedas(PanelBilletera panelBilletera, BotonAgregarSaldo botonAgregarSaldo) {
        super();
        setLayout(null);
        setBounds(0, 0, 730, 710);
        setOpaque(false);

        JButton bv1000 = new BotonAgregarMoneda1000Billetera(
                getClass().getClassLoader().getResource("Moneda1000.png"),
                panelBilletera,
                botonAgregarSaldo
        );
        bv1000.setBounds(400, 570, 100, 100);
        add(bv1000);

        JButton bv500 = new BotonAgregarMoneda500Billetera(
                getClass().getClassLoader().getResource("Moneda500.png"),
                panelBilletera,
                botonAgregarSaldo
        );
        bv500.setBounds(505, 570, 100, 100);
        add(bv500);

        JButton bv100 = new BotonAgregarMoneda100Billetera(
                getClass().getClassLoader().getResource("Moneda100.png"),
                panelBilletera,
                botonAgregarSaldo
        );
        bv100.setBounds(610, 570, 100, 100);
        add(bv100);
    }
}