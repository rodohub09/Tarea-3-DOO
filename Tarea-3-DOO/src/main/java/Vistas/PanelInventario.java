package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel {
    public PanelInventario(){
        super();
        setSize(730, 710);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Inventario.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image,540, 160,null);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
    }
}
