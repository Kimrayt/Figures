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
        if(FiguresFrame.getMakeCircle() == true){
            createBlueCircle(g);
        }
        if (FiguresFrame.makeTriangle == true){
            drawFigureWithSquares(g, 3);
        }
        if (FiguresFrame.makePolygon == true){
            drawFigureWithSquares(g, 4);
        }
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
        //super.paint(g);
        //drawGrid(g);
        if (FiguresFrame.getColor() == "Blue"){
            g.setColor(Color.BLUE);}
        else if (FiguresFrame.getColor() == "Yellow"){
            g.setColor(Color.yellow);
        }
        else {
            g.setColor(Color.BLACK);
        }
        for (int i = 0; i < (numberOfPoints - 1); i++){
            g.drawLine(((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(i).getX()+getWidth()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(i).getY()+getHeight()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(i+1).getX()+getWidth()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(i+1).getY())+getHeight()/2);
        }
        g.drawLine(((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(0).getX()+getWidth()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(0).getY()+getHeight()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(numberOfPoints-1).getX()+getWidth()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(numberOfPoints-1).getY()+getHeight()/2));
    }

    public void createBlueCircle(Graphics g){
        //super.paint(g);
        if (FiguresFrame.getColor() == "Blue"){
        g.setColor(Color.BLUE);}
        else if (FiguresFrame.getColor() == "Yellow"){
            g.setColor(Color.yellow);
        }
        else {
            g.setColor(Color.BLACK);
        }
        g.drawOval((int)(FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(0).getX()+getWidth()/2-(int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getRadius()/2), ((int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getPoints().get(0).getY()+getHeight()/2-(int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getRadius()/2), (int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getRadius(), (int)FiguresArray.getFigure(FiguresArray.getLastIndex()).getRadius());
        //drawGrid(g);
    }
    /*public static void setFigureColor (String color){
        figureColor = Color.getColor(color);
    }*/
    public static void rotate (Graphics g, double angle){
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(angle));
    }
}
