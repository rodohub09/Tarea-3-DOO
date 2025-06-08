package Vistas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Caracteres extends JLabel {
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

    public void setCaracteres(String s){
        super.setText(s);
    }

}
