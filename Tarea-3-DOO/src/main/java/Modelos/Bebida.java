package Modelos;
/**
* Subclase de {@link Producto}.
*/

public abstract class Bebida extends Producto{

    /**
    * Constructor que llama al constructor de la super clase.
    * @param p tipo de bebida (Sprite, Fanta o CocaCola).
    * */
    public Bebida (Productos p) {
        super(p);
    }

    /**
    * Getter del "sabor" del producto.
    * @return tipo de producto en String.
    */
    @Override
    public String consumir() {
        return getNombre();
    }
}
