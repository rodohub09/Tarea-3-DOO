package Vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {
    private PanelCoca coca;
    private PanelFanta fanta;
    private PanelSprite sprite;
    private PanelSuper8 super8;
    private PanelSnickers snickers;

    public PanelExpendedor() {
        super();
        setSize(730, 710);
        setLayout(null);
        coca = new PanelCoca();
        fanta = new PanelFanta();
        sprite = new PanelSprite();
        super8 = new PanelSuper8();
        snickers = new PanelSnickers();
        add(coca);
        add(fanta);
        add(sprite);
        add(super8);
        add(snickers);
        BotonVuelto bv = new BotonVuelto(getClass().getClassLoader().getResource("Vuelto.png"));
        bv.setBounds(450,470,20,20);
        add(bv);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png"));
            Image image = imageIcon.getImage();
            g.drawImage(image,0, 0,null);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
    }
}
