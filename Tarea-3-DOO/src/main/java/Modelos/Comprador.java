package Modelos;

import java.util.ArrayList;

/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    private ArrayList<Moneda> billetera = new ArrayList<>();
    private ArrayList<Producto> inventario;

    public Comprador() {

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
}