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

public class Line extends GeoShape{
    
    int xe;
    int ye;

    public Line() {
       
    }
    
    public Line(int xs, int ys,int xe, int ye,Color shapeColor) {
        super(xs,ys,shapeColor);
        this.xe = xe;
        this.ye = ye;
    }

    public int getXE() {
        return xe;
    }

    public void setXE(int xe) {
        this.xe = xe;
    }
    
    public int getYE() {
        return ye;
    }

    public void setYE(int ye) {
        this.ye = ye;
    }
}
