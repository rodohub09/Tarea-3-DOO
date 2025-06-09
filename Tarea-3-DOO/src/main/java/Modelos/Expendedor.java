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
    /**
     * Variables de {@link Deposito} encargadas de almacenar {@link Moneda}s, ya sea el vuelto que se entrega o las que ocupa {@link Comprador}
     * */
    protected Deposito<Moneda> monVu;
    private Deposito<Moneda> monedas;
    protected Producto depositoProducto;
    public int saldo;
    private int totalp;

    /**
     * Constructor privado puesto que es un singleton.
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
    }

    /**
     * Metodo que se encarga de crear un expendedor unico y posteriormente retornarlo.
     * @return expendedor en accion.
     * */
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
    public void comprarProducto(Productos p) throws PagoInsuficienteException,NoHayProductoException,DepositoProductoLlenoException {
        if (depositoProducto!=null){
            throw new DepositoProductoLlenoException();
        }

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

    /**
     *Getter de un {@link Producto} de la maquina.
     * @param p Cual de todos los {@link Productos} debe entregar el {@link Expendedor}.
     * @throws NoHayVueltoException Sucede al no haber vuelto en el deposito de vuelto.
     * @return Producto que se selecciono.
     * */
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

    /**
     * Metodo que ingresa una moneda al {@link Expendedor}, para poder comprar.
     * @param m {@link Moneda} ingresada como metodo de pago.
     * @throws PagoIncorrectoException No se coloco un metodo de pago valido (Cualquier dato que no sea una moneda).
     * */
    public void ingresarMoneda(Moneda m) throws PagoIncorrectoException{
        if(m == null)
            throw new PagoIncorrectoException();

        saldo += m.getValor();
        monedas.addItem(m);
    }

    /**
     * Getter del deposito de monedas de vuelto.
     * @return Deposito de monedas de vuelto.
     * */
    public ArrayList getMonVu(){
        return monVu.getDep();
    }

    /**
     * Getter del stock de un {@link Deposito}.
     * @param dep {@link Deposito}
     * @return Cantidad de elementos dentro del {@link Deposito}.
     * */
    public int getStock(Deposito dep){
        return dep.getDep().size();
    }

    /**
     * Getter del {@link Deposito} de {@link CocaCola}.
     * @return Deposito de {@link CocaCola}.
     * */
    public Deposito<Bebida> getCoca() {
        return coca;
    }

    /**
     * Getter del {@link Deposito} de {@link Fanta}.
     * @return Deposito de {@link Fanta}.
     * */
    public Deposito<Bebida> getFanta() {
        return fanta;
    }

    /**
     * Getter del {@link Deposito} de {@link Sprite}.
     * @return Deposito de {@link Sprite}.
     * */
    public Deposito<Bebida> getSprite() {
        return sprite;
    }

    /**
     * Getter del {@link Deposito} de {@link Super8}.
     * @return Deposito de {@link Super8}.
     * */
    public Deposito<Dulce> getSuper8() {
        return super8;
    }

    /**
     * Getter del {@link Deposito} de {@link Snickers}.
     * @return Deposito de {@link Snickers}.
     * */
    public Deposito<Dulce> getSnickers() {
        return snickers;
    }

    /**
     * Metodo encargado de rellenar un respectivo {@link Deposito}
     * @param productos que se relleneran, en su respectivo {@link Deposito}.
     * */
    public void refillDeposito(Productos productos) {

        switch (productos.getOpcion()) {
            case 1 -> {
                if(coca.getDep().isEmpty())
                    while(coca.getDep().size()<totalp)
                        coca.addItem(new CocaCola());}
            case 2 -> {
                if(sprite.getDep().isEmpty())
                    while(sprite.getDep().size()<totalp)
                        sprite.addItem(new Fanta());}
            case 3 -> {
                if(fanta.getDep().isEmpty())
                    while(fanta.getDep().size()<totalp)
                        fanta.addItem(new Sprite());}
            case 4 -> {
                if(snickers.getDep().isEmpty())
                    while(snickers.getDep().size()<totalp)
                        snickers.addItem(new Super8());}
            case 5 -> {
                if(super8.getDep().isEmpty())
                    while(super8.getDep().size()<totalp)
                        super8.addItem(new Snickers());}
            default -> {
            }
        }
    }

    /**
     * Getter del tipo de producto.
     * @return tipo de producto.
     * */
    public Productos getTipoProducto(){
        if(depositoProducto!=null)
            return depositoProducto.getTipo();
        else
            return null;
    }

    /**
     * Getter del saldo que se dispone, puesto que se ingreso esa cantidad en la expendedora, para comprar.
     * @return saldo.
     * */
    public String getSaldo(){
        return String.valueOf(saldo);
    }

}