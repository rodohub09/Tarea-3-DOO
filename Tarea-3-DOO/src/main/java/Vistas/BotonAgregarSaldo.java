package Vistas;

import Modelos.*;

import javax.swing.*;

public class BotonAgregarSaldo extends JButton {
    private Moneda moneda;
    private Billetera billetera;
    private Expendedor expendedor;
    private PanelBilletera panelBilletera;

    public BotonAgregarSaldo(Comprador comprador, Expendedor expendedor, PanelBilletera panelBilletera) {
        super();
        this.billetera = comprador.getBilletera();
        this.expendedor = expendedor;
        this.panelBilletera = panelBilletera;
        this.moneda = null;

        setEnabled(false);
        setFocusPainted(false);

        addActionListener(e -> ingresarMoneda());
    }

    public void setMonedaSeleccionada(Moneda moneda) {
        this.moneda = moneda;
        setEnabled(moneda != null); // habilita el boton solo si hay una moneda seleccionada.
    }

    private void ingresarMoneda() {
        if (moneda != null) {
            try {
                expendedor.ingresarMoneda(moneda);
                billetera.removerMoneda(moneda);


                // pintar nuevamente las monedas al momento de remover una.
                int moneda1000_x = 10;
                int moneda500_x = 50;
                int moneda100_x = 90;
                int x = 0;

                int y = 10;
                int i = 0;

                panelBilletera.removeAll();

                for (Moneda m : billetera.getMonedas()) {
                    ImageIcon icono = obtenerIconoParaMoneda(m);
                    JButton botonMoneda = new JButton(icono);

                    switch (m.getValor()) {
                        case 1000 -> x = moneda1000_x;
                        case 500 -> x = moneda500_x;
                        case 100 -> x = moneda100_x;
                        default -> {
                        }
                    }

                    botonMoneda.setBounds(x, y + (i * 30), icono.getIconWidth(), icono.getIconHeight());
                    botonMoneda.setContentAreaFilled(false);
                    botonMoneda.setBorderPainted(false);
                    botonMoneda.addActionListener(e -> setMonedaSeleccionada(m));

                    panelBilletera.add(botonMoneda);
                    i++;
                }
                panelBilletera.revalidate();
                panelBilletera.repaint();

                moneda = null;
                setEnabled(false);
            } catch (PagoIncorrectoException e) {
                moneda = null;
                setEnabled(false);
            }
        }
    }

    private ImageIcon obtenerIconoParaMoneda(Moneda m) {
        String nombreArchivo = "Mini" + m.getValor() + ".png";
        return new ImageIcon(getClass().getClassLoader().getResource(nombreArchivo));
    }
}