package Modelos;
/**
* Enum que contiene todos los tipos de productos, los cuales tienen sus respectivos
* precios y se referencian con un numero
* */

public enum Productos {

    /**
     * Propiedades que indican el producto en cuestion, con su numero en la maquina
     * expendedora y su precio.
     * */
    CocaCola(1, 700),
    Sprite(2, 700),
    Fanta(3, 700),
    Snickers(4, 1000),
    Super8(5, 400);

    /**
     * Variables que indican el precio y la opcion (numero en la maquina expendedora).
     * */
    private final int opcion;
    private final int precio;


    Productos (int opcion, int precio) {
        this.opcion = opcion;
        this.precio = precio;
    }

    /**
     * Getter de la variable opcion.
     * @return numero de seleccion del tipo de producto en la expendedora.
     * */
    public int getOpcion() {
        return opcion;
    }

    /**
     * Getter de la variable precio.
     * @return Precio del tipo de producto en la maquina expendedora.
     * */
    public int getPrecio() {
        return precio;
    }
}