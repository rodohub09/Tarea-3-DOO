package Vistas;

import Modelos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static Modelos.Comprador.getComprador;
import static Modelos.Expendedor.getExpendedor;

public class PanelBilletera extends JPanel {
    protected Image image;
    private ArrayList<JLabel> monedas;

    public PanelBilletera() {
        super();
        setLayout(null);
        setBounds(0, 0, 140, 680);
        setOpaque(false);
        monedas = new ArrayList<>();

        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Billetera.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen Billetera.png.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0 ,null);
    }

    public void agregarMoneda(ImageIcon icon, int x, int y) {
        if (icon == null) {
            System.out.println("icono null");
            return;
        }

        JLabel moneda = new JLabel(icon);
        moneda.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        monedas.add(moneda);
        this.add(moneda);
        repaint();
        revalidate();
    }

    protected void repintarMonedas() {
        this.removeAll();

        int moneda1000_x = 10;
        int moneda500_x = 50;
        int moneda100_x = 90;

        int y_inicial = 10;

        int contador1000 = 0;
        int contador500 = 0;
        int contador100 = 0;

        Expendedor expendedor = getExpendedor();
        Comprador comprador = getComprador();
        Billetera billetera = comprador.getBilletera();

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
                    System.out.println("Serie de la moneda ingresada: "+ m.getSerie());
                    expendedor.ingresarMoneda(m);
                    billetera.removerMoneda(m);
                    this.repintarMonedas();
                } catch (PagoIncorrectoException ex) {
                    new Excepciones("Error al ingresar moneda.");
                }
            });

            this.add(botonMoneda);
        }

        this.revalidate();
        this.repaint();
    }

    private ImageIcon obtenerIconoParaMoneda(Moneda m) {
        String nombreArchivo = "Mini" + m.getValor() + ".png";
        return new ImageIcon(getClass().getClassLoader().getResource(nombreArchivo));
    }
}