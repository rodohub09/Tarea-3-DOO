package Modelos;
import Vistas.Ventana;

import static Modelos.MonedaGen.getMonedaGen;

public class App {
    public static void main(String[] args) {
        Ventana app = Ventana.getInstance();
        System.out.println(getMonedaGen().genMoneda1000());
        System.out.println(getMonedaGen().genMoneda1000());
        System.out.println(getMonedaGen().genMoneda1000());
    }
}
