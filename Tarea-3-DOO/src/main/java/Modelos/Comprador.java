package Modelos;

import java.util.ArrayList;

/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    private static Comprador comprador;
    public Billetera billetera = new Billetera();
    public ArrayList<Producto> inventario = new ArrayList<>();

    private Comprador() {

    }

    public static Comprador getComprador(){
        if (comprador == null)
            comprador = new Comprador();
        return comprador;
    }

    public void tomarVuelto(Expendedor exp) {
        if (!exp.monVu.dep.isEmpty()) {
            billetera.agregarMonedas(exp);
            exp.monVu.makeEmpty();
        }else{
            throw new NoHayVueltoException();
        }
    }

    public void tomarProducto(Expendedor exp) throws NoHayNadaEnElDepProdException {
        if(exp.depositoProducto == null)
            throw new NoHayNadaEnElDepProdException();
        else{
            Producto p = exp.depositoProducto;
            exp.depositoProducto = null;
            inventario.add(p);
        }
    }

    public void ingresarMoneda(Expendedor exp, int valor) throws PagoIncorrectoException {
        for (Moneda m : billetera.getMonedas()) {
            if (m.getValor() == valor) {
                exp.ingresarMoneda(m);
                return;
            }
        }
    }

    public void ingresarMoneda1000(Expendedor exp) throws PagoIncorrectoException {
        ingresarMoneda(exp, 1000);
    }

    public void ingresarMoneda500(Expendedor exp) throws PagoIncorrectoException {
        ingresarMoneda(exp, 500);
    }

    public void ingresarMoneda100(Expendedor exp) throws PagoIncorrectoException {
        ingresarMoneda(exp, 100);
    }

    public Billetera getBilletera() {
        return billetera;
    }
}