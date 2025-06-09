package Vistas;
import java.awt.*;
import javax.swing.*;

/**
 * Este vendria siendo la clase que, como dice su nombre, es el panel principal donde los demas paneles se colocan encima.
 * */
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal () {
        super();
        setSize(730, 710);
        setLayout(null);
        this.setBackground(Color.white);

        com = new PanelComprador();
        exp = new PanelExpendedor(com.getBilletera());

        add(com);
        add(exp);
    }
}