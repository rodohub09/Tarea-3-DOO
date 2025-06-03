package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    public PanelComprador() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Inventario.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image,540, 180,null);
            ImageIcon imageIcon2 = new ImageIcon(getClass().getClassLoader().getResource("Billetera.png"));
            Image image2 = imageIcon2.getImage();
            g.drawImage(image2,452,600 ,null);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
    }
}
