package Modelos;

import java.util.ArrayList;

/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    private static Comprador comprador;
    private ArrayList<Moneda> billetera = new ArrayList<>();
    private ArrayList<Producto> inventario;

    private Comprador() {

    }

    public static Comprador getComprador(){
        if (comprador == null)
            comprador = new Comprador();
        return comprador;
    }

    public void tomarVuelto(Expendedor exp) {
        if (!exp.monVu.dep.isEmpty())
            billetera.addAll(exp.monVu.getDep());
    }

    public void tomarProducto(Expendedor exp) {
        Producto producto =  exp.depositoProducto;
        exp.depositoProducto = null;
        inventario.add(producto);
    }

    public void ingresarMoneda(Expendedor exp, int valor) throws PagoIncorrectoException {
        for (Moneda m : billetera) {
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
}