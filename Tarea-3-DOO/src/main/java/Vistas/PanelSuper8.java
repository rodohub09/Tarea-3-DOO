package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSuper8 extends JPanel {
    private ArrayList<Image> images;

    public PanelSuper8() {
        super();
        setSize(730, 710);
        setOpaque(false);
        images = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i=0 ; i<2 ; i++) {
            for (int j=0 ; j<4; j++) {
                try {
                    ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Super8.png"));
                    Image image = imageIcon.getImage();
                    images.add(image);
                    g.drawImage(image, 235 +j*45 -i*30,415 + i*8 , null);
                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen del expendedor.");
                }
            }
        }
    }
}
