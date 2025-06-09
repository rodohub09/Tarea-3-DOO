package Vistas;

import Modelos.*;

import javax.swing.*;

public class BotonAgregarSaldo extends JButton {
    private Billetera billetera;
    private PanelBilletera panelBilletera;
    private Expendedor expendedor;

    public BotonAgregarSaldo(PanelBilletera panelBilletera) {
        super();
        this.billetera = Comprador.getComprador().getBilletera();
        this.panelBilletera = panelBilletera;
        this.expendedor = Expendedor.getExpendedor();

        setFocusPainted(false);

        repintarMonedas();
    }

    protected void repintarMonedas() {
        panelBilletera.removeAll();

        int moneda1000_x = 10;
        int moneda500_x = 50;
        int moneda100_x = 90;

        int y_inicial = 10;

        int contador1000 = 0;
        int contador500 = 0;
        int contador100 = 0;

        System.out.println("Monedas en billetera: " + billetera.getMonedas().size());
        for (Moneda m : billetera.getMonedas()) {
            ImageIcon icono = obtenerIconoParaMoneda(m);
            JButton botonMoneda = new JButton(icono);

            int x = 0;
            int y = 0;

            switch (m.getValor()) {
                case 1000 -> {
                    x = moneda1000_x;
                    y = y_inicial + (contador1000 * 30);
                    contador1000++;
                }
                case 500 -> {
                    x = moneda500_x;
                    y = y_inicial + (contador500 * 30);
                    contador500++;
                }
                case 100 -> {
                    x = moneda100_x;
                    y = y_inicial + (contador100 * 30);
                    contador100++;
                }
            }

            botonMoneda.setBounds(x, y, icono.getIconWidth(), icono.getIconHeight());
            botonMoneda.setContentAreaFilled(false);
            botonMoneda.setBorderPainted(false);

            botonMoneda.addActionListener(e -> {
                try {
                    expendedor.ingresarMoneda(m);
                    billetera.removerMoneda(m);
                    repintarMonedas();
                } catch (PagoIncorrectoException ex) {
                    new Excepciones("Error al ingresar moneda.");
                }
            });

            panelBilletera.add(botonMoneda);
        }

        panelBilletera.revalidate();
        panelBilletera.repaint();
    }

    private ImageIcon obtenerIconoParaMoneda(Moneda m) {
        String nombreArchivo = "Mini" + m.getValor() + ".png";
        return new ImageIcon(getClass().getClassLoader().getResource(nombreArchivo));
    }

    public void setPanelBilletera(PanelBilletera panelBilletera) {
        this.panelBilletera = panelBilletera;
        repintarMonedas();
    }
}