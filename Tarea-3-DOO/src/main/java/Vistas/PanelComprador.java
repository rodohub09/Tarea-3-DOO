package Vistas;

import javax.swing.*;
import java.awt.*;

import static Modelos.Comprador.getComprador;

public class PanelComprador extends JPanel {
    private PanelInventario inventario;
    private PanelBilletera billetera;
    private PanelMonedas monedas;
    private BotonAgregarSaldo botonAgregarSaldo;
    public BotonConsumir bc1;
    public BotonConsumir bc2;
    public BotonConsumir bc3;
    public BotonConsumir bc4;
    public BotonConsumir bc5;

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
        bc1 = crearBotonConsumir(0,550,166,140,65);
        bc2 = crearBotonConsumir(1,550,246,140,65);
        bc3 = crearBotonConsumir(2,550,326,140,65);
        bc4 = crearBotonConsumir(3,550,406,140,65);
        bc5 = crearBotonConsumir(4,550,486,140,65);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try{
            bc1.setSonido(getComprador().inventario.getProducto(0).getTipo().getSonido());
            bc2.setSonido(getComprador().inventario.getProducto(1).getTipo().getSonido());
            bc3.setSonido(getComprador().inventario.getProducto(2).getTipo().getSonido());
            bc4.setSonido(getComprador().inventario.getProducto(3).getTipo().getSonido());
            bc5.setSonido(getComprador().inventario.getProducto(4).getTipo().getSonido());
        } catch (NullPointerException e) {

        }

    }

    private BotonConsumir crearBotonConsumir(int i, int x, int y, int w, int h){
        BotonConsumir bcspn = null;
        try{
             bcspn = new BotonConsumir(i,getComprador().inventario.getProducto(i).getTipo().getSonido());
        } catch (NullPointerException e) {
             bcspn = new BotonConsumir(i,null);
        }finally {
            bcspn.setBounds(x,y,w,h);
            add(bcspn);
            return bcspn;
        }
    }
}
