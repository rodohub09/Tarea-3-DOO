package Vistas;

import javax.swing.*;
import java.awt.*;

import static Modelos.Comprador.getComprador;

/**
 * Clase encargada del panel del inventario y asi tambien de la cantidad de productos que tiene.
 * */
public class PanelInventario extends JPanel {
    protected Image image;
    public PanelInventario(){
        super();
        setSize(730, 710);
        setOpaque(false);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Inventario.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen Inventario.png.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,540, 160,null);
        for(int i=0;i<getComprador().inventario.getSize();i++){
            Image ima = new ImageIcon(getClass().getClassLoader().getResource(getComprador().inventario.getProducto(i).getTipo().getFotoInv())).getImage();
            g.drawImage(ima,570,170+(i*80),null);
        }
    }
}
