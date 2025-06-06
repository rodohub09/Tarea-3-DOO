package Modelos;

public class MonedaGen {
    private static MonedaGen monedaGen;
    private int serie;

    private MonedaGen(int serie) {
        this.serie = serie;
    }

    public static MonedaGen getMonedaGen() {
        if (monedaGen == null)
            monedaGen = new MonedaGen(0);
        return monedaGen;
    }

    public Moneda100 genMoneda100() {
        serie++;
        return new Moneda100(serie);
    }
    public Moneda500 genMoneda500() {
        serie++;
        return new Moneda500(serie);
    }
    public Moneda1000 genMoneda1000() {
        serie++;
        return new Moneda1000(serie);
    }
}