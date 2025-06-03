package Modelos;
/**
 * Subclase de {@link Dulce}
 * correspondiente a la enumeracion de Snickers {@link Productos}.
 */

public class Snickers extends Dulce {

    /**
     * Constructor que llama al constructor de la super clase, tomando del enum
     * {@link Productos} la variable Snickers.
     * */
    public Snickers(){
        super(Productos.Snickers);
    }
}