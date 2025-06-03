package Modelos;
/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    /**
     * Atributo que cuantifica el vuelto que ha acumulado, el cual siempre comienza en 0.
     * */
    private int vuelto = 0;
    /**
     * Atributo que indicara el producto consumido.
     * */
    private String producto;

    /**
     * Constructor
     * @param exp El expendedor, del cual se le quiere comprar uno de sus {@link Productos}
     * @param m {@link Moneda} con la cual la instancia pagara al comprar en el {@link Expendedor}.
     * @param p Es lo que se quiere comprar dentro de los {@link Productos}.
     * @throws PagoIncorrectoException Lanza esta excepcion, al entregar un <b>valor nulo</b> como moneda.
     * @throws PagoInsuficienteException <p>Lanza esta excepción, al entregar una moneda con valor <b>menor</b> al precio
     * del producto seleccionado.</p>
     * @throws NoHayProductoException Lanza esta excepcion, al intentar comprar un producto el cual <b>ya no tiene stock.</b>
     * */
    public Comprador(Moneda m, Productos p, Expendedor exp) throws PagoIncorrectoException,PagoInsuficienteException,NoHayProductoException{
        Producto product = exp.comprarProducto(m, p);
        if (product != null)
            producto = product.consumir();
        else
            producto = null;


        Moneda mon;
        while ((mon=exp.getVuelto()) != null){
            vuelto += mon.getValor();
        }
    }

    /**
     * Getter del vuelto que acumulo la instancia.
     * @return Vuelto
     * */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * Getter del "sabor" del producto, asi identificando que {@link Producto} de el {@link Expendedor} se ha consumido.
     * @return {@link String} con el nombre del producto.
     * */
    public String queConsumiste(){
        return producto;

    }
}