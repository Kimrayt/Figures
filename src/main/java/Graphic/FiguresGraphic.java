package Graphic;

import Figures.BlueCircle;
import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresGraphic extends JPanel {

    private Color graphicColor = Color.BLACK;
    private int width;
    private int height;

    public void paint (Graphics g){
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid (g);
        drawAxis (g);
    }
    private void drawGrid(Graphics g) {
        g.setColor(Color.lightGray);

        for(int x=width/2; x<width; x+=30){
            g.drawLine(x, 0, x, height);
        }

        for(int x=width/2; x>0; x-=30){
            g.drawLine(x, 0, x, height);
        }

        for(int y=height/2; y<height; y+=30){
            g.drawLine(0, y, width, y);
        }

        for(int y=height/2; y>0; y-=30){
            g.drawLine(0, y, width, y);
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width/2, 0, width/2, height);
        g.drawLine(0, height/2, width, height/2);
    }
    private void drawFigureWithSquares (ArrayList<Point> points, Graphics g, Figure p){
        for (int i=0; i < points.size() -1; i++){
            g.drawLine((int)points.get(i).getX(), (int)points.get(i).getY(), (int)points.get(i+1).getX(), (int)points.get(i+1).getY());
            g.fillRect((int)points.get(i).getX(), (int)points.get(i).getY(), (int)points.get(i+1).getX(), (int)points.get(i+1).getY());
        }
    }
    private void setColor (Graphics g,String color){
        if (color == "blue"){
            g.setColor(Color.BLUE);
        }
        else if (color == "yellow"){
            g.setColor(Color.yellow);
        }
    }
    private void drawCircle (BlueCircle bc, Graphics g){
        g.drawOval(bc.getX(), bc.getY(), (int)bc.getRadius(), (int)bc.getRadius());
    }
}
