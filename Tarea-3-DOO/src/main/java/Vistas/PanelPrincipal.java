package Vistas;
import java.awt.*;
import javax.swing.*;

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