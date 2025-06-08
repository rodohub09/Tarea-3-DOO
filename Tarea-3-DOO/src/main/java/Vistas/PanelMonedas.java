package Vistas;

import javax.swing.*;

public class PanelMonedas extends JPanel {
    public PanelMonedas(PanelBilletera panelBilletera) {
        super();
        setLayout(null);
        setBounds(0, 0, 730, 710);
        setOpaque(false);

        JButton bv1000 = new BotonAgregarMoneda1000Billetera(
                getClass().getClassLoader().getResource("Moneda1000.png"),
                panelBilletera
        );
        bv1000.setBounds(400, 570, 100, 100);
        add(bv1000);

        JButton bv500 = new BotonAgregarMoneda500Billetera(
                getClass().getClassLoader().getResource("Moneda500.png"),
                panelBilletera);
        bv500.setBounds(505, 570, 100, 100);
        add(bv500);

        JButton bv100 = new BotonAgregarMoneda100Billetera(
                getClass().getClassLoader().getResource("Moneda100.png"),
                panelBilletera);
        bv100.setBounds(610, 570, 100, 100);
        add(bv100);
    }
}