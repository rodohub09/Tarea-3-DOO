package Vistas;

import Modelos.NoHayProductoException;
import Modelos.PagoInsuficienteException;
import Modelos.Productos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Expendedor.getExpendedor;

public class BotonComprarProducto extends JButton {
    public BotonComprarProducto(URL rutaImagen, Productos p){
        super(new ImageIcon(rutaImagen));
        this.addActionListener(new oyenteBoton(p));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    private class oyenteBoton implements ActionListener {
        Productos p;
        public oyenteBoton(Productos p){
            this.p = p;
        }

        public void actionPerformed(ActionEvent ae){
            try {
                getExpendedor().comprarProducto(p);
            } catch (PagoInsuficienteException e) {
                new Excepciones("No tienes saldo suficiente para comprar este producto.");
            } catch (NoHayProductoException e) {
                new Excepciones("No queda stock de este producto.");
            }
            Ventana.getInstance().repaint();
        }
    }
}
