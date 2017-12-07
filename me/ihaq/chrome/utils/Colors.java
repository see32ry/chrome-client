package me.ihaq.chrome.utils;

import java.awt.Color;

public class Colors {

    public static final int R = 255;
    public static final int G = 0;
    public static final int B = 0;
    
    public static int getColor() {
        return new Color(R, G, B).getRGB();
    }

}
