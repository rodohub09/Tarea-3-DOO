package Vistas;

import Modelos.NoHayNadaEnElDepProd;
import Modelos.Productos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.Expendedor.getExpendedor;

public class BotonRecogerProducto extends JButton {
    public BotonRecogerProducto(){
        super();
        this.addActionListener(new oyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    private class oyenteBoton implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            try{
                getComprador().tomarProducto(getExpendedor());
            } catch (NoHayNadaEnElDepProd e) {
                new Excepciones("No hay nada que recoger en el deposito de productos comprados.");
            }
        }
    }
}
