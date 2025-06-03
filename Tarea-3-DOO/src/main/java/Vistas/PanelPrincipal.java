package Vistas;
import java.awt.*;
import javax.swing.*;
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal () {
        exp = new PanelExpendedor ();
        com = new PanelComprador();
        this.setBackground(Color.white);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        exp.paintComponent(g);
        com.paintComponent(g);
    }
}



