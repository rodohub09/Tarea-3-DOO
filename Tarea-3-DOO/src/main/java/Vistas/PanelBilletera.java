package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelBilletera extends JPanel {
    public PanelBilletera(){
        super();
        setSize(730, 710);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Billetera.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image,0,0 ,null);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
    }
}
