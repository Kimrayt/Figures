package Graphic;

import Figures.BlueCircle;
import Figures.Figure;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresGraphic extends JPanel {

    public ArrayList<Figure> figuresBlue;

    private Color graphicColor = Color.BLACK;
    private int width;
    private int height;

    public void paint (Graphics g){
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid (g);
        drawAxis (g);
        createBlueCircle (g);
        drawFigureWithSquares (g);
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
    private void drawFigureWithSquares (Graphics g){
        for (int i=0; i < figuresBlue.get(0).getPoints().size() -1; i++){
            g.drawLine((int)figuresBlue.get(0).getPoints().get(i).getX(), (int)figuresBlue.get(0).getPoints().get(i).getY(), (int)figuresBlue.get(0).getPoints().get(i+1).getX(), (int)figuresBlue.get(0).getPoints().get(i+1).getY());
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

    public void createBlueCircle (Graphics g){
        g.drawOval((int)figuresBlue.get(3).getPoints().get(0).getX(), (int)figuresBlue.get(3).getPoints().get(0).getY(), (int)figuresBlue.get(3).getRadius(), (int)figuresBlue.get(3).getRadius());
    }
}
