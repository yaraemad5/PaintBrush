/*Vector<FreeHand>f=new vector<freehand>();
  arr[i]->f.elementAt(i);
  f.size;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesPKG;

import java.awt.Color;

/**
 *
 * @author yara emad & maha mohamed
 */
public class FreeHand {
    
    int x,y;
    public final int size=20;
    //public final static Color color= Color.RED;
    protected Color fcolor;

    public FreeHand() {
        x=y=0;
    }

    public FreeHand(int x, int y,Color fcolor) {
        this.x = x;
        this.y = y;
        this.fcolor=fcolor;
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

    public Color getFcolor() {
        return fcolor;
    }

    public void setFcolor(Color fcolor) {
        this.fcolor = fcolor;
    }
    
    
}
