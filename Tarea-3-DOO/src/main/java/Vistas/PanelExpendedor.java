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
        coca.setBounds(205,100,400,100);
        setComponentZOrder(coca, 0);
        add(coca);
        fanta.setBounds(205,200,400,100);
        setComponentZOrder(fanta, 1);
        add(fanta);
        sprite.setBounds(205,300,400,100);
        setComponentZOrder(sprite, 2);
        add(sprite);
        super8.setBounds(205,415,400,100);
        setComponentZOrder(super8, 3);
        add(super8);
        snickers.setBounds(205,515,400,100);
        setComponentZOrder(snickers, 4);
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
