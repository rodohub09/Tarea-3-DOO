package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static Modelos.Comprador.getComprador;
import static Modelos.MonedaGen.getMonedaGen;

/**
 * Botón para agregar una {@link Modelos.Moneda} de 500 a la {@link Modelos.Billetera} del {@link Modelos.Comprador}.
 */
public class BotonAgregarMoneda500Billetera extends JButton {
    /** Panel que representa la billetera donde se muestran las monedas. */
    private PanelBilletera panelBilletera;

    /** Botón de agregar saldo asociado.*/
    protected BotonAgregarSaldo boton;

    /**
     * Constructor que crea el botón con el ícono de la {@link Modelos.Moneda} y asocia la {@link Modelos.Billetera} y el botón de saldo.
     *
     * @param rutaImagen URL de la imagen para el ícono del botón.
     * @param panelBilletera Panel donde se muestran las monedas.
     * @param boton Botón asociado para agregar saldo.
     */
    public BotonAgregarMoneda500Billetera(URL rutaImagen, PanelBilletera panelBilletera, BotonAgregarSaldo boton) {
        super(new ImageIcon(rutaImagen));
        this.panelBilletera = panelBilletera;
        this.boton = boton;

        addActionListener(new OyenteBoton());
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    /**
     * Clase interna que escucha el evento de clic en el botón.
     * Agrega una {@link Modelos.Moneda} de 500 a la {@link Modelos.Billetera} del {@link Modelos.Comprador} si hay espacio.
     * Si no hay espacio, muestra un mensaje de error personalizado.
     */
    private class OyenteBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(getComprador().billetera.getCantMonedas(500)<21)
                getComprador().getBilletera().agregarMoneda(getMonedaGen().genMoneda500());
            else{
                new Excepciones("No hay espacio para mas monedas de este tipo.");
            }
            panelBilletera.repintarMonedas();
        }
    }
}