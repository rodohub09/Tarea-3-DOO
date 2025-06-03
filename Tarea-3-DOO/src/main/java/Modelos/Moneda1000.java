package Modelos;
/**
 * Subclase de {@link Moneda} con valor 1000.
 */

public class Moneda1000 extends Moneda {

    /**
     * Constructor que llama a la super clases.
     * */
    public Moneda1000(int serie){
        super(serie);
    }

    /**
     * Getter del valor
     * @return Valor de la moneda en este caso 100.
     * */
    public int getValor() {
        return 1000;
    }
}