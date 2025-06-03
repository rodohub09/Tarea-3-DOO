package Modelos;
/**
 *Clase de los productos que estaran en el expendedor
 */

public abstract class Producto {
    /**
     * Tipo de producto {@link Productos}
     */

    private Productos tipo;

    /**Constructor
    *@param tipo de producto.
    */
    public Producto(Productos tipo){
        this.tipo = tipo;
    }

    /**
    *Getter del del tipo de producto
    *@return nombre del tipo de producto instanciado.
    * */
    public String getNombre() {
        return tipo.name();
    }

    /**
    *Metodo abstracto que devolvera el "sabor" en forma de string del tipo de producto en cuestion.
    */
    public abstract String consumir();
}
