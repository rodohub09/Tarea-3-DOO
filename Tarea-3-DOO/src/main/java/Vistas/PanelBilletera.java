package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
            System.out.println("Error al cargar la imagen del expendedor.");
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
}