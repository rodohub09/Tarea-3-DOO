package Vistas;

import Modelos.Productos;

import javax.swing.*;
import java.awt.*;

import static Modelos.Expendedor.getExpendedor;

public class PanelExpendedor extends JPanel {
    private PanelCoca coca;
    private PanelFanta fanta;
    private PanelSprite sprite;
    private PanelSuper8 super8;
    private PanelSnickers snickers;
    protected Image image;
    private Caracteres saldo;

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

        coca.setBounds(205,100,220,100);
        setComponentZOrder(coca, 0);
        add(coca);
        BotonRefillDeposito refillcoca = new BotonRefillDeposito(Productos.CocaCola);
        refillcoca.setBounds(175,100,240,100);
        add(refillcoca);

        fanta.setBounds(205,200,220,100);
        setComponentZOrder(fanta, 1);
        add(fanta);
        BotonRefillDeposito refillfanta = new BotonRefillDeposito(Productos.Fanta);
        refillfanta.setBounds(175,200,240,100);
        add(refillfanta);

        sprite.setBounds(205,300,220,100);
        setComponentZOrder(sprite, 2);
        add(sprite);
        BotonRefillDeposito refillsprite = new BotonRefillDeposito(Productos.Sprite);
        refillsprite.setBounds(175,300,240,100);
        add(refillsprite);

        super8.setBounds(205,415,220,100);
        setComponentZOrder(super8, 3);
        add(super8);
        BotonRefillDeposito refillsuper8 = new BotonRefillDeposito(Productos.Super8);
        refillsuper8.setBounds(175,400,240,100);
        add(refillsuper8);

        snickers.setBounds(205,515,220,100);
        setComponentZOrder(snickers, 4);
        add(snickers);
        BotonRefillDeposito refillsnickers = new BotonRefillDeposito(Productos.Snickers);
        refillsnickers.setBounds(175,500,240,100);
        add(refillsnickers);

        JButton bv = new BotonVuelto(getClass().getClassLoader().getResource("Vuelto.png"));
        bv.setBounds(450,470,20,20);
        add(bv);

        añadirBotonComprar(Productos.CocaCola,420,255,80,32,"BotonCoca.png");
        añadirBotonComprar(Productos.Fanta,420,297,80,32,"BotonFanta.png");
        añadirBotonComprar(Productos.Sprite,420,337,80,32,"BotonSprite.png");
        añadirBotonComprar(Productos.Super8,420,380,80,32,"BotonSuper8.png");
        añadirBotonComprar(Productos.Snickers,420,420,80,32,"BotonSnickers.png");

        saldo = new Caracteres(null,21.0F);
        saldo.setBounds(419,165,80,30);
        saldo.setHorizontalAlignment(SwingConstants.CENTER);
        saldo.setVerticalAlignment(SwingConstants.CENTER);
        saldo.setForeground(Color.WHITE);
        add(saldo);

        añadirCaracteres("$" + Productos.CocaCola.getPrecio(),272,178,50,30,Color.WHITE,16.0F);
        añadirCaracteres("$" + Productos.Fanta.getPrecio(),272,278,50,30,Color.WHITE,16.0F);
        añadirCaracteres("$" + Productos.Sprite.getPrecio(),272,378,50,30,Color.WHITE,16.0F);
        añadirCaracteres("$" + Productos.Super8.getPrecio(),272,478,50,30,Color.WHITE,16.0F);
        añadirCaracteres("$" + Productos.Snickers.getPrecio(),272,578,50,30,Color.WHITE,16.0F);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0, 0,null);
        saldo.setCaracteres("$" + getExpendedor().getSaldo());
    }

    private void añadirBotonComprar(Productos p,int x, int y, int w, int h, String s){
        JButton bv4 = new BotonComprarProducto(getClass().getClassLoader().getResource(s), p);
        bv4.setBounds(x,y,w,h);
        add(bv4);
    }

    private void añadirCaracteres(String s,int x, int y, int w, int h,Color c,Float fl){
        Caracteres car = new Caracteres(s,fl);
        car.setBounds(x,y,w,h);
        car.setHorizontalAlignment(SwingConstants.CENTER);
        car.setVerticalAlignment(SwingConstants.CENTER);
        car.setForeground(c);
        add(car);
    }
}
