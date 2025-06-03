package Modelos;
/**
 * Subclase de {@link Moneda} con valor 500.
 */

public class Moneda500 extends Moneda {

    /**
     * Constructor que llama a la super clases.
     * */
    public Moneda500(int serie){
        super(serie);
    }

    /**
     * Getter del valor
     * @return Valor de la moneda en este caso 500.
     * */
    public int getValor() {
        return 500;
    }
}
