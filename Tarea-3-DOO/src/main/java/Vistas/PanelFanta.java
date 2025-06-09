package Vistas;

import javax.swing.*;
import java.awt.*;
import static Modelos.Expendedor.getExpendedor;

public class PanelFanta extends JPanel {
    protected Image image;

    public PanelFanta() {
        super();
        setOpaque(false);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Fanta.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar imagen CocaCola.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (index < getExpendedor().getStock(getExpendedor().getFanta())){
                    g.drawImage(image, j * 45 + (1-i) * 30, i * 8, this);
                    index++;
                }
            }
        }
    }
}
