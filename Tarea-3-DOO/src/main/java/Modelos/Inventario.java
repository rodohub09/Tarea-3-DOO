package Modelos;

import java.util.ArrayList;

/**
 * Lugar en el que el {@link Comprador} guarda los {@link Producto} que compra.
 */
public class Inventario {
    /** El {@link Inventario} completo.*/
    private ArrayList<Producto> inv;

    /**
     * Constructor de {@link Inventario}.
     * @param stock Cantidad de {@link Producto} que puede almacenar.
     */
    public Inventario(int stock) {
        inv = new ArrayList<>(stock);
    }

    /**
     * Agrega un {@link Producto} al {@link Inventario}.
     * @param p {@link Producto} comprado previamente.
     */
    public void agregarProducto(Producto p) {
        inv.add(p);
    }

    /**
     * Consume el {@link Producto} (come o bebe) y lo elimina del {@link Inventario}.
     * @param producto {@link Producto} comprado previamente.
     */
    public void consumirProducto(Producto producto) {
        inv.remove(producto);
    }

    /** Getter del {@link Inventario}.*/
    public ArrayList<Producto> getInv() {
        return inv;
    }

    /**
     * Entrega el {@link Producto} de un lugar específico del {@link Inventario}.
     * @param index Posición del {@link Producto} dentro del {@link Inventario}.
     * @return El {@link Producto} en dicha posición.
     */
    public Producto getProducto(int index) {
        try{
            return inv.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    /** Getter del tamaño del {@link Inventario}.*/
    public int getSize(){
        return inv.size();
    }
}