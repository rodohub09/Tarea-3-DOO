package Modelos;

import java.time.Instant;

/**
 *Clase de los productos que estaran en el expendedor
 */

public abstract class Producto {
    /**
     * Tipo de producto {@link Productos}
     */

    protected Productos tipo;
    protected String serie;

    /**Constructor
    *@param tipo de producto.
    */
    public Producto(Productos tipo){
        this.tipo = tipo;
        this.serie = Instant.now().toString();
    }

    /**
    *Getter del del tipo de producto
    *@return nombre del tipo de producto instanciado.
    * */
    public String getNombre() {
        return tipo.name();
    }

    public Productos getTipo(){
        return this.tipo;
    }

    public String getSerie() {
        return serie;
    }

    /**
    *Metodo abstracto que devolvera el "sabor" en forma de string del tipo de producto en cuestion.
    */
    public abstract String consumir();
}