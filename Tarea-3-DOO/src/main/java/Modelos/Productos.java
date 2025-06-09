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
    CocaCola(1, 700,"CocacolaInteractiva.png","gluglu.wav"),
    Sprite(2, 700,"SpriteInteractiva.png","gluglu.wav"),
    Fanta(3, 700,"FantaInteractiva.png","gluglu.wav"),
    Snickers(4, 1000,"SnickersInteractivo.png","amam.wav"),
    Super8(5, 400,"Super8Interactivo.png","amam.wav");

    /**
     * Variables que indican el precio y la opcion (numero en la maquina expendedora).
     * */
    private final int opcion;
    private final int precio;
    private final String fotoInv;
    private final String sonido;


    Productos (int opcion, int precio, String fotoInv, String sonido) {
        this.opcion = opcion;
        this.precio = precio;
        this.fotoInv = fotoInv;
        this.sonido = sonido;
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

    public String getFotoInv(){
        return this.fotoInv;
    }
}