package Modelos;
/**
 * Esta excepcion({@link Exception}) es ocupada, cuando el {@link Comprador} intenta comprar un {@link Producto} que no tiene stock en el {@link Expendedor}.
 * */

public class NoHayProductoException extends Exception {

    /**
     * Constructor de la excepcion, ocuupando el constructor de su superclase {@link Exception} .
     * */
    public NoHayProductoException(){
        super();
    }
}
