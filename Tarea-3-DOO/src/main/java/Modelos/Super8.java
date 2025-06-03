package Modelos;
/**
 * Subclase de {@link Dulce}
 * correspondiente a la enumeracion de Super8 {@link Productos}.
 */

public class Super8 extends Dulce {

    /**
     * Constructor que llama al constructor de la super clase, tomando del enum
     * {@link Productos} la variable Super8
     * */
    public Super8(){
        super(Productos.Super8);
    }
}