package Modelos;
/**
 * Esta excepcion({@link Exception}) es ocupada, cuando el {@link Comprador} intenta comprar un {@link Producto} sin una {@link Moneda} valida.(null)
 * */

public class PagoIncorrectoException extends Exception{

    /**
     * Constructor de la excepcion, ocuupando el constructor de su superclase {@link Exception} .
     * */
    public PagoIncorrectoException(){
        super();
    }
}
