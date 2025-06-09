package Modelos;

import static Modelos.MonedaGen.getMonedaGen;

/**
 * Clase que representara a quien interactua con el {@link Expendedor}, intentando comprar un {@link Producto}.
 * */

public class Comprador {

    /**
     * Variable comprador puesto que esta es un singleton.
     * */
    private static Comprador comprador;
    /**
     * Variable {@link Billetera} encargada de almacenar toda {@link Moneda} de su propiedad.
     * */
    public Billetera billetera = new Billetera();
    /**
     * Variable {@link Inventario} encargada de almacenar {@link Productos}.
     * */
    public Inventario inventario = new Inventario(5);

    private Comprador() {
        billetera.agregarMoneda(getMonedaGen().genMoneda1000());
        billetera.agregarMoneda(getMonedaGen().genMoneda1000());
        billetera.agregarMoneda(getMonedaGen().genMoneda1000());
        billetera.agregarMoneda(getMonedaGen().genMoneda500());
        billetera.agregarMoneda(getMonedaGen().genMoneda500());
        billetera.agregarMoneda(getMonedaGen().genMoneda500());
        billetera.agregarMoneda(getMonedaGen().genMoneda100());
        billetera.agregarMoneda(getMonedaGen().genMoneda100());
        billetera.agregarMoneda(getMonedaGen().genMoneda100());
    }

    /**
     * Metodo que se encarga de crear un comprador unico y posteriormente retornarlo.
     * @return comprador en accion.
     * */
    public static Comprador getComprador(){
        if (comprador == null)
            comprador = new Comprador();
        return comprador;
    }

    /**
     * Metodo que toma el vuelto del {@link Expendedor}.
     * @param exp {@link Expendedor} al que se le toma el vuelto.
     * */
    public void tomarVuelto(Expendedor exp) {
        if (!exp.monVu.dep.isEmpty()) {
            billetera.agregarMonedas(exp);
            exp.monVu.makeEmpty();
        }else{
            throw new NoHayVueltoException();
        }
    }

    /**
     * Metodo que toma el {@link Producto} comprado de un {@link Expendedor}.
     * @param exp {@link Expendedor} al que se le toma el {@link Producto}.
     * */
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

    /**
     * Getter de la propiedad billetera.
     * @return billetera del {@link Comprador}.
     * */
    public Billetera getBilletera() {
        return billetera;
    }
}