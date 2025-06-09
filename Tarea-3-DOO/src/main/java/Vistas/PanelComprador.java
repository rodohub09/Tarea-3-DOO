package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    private PanelInventario inventario;
    private PanelBilletera billetera;
    private PanelMonedas monedas;
    private BotonAgregarSaldo botonAgregarSaldo;

    public PanelComprador() {
        super();
        setSize(730, 710);
        setLayout(null);
        setOpaque(false);

        billetera = new PanelBilletera();

        botonAgregarSaldo = new BotonAgregarSaldo(billetera);

        monedas = new PanelMonedas(billetera, botonAgregarSaldo);

        inventario = new PanelInventario();

        add(billetera);
        add(inventario);
        add(monedas);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
