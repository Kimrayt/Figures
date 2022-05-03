package Graphic;

import Figures.BlueCircle;
import Figures.Figure;
import com.company.FiguresArray;
import com.company.Main;
import com.company.PointsArray;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresGraphic extends JPanel {

    //public ArrayList<Figure> figuresBlue;

    private static Color figureColor = Color.BLACK;
    private int width;
    private int height;

    public void paint (Graphics g){
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid (g);
        drawAxis (g);
        FiguresFrame.draw(g);
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
    public void drawFigureWithSquares(Graphics g, int numberOfPoints){
        super.paint(g);
        for (int i = 0; i < (numberOfPoints - 1); i++){
            g.drawLine((int)FiguresArray.getFigure(0).getPoints().get(i).getX(), (int)FiguresArray.getFigure(0).getPoints().get(i).getY(), (int)FiguresArray.getFigure(0).getPoints().get(i+1).getX(), (int)FiguresArray.getFigure(0).getPoints().get(i+1).getY());
            g.setColor(figureColor);
        }
    }

    public void createBlueCircle(Graphics g){
        super.paint(g);
        g.drawOval((int)FiguresArray.getFigure(2).getPoints().get(0).getX(), (int)FiguresArray.getFigure(2).getPoints().get(0).getY(), (int)FiguresArray.getFigure(2).getRadius(), (int)FiguresArray.getFigure(2).getRadius());
        g.setColor(figureColor);
    }
    public static void setFigureColor (String color){
        figureColor = Color.getColor(color);
    }
    public static void rotate (Graphics g, double angle){
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(angle));
    }
}
