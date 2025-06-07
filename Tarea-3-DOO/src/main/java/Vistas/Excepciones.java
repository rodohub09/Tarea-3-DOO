package Vistas;

import javax.swing.*;

public class Excepciones extends JDialog {
    public Excepciones(String string){
        super();
        JOptionPane.showMessageDialog(null,string,"Error",JOptionPane.INFORMATION_MESSAGE);
    }
}
