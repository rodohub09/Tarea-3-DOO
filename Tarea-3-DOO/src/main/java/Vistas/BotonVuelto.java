package Vistas;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonVuelto extends JButton {
    public BotonVuelto(){
        this.addActionListener(this.oyenteBoton);
    }
    private class oyenteBoton implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }
}
