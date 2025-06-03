package Modelos;
/**
 * Maquina expendedora de diversos productos(6), apilados en sus respectivos depositos.
 */

public class Expendedor {

    /**
     * Variables privadas de cada {@link Deposito}, con el nombre del producto que almacena.
     * */
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Bebida> fanta;
    private Deposito<Dulce> snickers;
    private Deposito<Dulce> super8;
    private Deposito<Moneda> monVu;
    private Producto depositoProducto;

    /**
     * Constructor
     * @param stock cantidad de {@link Producto} que pueden almacenar los depositos del expendedor.
     * */
    public Expendedor(int stock){
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();
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
     *<p> Refiere a la accion de comprar un producto de la maquina expendedora, pidiendo seleccionar el producto y pagarlo
     * para posteriormente expulsar dicho producto.</p>
     * @param moneda {@link Moneda} de pago.
     *<p>@param p A traves del enum {@link Productos}, se ocupa el numero de opcion, para que la expendedora identifique
     *          el producto a comprar.</p>
     * @throws PagoIncorrectoException Lanza esta excepcion, al entregar un <b>valor nulo</b> como moneda.
     * @throws PagoInsuficienteException Lanza esta excepción, al entregar una moneda con valor <b>menor</b> al precio del producto seleccionado.
     * @throws NoHayProductoException Lanza esta excepcion, al intentar comprar un producto el cual <b>ya no tiene stock.</b>
     * @return El producto que se selecciono.
     * */
    public void comprarProducto(Moneda moneda, Productos p) throws PagoIncorrectoException,PagoInsuficienteException,NoHayProductoException {
        if (moneda == null)
            throw new PagoIncorrectoException();

        if (moneda.getValor() < p.getPrecio()) {
            monVu.addItem(moneda);
            throw new PagoInsuficienteException();
        }

        Producto product = null;
        switch (p.getOpcion()) {
            case 1:
                product = coca.getItem();
                break;
            case 2:
                product = sprite.getItem();
                break;
            case 3:
                product = fanta.getItem();
                break;
            case 4:
                product = snickers.getItem();
                break;
            case 5:
                product = super8.getItem();
                break;
            default:
                break;
        }


        int vuelto = moneda.getValor() - p.getPrecio();
        if (product == null) {
            monVu.addItem(moneda);
            throw new NoHayProductoException();
        }

        while (vuelto > 0) {
            if (vuelto >= 1000) {
                monVu.addItem(new Moneda1000(moneda.serie));
                vuelto -= 1000;
            } else if (vuelto >= 500) {
                monVu.addItem(new Moneda500(moneda.serie));
                vuelto -= 500;
            } else if (vuelto >= 100) {
                monVu.addItem(new Moneda100(moneda.serie));
                vuelto -= 100;
            } else {
                break;
            }
        }
            depositoProducto = product;
    }

    /**
     * Getter del vuelto, osea una moneda con el valor del exceso de pago al comprar un producto.
     * @return una moneda de vuelto.
     * */
    public Moneda getVuelto(){
        return monVu.getItem();
    }

    public Producto getProducto() {
        Producto producto =  depositoProducto;
        depositoProducto = null;
        return producto;
    }
}