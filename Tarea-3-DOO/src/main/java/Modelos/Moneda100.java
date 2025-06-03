package Modelos;
/**
 * Subclase de {@link Moneda} con valor 100.
 */


public class Moneda100 extends Moneda{

    /**
     * Constructor que llama a la super clases.
     * */
    public Moneda100(int serie){
        super(serie);
    }

    /**
     * Getter del valor
     * @return Valor de la moneda en este caso 100.
     * */
    public int getValor() {
        return 100;
    }
}
