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
public class Oval extends GeoShape{
    int length;
    int width;
    boolean filled;

    public Oval() {
        length=width=0;
        filled=false;
    }

    public Oval(int xs,int ys,int width, int length,Color shapeColor) {
        super(xs,ys,shapeColor);
        this.length = length;
        this.width = width;
        filled=false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    
}
