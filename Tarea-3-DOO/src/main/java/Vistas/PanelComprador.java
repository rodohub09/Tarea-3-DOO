package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelInventario inventario;
    private PanelBilletera billetera;
    private PanelMonedas monedas;

    public PanelComprador() {
        super();
        setSize(730, 710);
        setLayout(null);
        setOpaque(false);

        inventario = new PanelInventario();
        billetera = new PanelBilletera();
        monedas = new PanelMonedas(billetera);

        add(billetera);
        add(inventario);
        add(monedas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
