package Vistas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Clase que es ocupada para insertar caracteres en el {@link PanelExpendedor}
 * */
public class Caracteres extends JLabel {
    /**
     * Variable que contiene la fuente de los caracteres.
     * */
    private Font f;

    public Caracteres(String s, Float fl){
        super(s);
        try {
            this.f = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource("NoSonLasFontsDelMinecraft.otf").openStream());
            f = f.deriveFont(fl);
        } catch (FontFormatException | IOException e) {
            System.out.println("No se encuentran las fuentes de texto (/Resources/NoSonLasFontsDelMinecraft.ttf");
            this.f = new Font("Arial", Font.PLAIN, 16);
        }finally{
            super.setFont(f);
        }
    }

    /**
     * Setter de los caracteres que contiene.
     * @param s Nuevo String
     * */
    public void setCaracteres(String s){
        super.setText(s);
    }

}
