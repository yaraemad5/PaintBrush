/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Applet.java to edit this template
 */
package paintpkg;


import ClassesPKG.*;
import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javafx.scene.control.CheckBox;



/**
 *
 * @author yara emad & maha mohamed
 */

public class MainProject extends Applet implements MouseListener, MouseMotionListener, ActionListener  {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    Button Red,Green,Blue,Orange,Yellow,Gray,Magenta,Black,Cyan,Pink;
    
    Button Rect,Ovel,Line;
    
    Button Free_Hand,Erasee,ClearAll;
    
    Button Undo;
    
    Checkbox filled, dotted;
    
    Font f = new Font("TimesRoman",Font.ITALIC,22);
    Color bColor;
    String Shape;
    Point start_Point;
    Point end_Point;
    Vector <Line> ArrLine;
    Vector <Oval> ArrOval;
    Vector <Rect> ArrRect;
    Vector <FreeHand> ArrFreeHand;
    Vector<Erase> ArrErase;
    Vector<String> ArrShapes;
    
    Line line;
    Oval oval;
    Rect rect;
    FreeHand freehand;
    
    
    int xs,ys,xe,ye;
    int olength,owidth;
    boolean fill,dott;
    
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        resize(2000,2000);
        ArrLine = new Vector<>();
        ArrOval = new Vector<>();
        ArrRect = new Vector<>();
        ArrFreeHand = new Vector<>();
        ArrErase = new Vector<>();
        Shape = new String();
        ArrShapes = new Vector<>();
        
        addMouseMotionListener(this);
        addMouseListener(this);
       
