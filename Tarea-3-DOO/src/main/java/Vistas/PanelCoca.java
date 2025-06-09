package Vistas;

import javax.swing.*;
import java.awt.*;
import static Modelos.Expendedor.getExpendedor;

/**
 * Panel gráfico que representa las botellas de CocaCola disponibles en el {@link Modelos.Expendedor}.
 */
public class PanelCoca extends JPanel {

    /** Imagen que representa una botella de CocaCola */
    protected Image image;

    /**
     * Constructor que inicializa el panel y carga la imagen de la CocaCola.
     * En caso de error al cargar la imagen, muestra un mensaje en consola.
     */
    public PanelCoca() {
        super();
        setOpaque(false);
        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("CocaCola.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar imagen CocaCola.png");
        }
    }

    /**
     * Metodo encargado de pintar el componente.
     * Dibuja en el panel la cantidad de botellas de CocaCola disponibles en el expendedor,
     * mostrando solo hasta el stock actual.
     *
     * @param g objeto para realizar el dibujo.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        for (int i = 0; i < 2; i++) {          // filas
            for (int j = 0; j < 4; j++) {      // columnas
                if (index < getExpendedor().getStock(getExpendedor().getCoca())) {
                    g.drawImage(image, j * 45 + (1 - i) * 30, i * 8, this);
                    index++;
                }
            }
        }
    }
}
