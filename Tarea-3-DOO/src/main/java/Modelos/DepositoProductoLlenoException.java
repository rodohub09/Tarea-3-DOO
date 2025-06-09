package Modelos;

/**
 * Excepcion que aparece al intentar comprar {@link Productos} en el {@link Expendedor }estando el deposito de entrega de estos, lleno.
 * */
public class DepositoProductoLlenoException extends Exception{
    public DepositoProductoLlenoException(){
        super();
    }
}
