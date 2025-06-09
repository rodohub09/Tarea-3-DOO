package Vistas;

import Modelos.Productos;

import javax.swing.*;
import java.awt.*;

import static Modelos.Expendedor.getExpendedor;

/**
 * Panel que representa visualmente el expendedor de productos.
 * Muestra las diferentes bebidas y snacks disponibles, los botones para comprar,
 * recargar productos, recoger productos y devolver vuelto, así como el saldo actual.
 */
public class PanelExpendedor extends JPanel {

    /** Panel que muestra las botellas de CocaCola */
    private PanelCoca coca;

    /** Panel que muestra las botellas de Sprite */
    private PanelSprite sprite;

    /** Panel que muestra las botellas de Fanta */
    private PanelFanta fanta;

    /** Panel que muestra las barras de Snickers */
    private PanelSnickers snickers;

    /** Panel que muestra las barras de Super8 */
    private PanelSuper8 super8;

    /** Imagen de fondo del expendedor */
    protected Image image;

    /** Imagen del producto seleccionado */
    protected Image producto;

    /** Componente que muestra el saldo disponible */
    private Caracteres saldo;

    /**
     * Constructor que inicializa el panel del expendedor,
     * carga la imagen de fondo, crea y posiciona paneles,
     * botones para cargar monedas, comprar, recoger vuelto
     * y para recoger producto.
     *
     * @param panelBilletera Panel que representa la billetera del comprador,
     *                       utilizado para el botón de devolución de vuelto.
     */
    public PanelExpendedor(PanelBilletera panelBilletera) {
        super();
        setSize(730, 710);
        setLayout(null);

        try {
            image = new ImageIcon(getClass().getClassLoader().getResource("Expendedor.png")).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen del expendedor.");
        }

        setProducto();

        coca = new PanelCoca();
        fanta = new PanelFanta();
        sprite = new PanelSprite();
        super8 = new PanelSuper8();
        snickers = new PanelSnickers();

        coca.setBounds(205, 100, 220, 100);
        setComponentZOrder(coca, 0);
        add(coca);
        BotonRefillDeposito refillcoca = new BotonRefillDeposito(Productos.CocaCola);
        refillcoca.setBounds(175, 100, 240, 100);
        add(refillcoca);

        sprite.setBounds(205, 200, 220, 100);
        setComponentZOrder(sprite, 2);
        add(sprite);
        BotonRefillDeposito refillsprite = new BotonRefillDeposito(Productos.Sprite);
        refillsprite.setBounds(175, 200, 240, 100);
        add(refillsprite);

        fanta.setBounds(205, 300, 220, 100);
        setComponentZOrder(fanta, 1);
        add(fanta);
        BotonRefillDeposito refillfanta = new BotonRefillDeposito(Productos.Fanta);
        refillfanta.setBounds(175, 300, 240, 100);
        add(refillfanta);

        snickers.setBounds(205, 415, 220, 100);
        setComponentZOrder(snickers, 4);
        add(snickers);
        BotonRefillDeposito refillsnickers = new BotonRefillDeposito(Productos.Snickers);
        refillsnickers.setBounds(175, 400, 240, 100);
        add(refillsnickers);

        super8.setBounds(205, 515, 220, 100);
        setComponentZOrder(super8, 3);
        add(super8);
        BotonRefillDeposito refillsuper8 = new BotonRefillDeposito(Productos.Super8);
        refillsuper8.setBounds(175, 500, 240, 100);
        add(refillsuper8);

        JButton bv = new BotonVuelto(getClass().getClassLoader().getResource("Vuelto.png"), panelBilletera);
        bv.setBounds(450, 470, 20, 20);
        add(bv);

        JButton bc = new BotonRecogerProducto();
        bc.setBounds(250, 600, 93, 46);
        add(bc);

        añadirBotonComprar(Productos.CocaCola, 420, 255, 80, 32, "BotonCoca.png");
        añadirBotonComprar(Productos.Sprite, 420, 297, 80, 32, "BotonSprite.png");
        añadirBotonComprar(Productos.Fanta, 420, 337, 80, 32, "BotonFanta.png");
        añadirBotonComprar(Productos.Snickers, 420, 380, 80, 32, "BotonSnickers.png");
        añadirBotonComprar(Productos.Super8, 420, 420, 80, 32, "BotonSuper8.png");

        saldo = new Caracteres(null, 21.0F);
        saldo.setBounds(419, 165, 80, 30);
        saldo.setHorizontalAlignment(SwingConstants.CENTER);
        saldo.setVerticalAlignment(SwingConstants.CENTER);
        saldo.setForeground(Color.WHITE);
        add(saldo);

        añadirCaracteres("$" + Productos.CocaCola.getPrecio(), 272, 178, 50, 30, Color.WHITE, 16.0F);
        añadirCaracteres("$" + Productos.Sprite.getPrecio(), 272, 278, 50, 30, Color.WHITE, 16.0F);
        añadirCaracteres("$" + Productos.Fanta.getPrecio(), 272, 378, 50, 30, Color.WHITE, 16.0F);
        añadirCaracteres("$" + Productos.Snickers.getPrecio(), 272, 478, 50, 30, Color.WHITE, 16.0F);
        añadirCaracteres("$" + Productos.Super8.getPrecio(), 272, 578, 50, 30, Color.WHITE, 16.0F);
    }

    /**
     * Metodo que pinta el componente, dibujando la imagen de fondo del expendedor,
     * actualizando el saldo mostrado y dibujando la imagen del producto actualmente seleccionado.
     *
     * @param g objeto para pintar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        saldo.setCaracteres("$" + getExpendedor().getSaldo());
        setProducto();
        if (producto != null)
            g.drawImage(producto, 262, 605, this);
    }

    /**
     * Añade un botón para comprar un producto específico.
     *
     * @param p producto asociado al botón.
     * @param x coordenada horizontal para posicionar el botón.
     * @param y coordenada vertical para posicionar el botón.
     * @param w ancho del botón.
     * @param h alto del botón.
     * @param s nombre del archivo de imagen del botón.
     */
    private void añadirBotonComprar(Productos p, int x, int y, int w, int h, String s) {
        JButton bv4 = new BotonComprarProducto(getClass().getClassLoader().getResource(s), p);
        bv4.setBounds(x, y, w, h);
        add(bv4);
    }

    /**
     * Añade un componente Caracteres para mostrar texto personalizado.
     *
     * @param s texto a mostrar.
     * @param x coordenada horizontal para posicionar el componente.
     * @param y coordenada vertical para posicionar el componente.
     * @param w ancho del componente.
     * @param h alto del componente.
     * @param c color del texto.
     * @param fl tamaño de fuente (float).
     */
    private void añadirCaracteres(String s, int x, int y, int w, int h, Color c, Float fl) {
        Caracteres car = new Caracteres(s, fl);
        car.setBounds(x, y, w, h);
        car.setHorizontalAlignment(SwingConstants.CENTER);
        car.setVerticalAlignment(SwingConstants.CENTER);
        car.setForeground(c);
        add(car);
    }

    /**
     * Actualiza la imagen del producto actualmente seleccionado en el expendedor,
     * cargando la imagen desde los recursos según el tipo de producto.
     * Si no hay producto seleccionado, la imagen se establece en null.
     */
    private void setProducto() {
        if (getExpendedor().getTipoProducto() != null) {
            try {
                producto = new ImageIcon(getClass().getClassLoader()
                        .getResource(getExpendedor().getTipoProducto().getFotodep())).getImage();
            } catch (Exception e) {
                System.out.println("Error al cargar la imagen del producto.");
            }
        } else {
            producto = null;
        }
    }
}