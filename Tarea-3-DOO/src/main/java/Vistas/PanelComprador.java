package Vistas;

import javax.swing.*;
import java.awt.*;

import static Modelos.Comprador.getComprador;

/**
 * Panel principal que representa la interfaz gráfica del {@link Modelos.Comprador}.
 * Contiene los paneles de {@link PanelInventario}, {@link PanelBilletera} y {@link PanelMonedas},
 * así como botones para agregar saldo y consumir productos.
 */
public class PanelComprador extends JPanel {

    /** Panel que muestra el inventario de productos del comprador */
    private PanelInventario inventario;

    /** Panel que muestra la billetera del comprador con sus monedas */
    private PanelBilletera billetera;

    /** Panel que muestra las monedas disponibles para usar */
    private PanelMonedas monedas;

    /** Botón para agregar saldo a la billetera */
    private BotonAgregarSaldo botonAgregarSaldo;

    /** Botones para consumir productos del inventario */
    public BotonConsumir bc1;
    public BotonConsumir bc2;
    public BotonConsumir bc3;
    public BotonConsumir bc4;
    public BotonConsumir bc5;

    /**
     * Constructor que inicializa el panel comprador, configura el layout y
     * crea los componentes y botones necesarios.
     * Añade los paneles y botones al contenedor principal.
     */
    public PanelComprador() {
        super();
        setSize(730, 710);
        setLayout(null);
        setOpaque(false);

        billetera = new PanelBilletera();
        botonAgregarSaldo = new BotonAgregarSaldo(billetera);
        monedas = new PanelMonedas(billetera, botonAgregarSaldo);
        inventario = new PanelInventario();

        add(billetera);
        add(inventario);
        add(monedas);

        bc1 = crearBotonConsumir(0, 550, 166, 140, 65);
        bc2 = crearBotonConsumir(1, 550, 246, 140, 65);
        bc3 = crearBotonConsumir(2, 550, 326, 140, 65);
        bc4 = crearBotonConsumir(3, 550, 406, 140, 65);
        bc5 = crearBotonConsumir(4, 550, 486, 140, 65);
    }

    /**
     * Pinta el componente y actualiza los sonidos asociados a cada botón consumir
     * según el tipo de producto en el inventario del comprador.
     *
     * @param g objeto Graphics para pintar el componente
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            bc1.setSonido(getComprador().inventario.getProducto(0).getTipo().getSonido());
            bc2.setSonido(getComprador().inventario.getProducto(1).getTipo().getSonido());
            bc3.setSonido(getComprador().inventario.getProducto(2).getTipo().getSonido());
            bc4.setSonido(getComprador().inventario.getProducto(3).getTipo().getSonido());
            bc5.setSonido(getComprador().inventario.getProducto(4).getTipo().getSonido());
        } catch (NullPointerException e) {

        }
    }

    /**
     * Crea un botón consumir para el producto en la posición i del inventario.
     * El botón se posiciona con las coordenadas y tamaño indicados.
     * En caso de no encontrar sonido para el producto, se crea el botón sin sonido.
     *
     * @param i índice del producto en el inventario.
     * @param x coordenada horizontal para posicionar el botón.
     * @param y coordenada vertical para posicionar el botón.
     * @param w ancho del botón.
     * @param h alto del botón.
     * @return el botón consumir creado y añadido al panel.
     */
    private BotonConsumir crearBotonConsumir(int i, int x, int y, int w, int h) {
        BotonConsumir botonConsumir = null;
        try {
            botonConsumir = new BotonConsumir(i, getComprador().inventario.getProducto(i).getTipo().getSonido());
        } catch (NullPointerException e) {
            botonConsumir = new BotonConsumir(i, null);
        } finally {
            botonConsumir.setBounds(x, y, w, h);
            add(botonConsumir);
        }
        return botonConsumir;
    }

    /**
     * Getter del panel billetera asociado a este panel comprador.
     *
     * @return el panel billetera que muestra las monedas del comprador
     */
    public PanelBilletera getBilletera() {
        return billetera;
    }
}