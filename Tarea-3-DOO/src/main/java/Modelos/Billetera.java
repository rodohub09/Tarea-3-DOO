package Modelos;

import java.util.ArrayList;

public class Billetera {
    private ArrayList<Moneda> monedas;

    public Billetera() {
        monedas = new ArrayList<>();
    }

    public void agregarMoneda(Moneda moneda) {
        monedas.add(moneda);
    }

    public void agregarMonedas(Expendedor exp) {
        monedas.addAll(exp.monVu.getDep());
    }

    public void removerMoneda(Moneda moneda) {
        monedas.remove(moneda);
    }

    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }

    public Moneda getMoneda(int index) {
        return monedas.get(index);
    }

    public int getSize() {
        return monedas.size();
    }
}