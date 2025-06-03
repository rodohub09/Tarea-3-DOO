package Modelos;
/**
 * Subclase de {@link Bebida}
 * correspondiente a la enumeracion de Fanta {@link Productos}.
 */

public class Fanta extends Bebida {

    /**
     * Constructor que llama al constructor de la super clase, tomando del enum
     * {@link Productos} la variable Fanta.
     * */
    public Fanta() {
        super(Productos.Fanta);
    }
}
