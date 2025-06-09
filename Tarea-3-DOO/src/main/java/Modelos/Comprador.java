package Modelos;

/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    private static Comprador comprador;
    public Billetera billetera = new Billetera();
    public Inventario inventario = new Inventario(5);

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
        else if(inventario.getSize()==5){
            throw new InventarioLlenoException();
        }
        else{
            Producto p = exp.depositoProducto;
            exp.depositoProducto = null;
            inventario.agregarProducto(p);
        }
    }

    public Billetera getBilletera() {
        return billetera;
    }
}