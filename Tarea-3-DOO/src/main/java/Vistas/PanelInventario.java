package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel {
    protected Image image;
    public PanelInventario(){
        super();
        setSize(730, 710);
        setOpaque(false);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Inventario.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,540, 160,null);
    }
}
