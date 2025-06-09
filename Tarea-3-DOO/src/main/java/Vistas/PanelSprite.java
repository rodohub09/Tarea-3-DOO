package Vistas;

import javax.swing.*;
import java.awt.*;
import static Modelos.Expendedor.getExpendedor;

/**
 * Este panel dibuja una imagen repetida de "Sprite" en función de la cantidad
 * disponible en el stock del expendedor.
 */
public class PanelSprite extends JPanel {
    protected Image image;

    public PanelSprite() {
        super();
        setOpaque(false);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Sprite.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar imagen Sprite.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (index < getExpendedor().getStock(getExpendedor().getSprite())){
                    g.drawImage(image, j * 45 + (1-i) * 30, i * 8, this);
                    index++;
                }
            }
        }
    }
}
