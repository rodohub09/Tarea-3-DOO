package Modelos;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> inv;

    public Inventario(int i) {
        inv = new ArrayList<>(i);
    }

    public void agregarProducto(Producto p) {
        inv.add(p);
    }

    public void consumirProducto(Producto producto) {
        inv.remove(producto);
    }

    public ArrayList<Producto> getInv() {
        return inv;
    }

    public Producto getProducto(int index) {
        try{
            return inv.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    public int getSize(){
        return inv.size();
    }
}
