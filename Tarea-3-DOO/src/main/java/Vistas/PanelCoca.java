package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCoca extends JPanel {
    private ArrayList<Image> images;

    public PanelCoca() {
        super();
        setSize(730, 710);
        setOpaque(false);
        images = new ArrayList<>();
        try {
            Image image = new ImageIcon(getClass().getClassLoader().getResource("CocaCola.png")).getImage();
            for (int i = 0; i < 8; i++) {
                images.add(image);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar imagen CocaCola.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("hola");
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (index < images.size()) {
                    g.drawImage(images.get(index), j * 45 + (1-i) * 30, i * 8, this);
                    index++;
                }
            }
        }
    }

}
