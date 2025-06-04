package Vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana());
    }
}