        //Color Buttons
        Yellow =new Button ("        ");
        Yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.YELLOW;
            }
        });
        Yellow.setBackground(Color.YELLOW);
        add(Yellow);
        
        Black =new Button ("        ");
        Black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.BLACK;
            }
        });
        Black.setBackground(Color.BLACK);
        add(Black);
        
        Red =new Button ("        ");
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.RED;
            }
        });
        Red.setBackground(Color.RED);
        add(Red);
        
        Cyan =new Button ("        ");
        Cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.CYAN;
            }
        });
        Cyan.setBackground(Color.CYAN);
        add(Cyan);
        
        Blue =new Button ("        ");
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.BLUE;
            }
        });
        Blue.setBackground(Color.BLUE);
        add(Blue);

        Pink =new Button ("        ");
        Pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.PINK;
            }
        });
        Pink.setBackground(Color.PINK);
        add(Pink);
        
        Green =new Button ("        ");
        Green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.GREEN;
            }
        });
        Green.setBackground(Color.GREEN);
        add(Green);
        
        
        Orange =new Button ("        ");
        Orange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.ORANGE;
            }
        });
        Orange.setBackground(Color.ORANGE);
        add(Orange);
        
        Gray =new Button ("        ");
        Gray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.GRAY;
            }
        });
        Gray.setBackground(Color.GRAY);
        add(Gray);
        
        Magenta =new Button ("        ");
        Magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bColor=Color.MAGENTA;
            }
        });
        Magenta.setBackground(Color.MAGENTA);
        add(Magenta);
        //////////////////////////////////////////////////////////////////////////
        //Shape Buttons
        Line=new Button ("Line");
        Line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape="Line";
            }
        });
        Line.setFont(f);
        add(Line);
        
        Rect =new Button ("Rectangle");
        Rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape="Rectangle";
            }
        });
        Rect.setFont(f);
        add(Rect);
        
        Ovel=new Button ("Ovel");
        Ovel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape="Ovel";
            }
        });
        Ovel.setFont(f);
        add(Ovel);
        ////////////////////////////////////////////////////////////////////////
        //CheckBox Fill & Dott
        filled = new Checkbox("Filled");    
        filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange()==1)
                   fill=true;
               else
                   fill=false;
            }
        });
        filled.setFont(f);
        add(filled);
        
        dotted = new Checkbox("Dotted");
        dotted.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if(e.getStateChange()==1)
                   dott=true;
               else
                   dott=false;
            }
        });
        dotted.setFont(f);
        add(dotted);
        //////////////////////////////////////////////////////////////////////
        //Tools free hand & Eraser
        Free_Hand =new Button ("Free Hand");
        Free_Hand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape="freehand";
            }
        });
        Free_Hand.setFont(f);
        add(Free_Hand);
        
        Erasee =new Button ("Erase");
        Erasee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shape="Erase";
            }
        });
        Erasee.setFont(f);
        add(Erasee);
        //////////////////////////////////////////////////////////////////////
        //options Undo
        Undo =new Button ("UnDo");
        Undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(ArrShapes.lastElement())
                {
                    case "Line":
                        ArrLine.removeElementAt(ArrLine.size()-1);
                        break;
                    case "Oval":
                        ArrOval.removeElementAt(ArrOval.size()-1);
                        break;
                    case "Rectangle":
                        ArrRect.removeElementAt(ArrRect.size()-1);
                        break;
                    case "freehand":
                        ArrFreeHand.removeElementAt(ArrFreeHand.size()-1);
                        break;
                    case "Erase":
                        ArrErase.removeElementAt(ArrErase.size()-1);
                        break;         
                }
                ArrShapes.removeElementAt(ArrShapes.size()-1);
                Shape=" ";
                repaint();
            }
        });
        Undo.setFont(f);
        add(Undo);
        
        ClearAll =new Button ("Clear All");
        ClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrLine = new Vector<>();
                ArrOval = new Vector<>();
                ArrRect = new Vector<>();
                ArrFreeHand = new Vector<>();
                ArrErase = new Vector<>();
                Shape = new String();
                ArrShapes = new Vector<>();
                repaint();
            }
        });
        ClearAll.setFont(f);
        add(ClearAll); 
        
    }
    
    // TODO overwrite start(), stop() and destroy() methods

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Shape.equals("Line"))
        {
            xs=e.getX();
            ys=e.getY();
            repaint();
        }
        if(Shape.equals("Ovel"))
        {
            xs=e.getX();
            ys=e.getY();
            repaint();
        }
        if(Shape.equals("Rectangle"))
        {
            xs=e.getX();
            ys=e.getY();
            repaint();
        }
        if(Shape.equals("freehand"))
        {
            ArrFreeHand.add(new FreeHand(e.getX(),e.getY(),bColor));
            repaint();
            ArrShapes.add(Shape);
        }
        if(Shape.equals("Erase"))
        {
            ArrErase.add(new Erase(e.getX(),e.getY()));
            repaint();
            ArrShapes.add(Shape);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(Shape.equals("Line"))
        {
            line = new Line(xs,ys,xe,ye,bColor);
            ArrLine.add(line);
            
            ArrLine.lastElement().setDotted(dott);
        }
        
        if(Shape.equals("Ovel"))
        {
            oval = new Oval(Math.min(xs, xe),Math.min(ys, ye),owidth,olength,bColor);
            ArrOval.add(oval);
            
            ArrOval.lastElement().setDotted(dott);
            ArrOval.lastElement().setFilled(fill);
        }
        
        if(Shape.equals("Rectangle"))
        {
            rect = new Rect(Math.min(xs, xe),Math.min(ys, ye),owidth,olength,bColor);
            ArrRect.add(rect);
            
            ArrRect.lastElement().setDotted(dott);
            ArrRect.lastElement().setFilled(fill);
        }
        ArrShapes.add(Shape);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(Shape.equals("Line"))
        {
            xe=e.getX();
            ye=e.getY();
            
        line = new Line(xs,ys,xe,ye,bColor);
        line.setDotted(dott);
        }
        
        if(Shape.equals("Ovel"))
        {
            
            xe=e.getX();
            ye=e.getY();
             
            owidth=Math.abs(xs-xe);
            olength=Math.abs(ys-ye);
            oval = new Oval(Math.min(xs, xe),Math.min(ys, ye),owidth,olength,bColor);
            
            oval.setDotted(dott);
            oval.setFilled(fill);
        }
            
        if(Shape.equals("Rectangle"))
        {
            xe=e.getX();
            ye=e.getY();
             
            owidth=Math.abs(xs-xe);
            olength=Math.abs(ys-ye);
            rect = new Rect(Math.min(xs, xe),Math.min(ys, ye),owidth,olength,bColor);
            
            rect.setDotted(dott);
            rect.setFilled(fill);
        }
        
        if(Shape.equals("freehand"))
        {
            ArrFreeHand.add(new FreeHand(e.getX(),e.getY(),bColor));
            ArrShapes.add(Shape);
        }
        
        if(Shape.equals("Erase"))
        {
            ArrErase.add(new Erase(e.getX(),e.getY()));
            ArrShapes.add(Shape);   
        }
        repaint();   
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    @Override
    public void paint(Graphics g)
    {
        int i;
        Graphics2D g2d=(Graphics2D) g;
        float[] dash={10f,4f};
                
        for(i=0;i<ArrShapes.size();i++)
        {
            switch(ArrShapes.elementAt(i))
            {
                case "Line":
                    
                    g2d.setColor(ArrLine.get(0).getshapecolor());
                    
                    if(ArrLine.get(0).isDotted())
                    {
                        BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                        g2d.setStroke(bs);
                        g2d.drawLine(ArrLine.get(0).getXS(),ArrLine.get(0).getYS(),ArrLine.get(0).getXE(),ArrLine.get(0).getYE());
                    }
                    else
                    {
                        g2d.setStroke(new BasicStroke(0));
                        g2d.drawLine(ArrLine.get(0).getXS(),ArrLine.get(0).getYS(),ArrLine.get(0).getXE(),ArrLine.get(0).getYE());
                    }
                    ArrLine.add(ArrLine.get(0));
                    ArrLine.remove(0);
                    break;
                    
                case "Ovel":
                    
                    g2d.setColor(ArrOval.get(0).getshapecolor());
                    
                    if(ArrOval.get(0).isFilled())
                        g2d.fillOval(ArrOval.get(0).getXS(),ArrOval.get(0).getYS(),ArrOval.get(0).getWidth(),ArrOval.get(0).getLength());
                    if(ArrOval.get(0).isDotted())
                    {
                        BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                        g2d.setStroke(bs);
                        g2d.drawOval(ArrOval.get(0).getXS(),ArrOval.get(0).getYS(),ArrOval.get(0).getWidth(),ArrOval.get(0).getLength());
                    }
                    else 
                    {
                        g2d.setStroke(new BasicStroke(0));
                        g2d.drawOval(ArrOval.get(0).getXS(),ArrOval.get(0).getYS(),ArrOval.get(0).getWidth(),ArrOval.get(0).getLength());   
                    }
                    ArrOval.add(ArrOval.get(0));
                    ArrOval.remove(0);
                    break;
                    
                case "Rectangle":
                    
                    g2d.setColor(ArrRect.get(0).getshapecolor());
                    
                    if(ArrRect.get(0).isFilled())
                        g2d.fillRect(ArrRect.get(0).getXS(),ArrRect.get(0).getYS(),ArrRect.get(0).getWidth(),ArrRect.get(0).getLength());
                    
                    if(ArrRect.get(0).isDotted())
                    {
                        BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                        g2d.setStroke(bs);
                        g2d.drawRect(ArrRect.get(0).getXS(),ArrRect.get(0).getYS(),ArrRect.get(0).getWidth(),ArrRect.get(0).getLength());
                    }
                    
                    else
                    {
                        g2d.setStroke(new BasicStroke(0));
                        g2d.drawRect(ArrRect.get(0).getXS(),ArrRect.get(0).getYS(),ArrRect.get(0).getWidth(),ArrRect.get(0).getLength());  
                    }
                    
                    ArrRect.add(ArrRect.get(0));
                    ArrRect.remove(0);
                    break;
                    
                case "freehand":
                        g2d.setColor(ArrFreeHand.get(0).getFcolor());
                        g2d.fillOval(ArrFreeHand.elementAt(0).getX(), ArrFreeHand.elementAt(0).getY(), ArrFreeHand.elementAt(0).size,ArrFreeHand.elementAt(0).size);
                    ArrFreeHand.add(ArrFreeHand.get(0));
                    ArrFreeHand.remove(0);
                    break;
                    
                case "Erase":
                        g2d.setColor(Erase.color);
                        g2d.fillOval(ArrErase.elementAt(0).getX(), ArrErase.elementAt(0).getY(), ArrErase.elementAt(0).size,ArrErase.elementAt(0).size); 
                    ArrErase.add(ArrErase.get(0));
                    ArrErase.remove(0);
                    break;
            }
        }
        
       switch(Shape)
       {
            case "Line":
               
                g2d.setColor(line.getshapecolor());
                
                line.setDotted(dotted.getState());
                
                if(dotted.getState())
                {
                    BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                    g2d.setStroke(bs);
                    g2d.drawLine(line.getXS(),line.getYS(),line.getXE(),line.getYE());
                }
                else{ 
                g2d.setStroke(new BasicStroke(0));
                g2d.drawLine(line.getXS(),line.getYS(),line.getXE(),line.getYE());
                }
                break; 
                
            case "Ovel":
                
                g2d.setColor(oval.getshapecolor());
              
                if(fill)
                {
                    g2d.fillOval(oval.getXS(),oval.getYS(),oval.getWidth(),oval.getLength()); 
                }
                
                if(dott)
                {
                    BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                    g2d.setStroke(bs);
                    g2d.drawOval(oval.getXS(),oval.getYS(),oval.getWidth(),oval.getLength());
                }
                
                else 
                {
                    g2d.setStroke(new BasicStroke(0));
                  g2d.drawOval(oval.getXS(),oval.getYS(),oval.getWidth(),oval.getLength());
                }
                break;
                
            case "Rectangle":
                
                g2d.setColor(rect.getshapecolor());
                
                if(fill)
                {
                    g2d.fillRect(rect.getXS(),rect.getYS(),rect.getWidth(),rect.getLength());
                }
                
                if(dott)
                {
                    BasicStroke bs= new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash, 0.0f);
                    g2d.setStroke(bs);
                    g2d.drawRect(rect.getXS(),rect.getYS(),rect.getWidth(),rect.getLength());
                }
                
                else 
                {
                    g2d.setStroke(new BasicStroke(0));
                    g2d.drawRect(rect.getXS(),rect.getYS(),rect.getWidth(),rect.getLength());
                }
                break;      
       }             
    }
}
