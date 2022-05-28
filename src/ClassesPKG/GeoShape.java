/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesPKG;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author yara emad & maha mohamed
 */
public class GeoShape {
    
    int xs,ys;
    boolean dotted;
    protected Color shapeColor;

    public GeoShape() {
        xs=ys=0;
    }

    public GeoShape(int xs, int ys,Color shapeColor) {
        this.xs = xs;
        this.ys = ys;
        this.shapeColor=shapeColor;
    }

    public Color getshapecolor()
    {
        return shapeColor;
    }
    public void setshapecolor(Color shapeColor)
    {
        this.shapeColor = shapeColor;
    }
    
    public boolean isDotted() {
        return dotted;
    }

    public void setDotted(boolean dotted) {
        this.dotted = dotted;
    }

    public int getXS() {
        return xs;
    }

    public void setXS(int xs) {
        this.xs = xs;
    }

    public int getYS() {
        return ys;
    }

    public void setYS(int ys) {
        this.ys = ys;
    }  
}
