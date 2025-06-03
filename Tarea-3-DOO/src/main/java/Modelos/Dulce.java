package Modelos;
/**
* Subclase de {@link Producto}
*/
public abstract class Dulce extends Producto {

    /**
     * Constructor que llama al constructor de la super clase
     * @param p tipo de bebida (Snickers o Super8)
     * */
    public Dulce (Productos p) {
        super(p);
    }

    /**
     * Getter del <i>"sabor"</i> del producto.
     * @return tipo de producto en String.
     */
    @Override
    public String consumir() {
        return getNombre();
    }
}
