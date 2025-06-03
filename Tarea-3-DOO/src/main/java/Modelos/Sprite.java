package Modelos;
/**
 * Subclase de {@link Bebida}
 * correspondiente a la enumeracion de Sprite {@link Productos}.
 */

public class Sprite extends Bebida{

    /**
     * Constructor que llama al constructor de la super clase, tomando del enum
     * {@link Productos} la variable Sprite
     * */
    public Sprite(){
        super(Productos.Sprite);
    }
}
