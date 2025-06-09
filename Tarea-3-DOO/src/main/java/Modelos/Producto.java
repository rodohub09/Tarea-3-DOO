package Modelos;

import java.time.Instant;
import java.util.Random;

/**
 *Clase de los productos que estaran en el expendedor
 */

public abstract class Producto {
    /**
     * Tipo de producto {@link Productos}
     */
    protected Productos tipo;
    /** Serie del {@link Producto}.*/
    protected int serie;

    /**Constructor
    *@param tipo de producto.
    */
    public Producto(Productos tipo){
        this.tipo = tipo;
        this.serie = new Random().nextInt();
    }

    /**
    *Getter del del tipo de producto
    *@return nombre del tipo de producto instanciado.
    * */
    public String getNombre() {
        return tipo.name();
    }

    /**
     * Getter del tipo de {@link Producto}.
     * @return Tipo de producto.
     */
    public Productos getTipo(){
        return this.tipo;
    }

    /**
     * Getter de la serie del {@link Producto}.
     * @return Serie del producto.
     */
    public int getSerie() {
        return serie;
    }

    /**
    *Metodo abstracto que devolvera el "sabor" en forma de string del tipo de producto en cuestion.
    */
    public abstract String consumir();
}