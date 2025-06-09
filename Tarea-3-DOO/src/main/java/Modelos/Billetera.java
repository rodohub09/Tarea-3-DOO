package Modelos;

import java.util.ArrayList;

public class Billetera {
    private ArrayList<Moneda> monedas;
    private int cantMonedas1000;
    private int cantMonedas500;
    private int cantMonedas100;

    public Billetera() {
        monedas = new ArrayList<>();
        this.cantMonedas100 = 0;
        this.cantMonedas500 = 0;
        this.cantMonedas1000 = 0;
    }

    public void agregarMoneda(Moneda moneda) {
        monedas.add(moneda);
        if(moneda.getValor()==1000){
            cantMonedas1000++;
        } else if (moneda.getValor()==500) {
            cantMonedas500++;
        }else{
            cantMonedas100++;
        }
    }

    public void agregarMonedas(Expendedor exp) {
        monedas.addAll(exp.monVu.getDep());
    }

    public void removerMoneda(Moneda moneda) {
        monedas.remove(moneda);
        if(moneda.getValor()==1000){
            cantMonedas1000--;
        } else if (moneda.getValor()==500) {
            cantMonedas500--;
        }else{
            cantMonedas100--;
        }
    }

    public int getCantMonedas(int i){
        switch(i){
            case 1000: return cantMonedas1000;
            case 500: return cantMonedas500;
            case 100: return cantMonedas100;
        }
        return 0;
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