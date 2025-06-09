package Vistas;

import Modelos.Productos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Modelos.Expendedor.getExpendedor;

/**
 * Boton que rellena el {@link Modelos.Deposito} con sus respectivos {@link Productos}.
 * */
public class BotonRefillDeposito extends JButton {
    public BotonRefillDeposito(Productos p){
        super();
        this.addActionListener(new BotonRefillDeposito.oyenteBoton(p));
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
            getExpendedor().refillDeposito(p);
            Ventana.actualizar();
        }
    }
}
