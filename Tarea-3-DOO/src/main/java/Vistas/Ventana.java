package Vistas;

import javax.swing.*;

/**
 * Clase de la ventana que contiene todos los paneles.
 * */
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

    /**
     * Al ser un singleton, este metodo se encarga de crear solo una instancia de ventana.
     * @return Instancia unica de ventana.
     * */
    public static Ventana getInstance() {
        if (instancia == null){
            instancia = new Ventana();
        }
        return instancia;
    }

    /**
     * Metodo encargado de realizar un repaint, o repintar la ventana y sus paneles.
     * */
    public static void actualizar() {
        instancia.repaint();
    }
}
