package Vistas;

import Modelos.Productos;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private PanelCoca coca;
    private PanelFanta fanta;
    private PanelSprite sprite;
    private PanelSuper8 super8;
    private PanelSnickers snickers;
    protected Image image;

    public PanelExpendedor() {
        super();
        setSize(730, 710);
        setLayout(null);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }
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

        JButton bv = new BotonVuelto(getClass().getClassLoader().getResource("Vuelto.png"));
        bv.setBounds(450,470,20,20);
        add(bv);

        añadirBotonComprar(Productos.CocaCola,420,255,80,32,"BotonCoca.png");
        añadirBotonComprar(Productos.Fanta,420,297,80,32,"BotonFanta.png");
        añadirBotonComprar(Productos.Sprite,420,337,80,32,"BotonSprite.png");
        añadirBotonComprar(Productos.Super8,420,380,80,32,"BotonSuper8.png");
        añadirBotonComprar(Productos.Snickers,420,420,80,32,"BotonSnickers.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0, 0,null);
    }

    private void añadirBotonComprar(Productos p,int x, int y, int w, int h, String s){
        JButton bv4 = new BotonComprarProducto(getClass().getClassLoader().getResource(s), p);
        bv4.setBounds(x,y,w,h);
        add(bv4);
    }
}
