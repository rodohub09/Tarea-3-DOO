package Modelos;
import java.util.ArrayList;

/**
 * Clase generica de depositos que estan compuestos por {@link ArrayList}.
 * */
public class Deposito<T> {

    /**
     * Variable que instancia un {@link ArrayList} generico.
     * */
    protected ArrayList<T> dep = new ArrayList<>();

    /**
     * Setter que agrega un item, en este un tipo de producto, al deposito.
     * @param item a agregar al desposito. Su clase depende de para que tipo de producto almacena el deposito llamado
     * */
    public void addItem(T item){
        dep.add(item);
    }

    /**
     * Getter del producto que esta en el deposito, sacandolo de este.
     * @return El primer producto(Puntero) del deposito, si no hay productos devuelve null.
     * */
    public T getItem() {
        if (dep.isEmpty())
            return null;
        else
            return dep.removeFirst();
    }

    public ArrayList<T> getDep() {
        return dep;
    }

    public void makeEmpty(){
        dep.clear();
    }
}