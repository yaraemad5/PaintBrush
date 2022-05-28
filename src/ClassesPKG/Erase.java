/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesPKG;

import java.awt.Color;

/**
 *
 * @author yara emad & maha mohamed
 */
public class Erase {
    
    int x,y;
    public final int size=20;
    public final static Color color= Color.WHITE;

    public Erase() {
    }

    public Erase(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }  
    
}
