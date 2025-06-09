package Modelos;

import java.util.ArrayList;

/**
 * Billetera en la que el {@link Comprador} guarda un conjunto de {@link Moneda} para comprar en un {@link Expendedor}.
 */
public class Billetera {

    /** Un conjunto de {@link Moneda}.*/
    private ArrayList<Moneda> monedas;
    /** Cantidad de {@link Moneda1000} que hay en {@link Billetera}.*/
    private int cantMonedas1000;
    /** Cantidad de {@link Moneda500} que hay en {@link Billetera}.*/
    private int cantMonedas500;
    /** Cantidad de {@link Moneda100} que hay en {@link Billetera}.*/
    private int cantMonedas100;

    /**
     * Constructor de {@link Billetera}.
     */
    public Billetera() {
        monedas = new ArrayList<>();
        this.cantMonedas100 = 0;
        this.cantMonedas500 = 0;
        this.cantMonedas1000 = 0;
    }


    /**
     * Agrega una única {@link Moneda} a la {@link Billetera}
     * y aumenta el contador del tipo de {@link Moneda} según su valor.
     * @param moneda Una {@link Moneda} de un cierto valor.
     */
    public void agregarMoneda(Moneda moneda) {
        monedas.add(moneda);
        switch (moneda.getValor()) {
            case 1000 -> cantMonedas1000++;
            case 500 -> cantMonedas500++;
            default -> cantMonedas100++;
        }
    }

    /**
     * Agrega el conjunto de {@link Moneda} que entrega el {@link Expendedor} como vuelto.
     * @param exp {@link Expendedor} del que se recoge el vuelto.
     */
    public void agregarMonedas(Expendedor exp) {
        monedas.addAll(exp.monVu.getDep());
    }

    /**
     * Elimina una {@link Moneda} de la {@link Billetera}.
     * @param moneda Una {@link Moneda} de cierto valor.
     */
    public void removerMoneda(Moneda moneda) {
        monedas.remove(moneda);
        switch (moneda.getValor()) {
            case 1000 -> cantMonedas1000--;
            case 500 -> cantMonedas500--;
            default -> cantMonedas100--;
        }
    }

    /**
     * Entrega la cantidad de {@link Moneda} de un valor específico.
     * @param i Tipo de {@link Moneda}.
     * @return Cantidad de {@link Moneda} del tipo indicado en el parámetro.
     */
    public int getCantMonedas(int i){
        return switch (i) {
            case 1000 -> cantMonedas1000;
            case 500 -> cantMonedas500;
            case 100 -> cantMonedas100;
            default -> 0;
        };
    }

    /**
     * Getter del conjunto de {@link Moneda} en la {@link Billetera}.
     * @return Todas las {@link Moneda} que hay en la {@link Billetera}.
     */
    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }
}