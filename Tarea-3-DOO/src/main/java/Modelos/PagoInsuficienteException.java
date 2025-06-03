package Modelos;
/**
 * Esta excepcion({@link Exception}) es ocupada, cuando el {@link Comprador} intenta comprar un {@link Producto} con un pago menor al precio de dicho producto.
 * */

public class PagoInsuficienteException extends Exception {

    /**
     * Constructor de la excepcion, ocuupando el constructor de su superclase {@link Exception} .
     * */
    public PagoInsuficienteException() {
        super();
    }
}
