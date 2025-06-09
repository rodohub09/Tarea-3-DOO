package Vistas;

import Modelos.*;
import javax.swing.*;
import java.awt.*;
import static Modelos.Comprador.getComprador;
import static Modelos.Expendedor.getExpendedor;

/**
 * Panel gráfico que representa la {@link Billetera} donde se muestran las {@link Moneda} del {@link Comprador}.
 * Permite agregar visualmente monedas, repintarlas y manejar su interacción.
 */
public class PanelBilletera extends JPanel {

    /** Imagen de fondo que representa la billetera */
    protected Image image;

    /**
     * Constructor que inicializa el panel, configura su tamaño y carga la imagen de fondo.
     * En caso de error al cargar la imagen, se muestra un mensaje de error.
     */
    public PanelBilletera() {
        super();
        setLayout(null);
        setBounds(0, 0, 140, 680);
        setOpaque(false);

        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Billetera.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen Billetera.png.");
        }
    }

    /**
     * Pinta el componente incluyendo la imagen de fondo de la {@link Billetera}.
     *
     * @param g objeto para dibujar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    /**
     * Repinta todas las {@link Moneda} de la {@link Billetera} en el panel.
     * Organiza las monedas por su valor (1000, 500, 100) en columnas y filas.
     * Cada {@link Moneda} es representada por un botón sin decoración que permite ingresar la {@link Moneda}
     * al {@link Expendedor} al hacer clic.
     * Actualiza la interfaz tras cada acción.
     */
    protected void repintarMonedas() {
        this.removeAll();

        int moneda1000_x = 10;
        int moneda500_x = 50;
        int moneda100_x = 90;

        int y_inicial = 10;

        int contador1000 = 0;
        int contador500 = 0;
        int contador100 = 0;

        Expendedor expendedor = getExpendedor();
        Comprador comprador = getComprador();
        Billetera billetera = comprador.getBilletera();

        for (Moneda m : billetera.getMonedas()) {
            ImageIcon icono = obtenerIconoParaMoneda(m);
            JButton botonMoneda = new JButton(icono);

            int x = 0;
            int y = 0;

            switch (m.getValor()) {
                case 1000 -> {
                    x = moneda1000_x;
                    y = y_inicial + (contador1000 * 30);
                    contador1000++;
                }
                case 500 -> {
                    x = moneda500_x;
                    y = y_inicial + (contador500 * 30);
                    contador500++;
                }
                case 100 -> {
                    x = moneda100_x;
                    y = y_inicial + (contador100 * 30);
                    contador100++;
                }
            }

            botonMoneda.setBounds(x, y, icono.getIconWidth(), icono.getIconHeight());
            botonMoneda.setContentAreaFilled(false);
            botonMoneda.setBorderPainted(false);

            botonMoneda.addActionListener(e -> {
                try {
                    System.out.println("Serie de la moneda ingresada: " + m.getSerie());
                    expendedor.ingresarMoneda(m);
                    billetera.removerMoneda(m);
                    this.repintarMonedas();
                } catch (PagoIncorrectoException ex) {
                    new Excepciones("Error al ingresar moneda.");
                }
            });

            this.add(botonMoneda);
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * Obtiene el icono correspondiente a una {@link Moneda} según su valor.
     * Busca un recurso con el nombre "Mini(valor).png".
     *
     * @param m Moneda para la cual se quiere obtener el ícono.
     * @return Imagen que representa gráficamente la moneda.
     */
    private ImageIcon obtenerIconoParaMoneda(Moneda m) {
        String nombreArchivo = "Mini" + m.getValor() + ".png";
        return new ImageIcon(getClass().getClassLoader().getResource(nombreArchivo));
    }
}