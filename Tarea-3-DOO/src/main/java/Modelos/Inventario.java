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

    public void consumirProducto(int i) {
        inv.remove(i);
    }

    public ArrayList<Producto> getInv() {
        return inv;
    }

    public Producto getProducto(int index) {
        return inv.get(index);
    }

    public int getSize(){
        return inv.size();
    }
}
