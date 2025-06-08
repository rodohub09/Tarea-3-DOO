package Modelos;
/**
 * Clase cuyas instancias se ocupan como forma de pago para obtener los productos en la
 * expendedora.
 * Ocupa la interfaz {@link Moneda}
 * */
public abstract class Moneda implements Comparable<Moneda> {
    protected int serie;

    public Moneda(int serie){
        this.serie = serie;
    }

    /**
     * Getter de la serie de la moneda.
     * @return Serie de la moneda en String
     * */
    public int getSerie(){
        return this.serie;
    }

    /**
     * Metodo abstracto getter, que se adapta al valor de cada moneda.
     * */
    public abstract int getValor();

    /**
     * Metodo de la interfaz {@link Comparable} con overriding, que compara los valores
     * de 2 monedas.
     * @param {@link Moneda} que se quiera comparar.
     * @return Si el valor de la instancia de moneda con la cual se comunica el metodo
     * es mayor, menor o igual a la del parametro.
     * */
    @Override
    public int compareTo(Moneda moneda) {
        return Integer.compare(this.getValor(), moneda.getValor());
    }
}