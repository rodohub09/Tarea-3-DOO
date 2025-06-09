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
    CocaCola(1, 700,"CocacolaInteractiva.png","gluglu.wav","Cocacoladep.png"),
    Sprite(2, 700,"SpriteInteractiva.png","gluglu.wav","Spritedep.png"),
    Fanta(3, 700,"FantaInteractiva.png","gluglu.wav","Fantadep.png"),
    Snickers(4, 1000,"SnickersInteractivo.png","namnam.wav","Snickersdep.png"),
    Super8(5, 400,"Super8Interactivo.png","namnam.wav","Super8dep.png");

    /**
     * Variables que indican el precio y la opcion (numero en la maquina expendedora).
     * */
    private final int opcion;
    private final int precio;
    private final String fotoInv;
    private final String sonido;
    private final String fotodep;


    Productos (int opcion, int precio, String fotoInv, String sonido, String fotodep) {
        this.opcion = opcion;
        this.precio = precio;
        this.fotoInv = fotoInv;
        this.sonido = sonido;
        this.fotodep = fotodep;
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

    /**
     * Getter de el nombre del render del respectivo {@link Productos}
     * @return nombre de archivo.
     * */
    public String getFotoInv(){
        return this.fotoInv;
    }

    /**
     * Getter de el nombre del sonido que se ejecuta al consumir un respectivo {@link Productos}
     * @return nombre de archivo.
     * */
    public String getSonido(){
        return this.sonido;
    }

    /**
     * Getter de el nombre del render del respectivo {@link Deposito}
     * @return nombre de archivo.
     * */
    public String getFotodep() {
        return fotodep;
    }
}