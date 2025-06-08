package Modelos;

import java.util.ArrayList;

/**
 * Maquina expendedora de diversos productos(6), apilados en sus respectivos depositos.
 */

public class Expendedor {

    /**
     * Variables privadas de cada {@link Deposito}, con el nombre del producto que almacena y una variable privada de {@link Producto} para almacenar el producto comprado en el depósito.
     * */
    private static Expendedor expendedor;
    protected Deposito<Bebida> coca;
    protected Deposito<Bebida> sprite;
    protected Deposito<Bebida> fanta;
    protected Deposito<Dulce> snickers;
    protected Deposito<Dulce> super8;
    protected Deposito<Moneda> monVu;
    private Deposito<Moneda> monedas;
    protected Producto depositoProducto;
    public int saldo;
    private int totalp;

    /**
     * Constructor
     * @param stock cantidad de {@link Producto} que pueden almacenar los depositos del expendedor.
     * */
    private Expendedor(int stock){
        saldo = 0;
        totalp = stock;
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();
        monedas = new Deposito<>();
        depositoProducto = null;

        for (int i = 0; i < stock; i++) {
            coca.addItem(new CocaCola());
            sprite.addItem(new Sprite());
            fanta.addItem(new Fanta());
            snickers.addItem(new Snickers());
            super8.addItem(new Super8());
        }
        saldo = 1000;
    }

    public static Expendedor getExpendedor() {
        if (expendedor == null)
            expendedor = new Expendedor(8);
        return expendedor;
    }

    /**
     *<p> Refiere a la accion de comprar un producto de la maquina expendedora, pidiendo seleccionar el producto y pagarlo
     * para posteriormente expulsar dicho producto.</p>
     *<p>@param p A traves del enum {@link Productos}, se ocupa el numero de opcion, para que la expendedora identifique
     *          el producto a comprar.</p>
     * @throws PagoIncorrectoException Lanza esta excepcion, al entregar un <b>valor nulo</b> como moneda.
     * @throws PagoInsuficienteException Lanza esta excepción, al entregar una moneda con valor <b>menor</b> al precio del producto seleccionado.
     * @throws NoHayProductoException Lanza esta excepcion, al intentar comprar un producto el cual <b>ya no tiene stock.</b>
     * */
    public void comprarProducto(Productos p) throws PagoInsuficienteException,NoHayProductoException {
        if (this.saldo < p.getPrecio()) {
            throw new PagoInsuficienteException();
        }

        Producto product = getProducto(p);
        MonedaGen generador = MonedaGen.getMonedaGen();

        int vuelto = saldo - p.getPrecio();
        while (vuelto > 0) {
            if (vuelto >= 1000) {
                monVu.addItem(generador.genMoneda1000());
                vuelto -= 1000;
            } else if (vuelto >= 500) {
                monVu.addItem(generador.genMoneda500());
                vuelto -= 500;
            } else if (vuelto >= 100) {
                monVu.addItem(generador.genMoneda100());
                vuelto -= 100;
            } else {
                break;
            }
        }
        this.saldo = 0;
        depositoProducto = product;
    }

    private Producto getProducto(Productos p) throws NoHayProductoException {
        Producto product = null;
        switch (p.getOpcion()) {
            case 1 -> product = coca.getItem();
            case 2 -> product = sprite.getItem();
            case 3 -> product = fanta.getItem();
            case 4 -> product = snickers.getItem();
            case 5 -> product = super8.getItem();
            default -> {
            }
        }

        if (product == null)
            throw new NoHayProductoException();
        return product;
    }

    public void ingresarMoneda(Moneda m) throws PagoIncorrectoException{
        if(m == null)
            throw new PagoIncorrectoException();

        saldo += m.getValor();
        monedas.addItem(m);
    }

    public ArrayList getMonVu(){
        return monVu.getDep();
    }

    public int getStock(Deposito dep){
        return dep.getDep().size();
    }

    public Deposito<Bebida> getCoca() {
        return coca;
    }

    public Deposito<Bebida> getFanta() {
        return fanta;
    }

    public Deposito<Bebida> getSprite() {
        return sprite;
    }

    public Deposito<Dulce> getSuper8() {
        return super8;
    }

    public Deposito<Dulce> getSnickers() {
        return snickers;
    }

    public void refillDeposito(Productos productos) {
        switch (productos.getOpcion()) {
            case 1 -> {while(coca.getDep().size()<totalp) coca.addItem(new CocaCola());}
            case 2 -> {while(fanta.getDep().size()<totalp) fanta.addItem(new Fanta());}
            case 3 -> {while(sprite.getDep().size()<totalp) sprite.addItem(new Sprite());}
            case 4 -> {while(super8.getDep().size()<totalp) super8.addItem(new Super8());}
            case 5 -> {while(snickers.getDep().size()<totalp) snickers.addItem(new Snickers());}
            default -> {
            }
        }
    }


}