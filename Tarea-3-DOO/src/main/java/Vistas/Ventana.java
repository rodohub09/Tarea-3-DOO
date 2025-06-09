package Vistas;

import javax.swing.*;

public class Ventana extends JFrame {
    private static Ventana instancia;
    private Ventana() {
        super();
        setTitle("Expendedor");
        setSize(730, 710);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelPrincipal panel= new PanelPrincipal();
        add(panel);
        setVisible(true);
    }

    public static Ventana getInstance() {
        if (instancia == null){
            instancia = new Ventana();
        }
        return instancia;
    }

    public static void actualizar() {
        instancia.repaint();
    }
}
