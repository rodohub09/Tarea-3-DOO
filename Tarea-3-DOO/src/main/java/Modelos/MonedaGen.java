package Modelos;

/**
 * Singleton que funciona como un generador de monedas con un manejo automático del número de serie.
 */
public class MonedaGen {
    /** */
    private static MonedaGen monedaGen;
    /** Serie de la {@link Moneda}.*/
    private int serie;

    /**
     * Constructor del singleton.
     * @param serie Número de serie de la moneda.
     */
    private MonedaGen(int serie) {
        this.serie = serie;
    }

    /**
     * Getter del Singleton que devuelve la instancia del mismo.
     * @return Instancia del singleton.
     */
    public static MonedaGen getMonedaGen() {
        if (monedaGen == null)
            monedaGen = new MonedaGen(0);
        return monedaGen;
    }

    /**
     * Generador de una {@link Moneda100}.
     * @return Una {@link Moneda100} con serie generada automáticamente.
     */
    public Moneda100 genMoneda100() {
        serie++;
        return new Moneda100(serie);
    }

    /**
     * Generador de una {@link Moneda500}.
     * @return Una {@link Moneda500} con serie generada automáticamente.
     */
    public Moneda500 genMoneda500() {
        serie++;
        return new Moneda500(serie);
    }

    /**
     * Generador de una {@link Moneda1000}.
     * @return Una {@link Moneda1000} con serie generada automáticamente.
     */
    public Moneda1000 genMoneda1000() {
        serie++;
        return new Moneda1000(serie);
    }
}