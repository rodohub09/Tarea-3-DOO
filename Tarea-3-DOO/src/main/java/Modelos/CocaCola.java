package Modelos;
/**
 * Subclase de {@link Bebida}
 * correspondiente a la enumeracion de CocaCola {@link Productos}.
 */

public class CocaCola extends Bebida{

    /**
     * Constructor que llama al constructor de la super clase, tomando del enum
     * {@link Productos} la variable CocaCola.
     * */
    public CocaCola(){
        super(Productos.CocaCola);
    }

}