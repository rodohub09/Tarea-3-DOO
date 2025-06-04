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
        exp = new PanelExpendedor();
        com = new PanelComprador();
        this.setBackground(Color.white);
        add(exp);
        add(com);
    }

}



