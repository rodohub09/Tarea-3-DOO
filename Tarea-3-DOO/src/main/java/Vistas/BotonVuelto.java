package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelos.Expendedor;


public class BotonVuelto extends JButton {
    PanelExpendedor pe;

    public BotonVuelto(PanelExpendedor pe){
        this.addActionListener(new oyenteBoton());
        this.pe = pe;
    }
    private class oyenteBoton implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            System.out.println("Hola");
        }



    }
}
